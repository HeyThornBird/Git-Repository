package com.ruijie.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruijie.service.ILogRecordService;
import com.ruijie.service.IValidService;
import com.ruijie.util.ReturnUtil;
import com.ruijie.util.StatusCode;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
@RestController
@RequestMapping("/valid")
public class ValidController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidController.class);

    private static final String EXIST = "Y";

    @Autowired
    private IValidService valideService;

    @Autowired
    private ILogRecordService logService;

    /**
     * 判断产品型号是否已经存在
     * @param productModel 产品型号
     * @return  返回结果
     */
    @PostMapping(value = "/productmodel")
    public String isProductModelRepeat(@RequestBody JSONObject productModel){
        try {
            String productModelStr = productModel.getString("productModel");
            if(StringUtils.isBlank(productModelStr)){
                return ReturnUtil.getJsonResultStr(StatusCode.PARAM_ILLEGAL,null,"参数不能为空串");
            }
            LOGGER.info("接口入参:{}",productModelStr);
            //如果存在是"Y"  不存在是"N"
            String isValid = valideService.isProductModelRepeat(productModelStr);

            JSONObject result = new JSONObject();
            result.put("status",isValid);
            if(EXIST.equals(isValid)){
                result.put("info","产品型号已存在，请重新输入");
            }else{
                result.put("info","产品型号没有重复，可以使用");
            }
            return ReturnUtil.getJsonResultStr(StatusCode.SUCCESS,result,"");
        }catch (Exception e){
            LOGGER.warn("出错信息如下:{}",e.toString());
            return ReturnUtil.getJsonResultStr(StatusCode.ERROR,null,"服务出错");
        }
    }

    /**
     * 通过产品研发代码判断产品型号是否有库存
     * @param productDevCode 入参
     * @return 返回结果
     */
    @PostMapping(value = "/produtdevcode")
    public String haveInventoryByProDevCode(@RequestBody JSONObject productDevCode){
        try {
            String productDevCodeStr = productDevCode.getString("productDevCode");
            if(StringUtils.isBlank(productDevCodeStr)){
                return ReturnUtil.getJsonResultStr(StatusCode.PARAM_ILLEGAL,null,"参数不能为空串");
            }
            LOGGER.info("接口入参:{}",productDevCodeStr);
            //如果存在是"Y"  不存在是"N"
            String haveInventory = valideService.haveInventoryByProDevCode(productDevCodeStr);

            JSONObject result = new JSONObject();
            result.put("status",haveInventory);
            if(EXIST.equals(haveInventory)){
                result.put("info","产品型号有库存，不能做变更操作");
            }else{
                result.put("info","产品型号没有重复，可以使用");
            }
            return ReturnUtil.getJsonResultStr(StatusCode.SUCCESS,result,"");
        }catch (Exception e){
            LOGGER.warn("出错信息如下:{}",e.toString());
            return ReturnUtil.getJsonResultStr(StatusCode.ERROR,null,"服务出错");
        }
    }

}
