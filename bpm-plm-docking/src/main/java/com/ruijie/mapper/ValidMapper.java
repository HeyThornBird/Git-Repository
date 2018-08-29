package com.ruijie.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
@Mapper
public interface ValidMapper {

    @Select("SELECT COUNT(T.productModel) FROM(SELECT pdm_ProductModel AS productModel FROM pdm_information_list_cg UNION SELECT pdm_ProductModel AS productModel FROM pdm_information_list_fc) AS T \n" +
            "WHERE T.productModel REGEXP '(^${productModel}!)|(!${productModel}$)|(!${productModel}!)|(^${productModel}$)'")
    int isProductModelRepeat(@Param("productModel")String productModel);

    @Select("SELECT COUNT(*) FROM pdm_information_list_cg")
    int haveInventoryByProDevCode(String productDevCode);
}

