package com.ruijie.service.impl;

import com.ruijie.mapper.ValidMapper;
import com.ruijie.service.IValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
@Service
public class ValidServiceImpl implements IValidService{

    @Autowired
    ValidMapper validMapper;

    @Override
    public String isProductModelRepeat(String productModel) {
        int productModelCount = validMapper.isProductModelRepeat(productModel);
        if(productModelCount == 0){
            return "N";
        }else{
            return "Y";
        }
    }

    @Override
    public String haveInventoryByProDevCode(String productDevCode) {
        int productModelCount = validMapper.haveInventoryByProDevCode(productDevCode);
        if(productModelCount == 0){
            return "N";
        }else{
            return "Y";
        }
    }
}
