package com.ruijie.controller;

import com.ruijie.bean.AptyProcessInfo;
import com.ruijie.bean.ChaterProcessInfo;
import com.ruijie.bean.Params;
import com.ruijie.service.IBpmContactPlmService;
import com.ruijie.service.ILogRecordService;
import com.ruijie.util.ReturnUtil;
import com.ruijie.util.StatusCode;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
@RestController
@RequestMapping("/bpm")
public class BpmContactPlmController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BpmContactPlmController.class);

    @Autowired
    private IBpmContactPlmService bpmContactPlmService;

    @Autowired
    private ILogRecordService logService;

    /**
     * charter评审对接PLM
     * 获取charter流程的相关数据，供plm系统调用
     * @param params 入参
     * @param bindingResult 参数校验结果
     * @return charter流程的相关数据
     */
    @PostMapping(value = "/charter")
    public String getCharterProcessInfo(@RequestBody @Valid Params params, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                String errMsg = this.getValidParamsErrorMsg(bindingResult);
                LOGGER.info("charter对接PLM接口参数不合法:{}",errMsg);
                return ReturnUtil.getJsonResultStr(StatusCode.PARAM_ILLEGAL,null,errMsg);
            }
            LOGGER.info("charter对接PLM接口入参:{}",params);
            //查询结果
            List<ChaterProcessInfo> results = bpmContactPlmService.getCharterProcessInfo(params);
            JsonConfig jc= new JsonConfig();
            jc.setExcludes(new String[]{"productStatus"});
            //记录日志
            logService.recordLog(params.toString(),results.toString());
            return ReturnUtil.getJsonResultStr(StatusCode.SUCCESS,JSONArray.fromObject(results,jc),"");
        }catch (Exception e){
            LOGGER.warn("charter对接PLM接口出错信息如下:{}",e.toString());
            return ReturnUtil.getJsonResultStr(StatusCode.ERROR,null,"服务出错");
        }
    }

    /**
     * ADCP、特批、停产、预停产对接PLM
     * 获取 ADCP（A）,特批（P），停产（T），预停产（Y）四个流程的相关信息，供plm系统调用
     * @param params  入参
     * @param bindingResult 参数校验结果
     * @return A，P,T,Y流程的相关信息
     */
    @PostMapping(value = "/apty")
    public String getAptyProcessInfo(@RequestBody @Valid Params params, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                String errMsg = this.getValidParamsErrorMsg(bindingResult);
                LOGGER.info("apty接口参数不合法:{}",errMsg);
                return ReturnUtil.getJsonResultStr(StatusCode.PARAM_ILLEGAL,null,errMsg);
            }
            LOGGER.info("apty接口入参:{}",params);
            //查询结果
            List<AptyProcessInfo> results = bpmContactPlmService.getAptyProcessInfo(params);
            //记录日志
            logService.recordLog(params.toString(),results.toString());
            return ReturnUtil.getJsonResultStr(StatusCode.SUCCESS,results,"");
        }catch (Exception e){
            LOGGER.warn("apty接口出错信息如下:{}",e.toString());
            return ReturnUtil.getJsonResultStr(StatusCode.ERROR,null,"服务出错");
        }
    }

    /**
     * Charter变更
     * @param params 入参
     * @param bindingResult 参数校验结果
     * @return Charter变更的相关信息
     */
    @PostMapping(value = "/charterchange")
    public String getCharterChangeInfo(@RequestBody @Valid Params params, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                String errMsg = this.getValidParamsErrorMsg(bindingResult);
                LOGGER.info("charter变更参数不合法:{}",errMsg);
                return ReturnUtil.getJsonResultStr(StatusCode.PARAM_ILLEGAL,null,errMsg);
            }
            LOGGER.info("charter变更接口入参:{}",params);
            //TODO 这里的逻辑还有待梳理, sql查询条件是否和上面相同？

            List<ChaterProcessInfo> results = bpmContactPlmService.getCharterProcessInfo(params);
            //记录日志
            logService.recordLog(params.toString(),results.toString());
            return ReturnUtil.getJsonResultStr(StatusCode.SUCCESS,results,"");
        }catch (Exception e){
            LOGGER.warn("charter变更接口出错信息如下:{}",e.toString());
            return ReturnUtil.getJsonResultStr(StatusCode.ERROR,null,"服务出错");
        }
    }



    /**
     * 获取参数校验错误信息
     * @param bindingResult  参数校验结果
     * @return 参数校验错误信息
     */
    private String getValidParamsErrorMsg(BindingResult bindingResult){
        if(bindingResult.getGlobalError()!=null){
            return bindingResult.getGlobalError().getDefaultMessage();
        }else{
            return bindingResult.getFieldError().getDefaultMessage();
        }
    }
}
