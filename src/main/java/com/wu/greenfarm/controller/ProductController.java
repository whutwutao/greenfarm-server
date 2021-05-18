package com.wu.greenfarm.controller;

import com.google.gson.Gson;
import com.sun.xml.internal.rngom.digested.DValuePattern;
import com.wu.greenfarm.pojo.Category;
import com.wu.greenfarm.pojo.Product;
import com.wu.greenfarm.service.ProductService;
import com.wu.greenfarm.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/getAllProduct")
    public List<Product> getAllProduct() {
        return productService.getProductLimit(0,6);
    }

    /**
     * 带分页的按类别查询
     * @param request
     * @return
     */
    @RequestMapping(value ="/getProductByCategoryLimit")
    public List<Product> getProductByCategoryLimit(@RequestBody HashMap<String,String> request) {
        if (request != null) {
            String jsonCategory = request.get("category");
            String strStart = request.get("start");
            String strLen = request.get("len");
            System.out.println(jsonCategory);
            System.out.println(strStart);
            System.out.println(strLen);
            Category category = new Gson().fromJson(jsonCategory,Category.class);
            int start = Integer.parseInt(strStart);
            int len = Integer.parseInt(strLen);
            if (category == null) {
                System.out.println("category is null");
                return productService.getProductLimit(start, len);
            } else {

                return productService.getProductByCategoryLimit(category.getId(),start,len);
            }
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/getProductByName", method = RequestMethod.POST)
    public List<Product> getProductByName(@RequestBody HashMap<String,String> request) {
        if (request != null) {
            String name = request.get("name");
            return productService.getProductByName(name);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/addProduct")
    public HashMap<String,String> addProduct(@RequestBody HashMap<String,String> request) {
        HashMap<String,String> res = new HashMap<>();
        if (request != null) {
            String name = request.get("name");
            String description = request.get("description");
            String strPrice = request.get("price");
            String strCategoryId = request.get("categoryId");
            String strFarmerId = request.get("farmerId");
            String encodePictureText = request.get("picture");

            System.out.println("name:" + name);
            System.out.println("description:" + description);
            System.out.println("strPrice:" + strPrice);
            System.out.println("strCategoryId:" + strCategoryId);
            System.out.println("farmerId:" + strFarmerId);
            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setFarmerId(Integer.parseInt(strFarmerId));
            product.setCategory(Integer.parseInt(strCategoryId));
            product.setPrice(Double.parseDouble(strPrice));

            String pictureFilename = ImageUtil.getFileName(Integer.parseInt(strFarmerId));
            String pictureWritePath = ImageUtil.getProductFilePath(pictureFilename);
            String pictureUrl = ImageUtil.getPictureUrl("product",pictureFilename);
            ImageUtil.decodeAndWrite(encodePictureText,pictureWritePath);
            product.setPictureUrl(pictureUrl);
            System.out.println(product);
            if (productService.addProduct(product) > 0) {
                res.put("result","success");
            } else {
                res.put("result","fail");
            }
        } else {
            res.put("result","fail");
        }
        return res;
    }
}
