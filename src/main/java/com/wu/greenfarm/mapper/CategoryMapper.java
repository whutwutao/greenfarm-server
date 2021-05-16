package com.wu.greenfarm.mapper;

import com.wu.greenfarm.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {
    /**
     * 添加类别
     * @param category
     * @return
     */
    int addCategory(Category category);

    /**
     * 获取所有类别
     * @return
     */
    List<Category> getAllCategory();
}
