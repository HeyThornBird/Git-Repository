package com.ruijie.service.impl;

import com.ruijie.bean.AptyProcessInfo;
import com.ruijie.bean.ChaterProcessInfo;
import com.ruijie.bean.Params;
import com.ruijie.exception.MyException;
import com.ruijie.mapper.BpmContactPlmMapper;
import com.ruijie.service.IBpmContactPlmService;
import com.ruijie.util.ProcessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
@Service
public class BpmContactPlmServiceImpl implements IBpmContactPlmService {

    @Autowired
    private BpmContactPlmMapper bpmContactPlmMapper;

    @Override
    public List<ChaterProcessInfo> getCharterProcessInfo(Params params) throws MyException{
        return bpmContactPlmMapper.getChaterProcessInfo(params);
    }

    private static final String ZERO = "0";

    @Override
    public List<AptyProcessInfo> getAptyProcessInfo(Params params) throws MyException {

        List<AptyProcessInfo> results = bpmContactPlmMapper.getAptyProcessInfo(params);

       /* for(AptyProcessInfo a:results){
            String[] productModels = a.getProductModel().split("!");

        }*/
        if(ZERO.equals(params.getFlage())){
            String type = ProcessType.getProcessTypeByProcessId(params.getWf_processid());
            for(AptyProcessInfo a : results){
                a.setProcessFlage(type);
            }
        }


        return results;
    }

}
