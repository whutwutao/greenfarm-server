package com.wu.greenfarm.controller;

import com.wu.greenfarm.pojo.Category;
import com.wu.greenfarm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/getAllCategory")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

}
