package com.wu.greenfarm.mapper;

import com.wu.greenfarm.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper {

    /**
     * 添加农产品
     * @param product
     * @return
     */
    int addProduct(Product product);

    /**
     * 查询所有售卖的农产品
     */
    List<Product> queryAllSaleProduct();

    /**
     * 查询所有用户种植的农产品
     * @return
     */
    List<Product> queryAllPlantProduct();

}
