package com.wu.greenfarm.service;

import com.wu.greenfarm.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
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
