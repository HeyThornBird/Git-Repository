package com.ruijie.service;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
public interface IValidService {
    /**
     * 判断产品型号是否存在
     * @param productModel 产品型号
     * @return 如果存在返回"Y",不存在返回"N"
     */
    String isProductModelRepeat(String productModel);

    /**
     * 通过产品研发代码判断产品型号是否有库存
     * @param productDevCode 产品研发代码
     * @return 如果存在返回"Y",不存在返回"N"
     */
    String haveInventoryByProDevCode(String productDevCode);
}
