package com.ruijie.bean;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
public class RecordLog {

    private String wfOrunid;
    /**
     * 数据库自动生成此项非必填
     */
    private String requestTime;

    private String acceptParameters;

    private String backParameters;

    public String getWfOrunid() {
        return wfOrunid;
    }

    public void setWfOrunid(String wfOrunid) {
        this.wfOrunid = wfOrunid;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getAcceptParameters() {
        return acceptParameters;
    }

    public void setAcceptParameters(String acceptParameters) {
        this.acceptParameters = acceptParameters;
    }

    public String getBackParameters() {
        return backParameters;
    }

    public void setBackParameters(String backParameters) {
        this.backParameters = backParameters;
    }
}
