package com.ruijie.bean;

import com.ruijie.annotation.ValidParamsOnFlag;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
@ValidParamsOnFlag
public class Params {
    @NotNull(message = "startDate不能为null")
    private String startDate;

    @NotNull(message = "endDate不能为null")
    private String endDate;

    @NotBlank(message="flage不能为空串")
    @Pattern(regexp="^(0|1)$", message="flage取值不合法")
    private String flage;

    @NotNull(message = "wf_processid不能为null")
    private String wf_docnumber;

    @NotNull(message = "wf_processid不能为null")
    private String wf_processid;

    @NotNull(message = "wf_docunid不能为null")
    private String wf_docunid;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFlage() {
        return flage;
    }

    public void setFlage(String flage) {
        this.flage = flage;
    }

    public String getWf_docnumber() {
        return wf_docnumber;
    }

    public void setWf_docnumber(String wf_docnumber) {
        this.wf_docnumber = wf_docnumber;
    }

    public String getWf_processid() {
        return wf_processid;
    }

    public void setWf_processid(String wf_processid) {
        this.wf_processid = wf_processid;
    }

    public String getWf_docunid() {
        return wf_docunid;
    }

    public void setWf_docunid(String wf_docunid) {
        this.wf_docunid = wf_docunid;
    }

    @Override
    public String toString() {
        return "Params{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", flage='" + flage + '\'' +
                ", wf_docnumber='" + wf_docnumber + '\'' +
                ", wf_processid='" + wf_processid + '\'' +
                ", wf_docunid='" + wf_docunid + '\'' +
                '}';
    }
}
