package com.wu.greenfarm.service;

import com.wu.greenfarm.mapper.ProductOrderMapper;
import com.wu.greenfarm.pojo.Product;
import com.wu.greenfarm.pojo.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    ProductOrderMapper productOrderMapper;

    @Override
    public int addProductOrder(ProductOrder productOrder) {
        return productOrderMapper.addProductOrder(productOrder);
    }
}
