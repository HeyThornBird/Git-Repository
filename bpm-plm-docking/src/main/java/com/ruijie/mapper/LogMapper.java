package com.ruijie.mapper;

import com.ruijie.bean.RecordLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
@Mapper
public interface LogMapper {

    /**
     * 插入日志
     * @param log
     */
    @Insert("INSERT INTO ipd_logs(WF_Orunid,AcceptParameters,backParameters) " +
            "VALUES(#{wfOrunid},#{acceptParameters},#{backParameters})")
    void insertLog(RecordLog log);

}
