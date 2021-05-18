package com.wu.greenfarm.mapper;

import com.wu.greenfarm.pojo.ProductOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductOrderMapper {

    /**
     * 添加产品订单
     * @param productOrder
     * @return
     */
    int addProductOrder(ProductOrder productOrder);


}
