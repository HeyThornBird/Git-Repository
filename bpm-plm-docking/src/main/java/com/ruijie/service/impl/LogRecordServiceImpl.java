package com.ruijie.service.impl;

import com.ruijie.bean.Params;
import com.ruijie.bean.RecordLog;
import com.ruijie.mapper.LogMapper;
import com.ruijie.service.ILogRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
@Service
public class LogRecordServiceImpl implements ILogRecordService{

    @Autowired
    private LogMapper logMapper;

    @Override
    public void recordLog(String inputParamStr, String responseResultStr){
        RecordLog recordLog = new RecordLog();
        recordLog.setWfOrunid(UUID.randomUUID().toString().replace("-", ""));
        recordLog.setAcceptParameters(inputParamStr);
        recordLog.setBackParameters(responseResultStr);
        logMapper.insertLog(recordLog);
    }
}
