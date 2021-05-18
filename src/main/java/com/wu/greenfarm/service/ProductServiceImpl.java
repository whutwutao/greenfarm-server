package com.wu.greenfarm.service;

import com.wu.greenfarm.mapper.ProductMapper;
import com.wu.greenfarm.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> getProductLimit(int start, int len) {
        return productMapper.getProductLimit(start, len);
    }

    @Override
    public List<Product> getProductByCategory(int categoryId) {
        return getProductByCategory(categoryId);
    }

    @Override
    public List<Product> getProductByCategoryLimit(int categoryId, int start, int len) {
        return productMapper.getProductByCategoryLimit(categoryId, start, len);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productMapper.getProductByName(name);
    }

    @Override
    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }
}
