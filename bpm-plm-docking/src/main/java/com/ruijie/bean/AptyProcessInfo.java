package com.ruijie.bean;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
public class AptyProcessInfo {

    private String wf_docNumber;

    private String wf_lastModified;

    private String lifecycle;

    private String processFlage;

    private String productDevCode;

    private String productModel;


    public String getWf_docNumber() {
        return wf_docNumber;
    }

    public void setWf_docNumber(String wf_docNumber) {
        this.wf_docNumber = wf_docNumber;
    }

    public String getWf_lastModified() {
        return wf_lastModified;
    }

    public void setWf_lastModified(String wf_lastModified) {
        this.wf_lastModified = wf_lastModified;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
    }

    public String getProcessFlage() {
        return processFlage;
    }

    public void setProcessFlage(String processFlage) {
        this.processFlage = processFlage;
    }

    public String getProductDevCode() {
        return productDevCode;
    }

    public void setProductDevCode(String productDevCode) {
        this.productDevCode = productDevCode;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    @Override
    public String toString() {
        return "AptyProcessInfo{" +
                "wf_docNumber='" + wf_docNumber + '\'' +
                ", wf_lastModified='" + wf_lastModified + '\'' +
                ", lifecycle='" + lifecycle + '\'' +
                ", processFlage='" + processFlage + '\'' +
                ", productDevCode='" + productDevCode + '\'' +
                ", productModel='" + productModel + '\'' +
                '}';
    }
}
