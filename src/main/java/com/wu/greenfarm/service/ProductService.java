package com.wu.greenfarm.service;

import com.wu.greenfarm.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    /**
     * 获取所有产品
     * @return
     */
    List<Product> getProductLimit(int start, int len);

    /**
     * 不带分页的按类别查询
     * @param categoryId
     * @return
     */
    List<Product> getProductByCategory(int categoryId);

    /**
     * 按类别查询产品，带分页功能
     * @param categoryId
     * @param start
     * @param len
     * @return
     */
    List<Product> getProductByCategoryLimit(int categoryId, int start, int len);

    /**
     * 按名称查找
     * @param name
     * @return
     */
    List<Product> getProductByName(String name);

    /**
     * 添加产品
     * @param product
     * @return
     */
    int addProduct(Product product);
}
