package com.ruijie.service;

import com.ruijie.bean.AptyProcessInfo;
import com.ruijie.bean.ChaterProcessInfo;
import com.ruijie.bean.Params;
import com.ruijie.exception.MyException;

import java.util.List;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
public interface IBpmContactPlmService {
    /**
     * 从Bpm获取数据
     * @param params
     * @return
     * @throws MyException
     */
    List<ChaterProcessInfo> getCharterProcessInfo(Params params) throws MyException;

    /**
     * 从Bpm获取数据
     * @return
     * @throws MyException
     */
    List<AptyProcessInfo> getAptyProcessInfo(Params params) throws MyException;
}
