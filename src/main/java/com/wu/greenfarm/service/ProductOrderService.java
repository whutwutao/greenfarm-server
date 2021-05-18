package com.wu.greenfarm.service;

import com.wu.greenfarm.pojo.ProductOrder;
import org.springframework.stereotype.Service;

@Service
public interface ProductOrderService {
    /**
     * 添加产品订单
     * @param productOrder
     * @return
     */
    int addProductOrder(ProductOrder productOrder);
}
