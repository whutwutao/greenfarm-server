package com.wu.greenfarm.service;

import com.wu.greenfarm.pojo.ProductOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductOrderService {
    /**
     * 添加产品订单
     * @param productOrder
     * @return
     */
    int addProductOrder(ProductOrder productOrder);

    /**
     * 批量添加产品订单（清空购物车)
     * @param productOrderList
     * @return
     */
    int addProductOrderList(List<ProductOrder> productOrderList);
}
