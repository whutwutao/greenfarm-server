package com.wu.greenfarm.mapper;

import com.wu.greenfarm.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
     * 不带查询条件的分页查询
     * @param start
     * @param len
     * @return
     */
    List<Product> getProductLimit(@Param("start") int start, @Param("len") int len);

    /**
     * 不带分页的按类别查询
     * @param categoryId
     * @return
     */
    List<Product> getProductByCategory(@Param("categoryId") int categoryId);

    /**
     * 根据类别查找农产品，带分页功能
     * @param categoryId
     * @return
     */
    List<Product> getProductByCategoryLimit(@Param("categoryId") int categoryId, @Param("start") int start, @Param("len") int len);

    /**
     * 按名称查找农产品
     * @param name
     * @return
     */
    List<Product> getProductByName(@Param("name") String name);
}
