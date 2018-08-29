package com.ruijie.bean;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
public class ChaterProcessInfo {

    private String wf_docNumber;

    private String businessUnit;

    private String wf_addName_cn;

    private String classify;

    private String wf_lastModified;

    private String productDevCode;

    private String productModel;

    private String productDevMode;

    private String productStatus;

    public String getWf_docNumber() {
        return wf_docNumber;
    }

    public void setWf_docNumber(String wf_docNumber) {
        this.wf_docNumber = wf_docNumber;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getWf_addName_cn() {
        return wf_addName_cn;
    }

    public void setWf_addName_cn(String wf_addName_cn) {
        this.wf_addName_cn = wf_addName_cn;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getWf_lastModified() {
        return wf_lastModified;
    }

    public void setWf_lastModified(String wf_lastModified) {
        this.wf_lastModified = wf_lastModified;
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

    public String getProductDevMode() {
        return productDevMode;
    }

    public void setProductDevMode(String productDevMode) {
        this.productDevMode = productDevMode;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return "ChaterProcessInfo{" +
                "wf_docNumber='" + wf_docNumber + '\'' +
                ", businessUnit='" + businessUnit + '\'' +
                ", wf_addName_cn='" + wf_addName_cn + '\'' +
                ", classify='" + classify + '\'' +
                ", wf_lastModified='" + wf_lastModified + '\'' +
                ", productDevCode='" + productDevCode + '\'' +
                ", productModel='" + productModel + '\'' +
                ", productDevMode='" + productDevMode + '\'' +
                ", productStatus='" + productStatus + '\'' +
                '}';
    }
}
