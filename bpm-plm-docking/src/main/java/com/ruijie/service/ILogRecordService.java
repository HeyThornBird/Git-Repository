package com.ruijie.service;

import com.ruijie.bean.Params;

import java.util.List;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
public interface ILogRecordService {
    /**
     * 插入日志到表 ipd_logs
     * @param inputParamStr 入参
     * @param responseResultStr 返回结果
     */
    void recordLog(String inputParamStr, String responseResultStr);
}
