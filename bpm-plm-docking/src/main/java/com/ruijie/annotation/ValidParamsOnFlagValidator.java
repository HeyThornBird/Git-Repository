package com.ruijie.annotation;

import com.ruijie.bean.Params;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 * 参数的验证注解
 */
public class ValidParamsOnFlagValidator implements ConstraintValidator<ValidParamsOnFlag,Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidParamsOnFlagValidator.class);

    private static final String ZERO = "0";

    @Override
    public void initialize(ValidParamsOnFlag validParamsOnFlag) {
        LOGGER.info("init validator");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Params params = (Params) o;
        if(ZERO.equals(params.getFlage())){
            if(StringUtils.isNotEmpty(params.getWf_docnumber())&&
                    StringUtils.isNotEmpty(params.getWf_docunid())&&
                    StringUtils.isNotEmpty(params.getWf_processid())){
                return true;
            }
        }else{
            if(StringUtils.isNotEmpty(params.getStartDate())&&
                    StringUtils.isNotEmpty(params.getEndDate())){
                return true;
            }

        }
        return false;
    }
}
