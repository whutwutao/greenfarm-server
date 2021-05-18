package com.wu.greenfarm.controller;

import com.google.gson.Gson;
import com.wu.greenfarm.pojo.Product;
import com.wu.greenfarm.pojo.ProductOrder;
import com.wu.greenfarm.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ProductOrderController {

    @Autowired
    ProductOrderService productOrderService;

    @RequestMapping(value = "/addProductOrder")
    public HashMap<String,String> addProductOrder(@RequestBody HashMap<String,String> request) {
        HashMap<String,String> res = new HashMap<>();
        if (request == null) {
            res.put("result","fail");
        } else {
            String jsonProduct = request.get("product");
            String strCustomerId = request.get("customerId");
            String strAmount = request.get("amount");
            String strMoney = request.get("money");
            String address = request.get("address");
            Product product = new Gson().fromJson(jsonProduct,Product.class);
            int customerId = Integer.parseInt(strCustomerId);
            int amount = Integer.parseInt(strAmount);
            double money = Double.parseDouble(strMoney);
            ProductOrder productOrder = new ProductOrder();
            productOrder.setProductId(product.getId());
            productOrder.setCustomerId(customerId);
            productOrder.setMoney(money);
            productOrder.setAmount(amount);
            productOrder.setStatus(0);
            productOrder.setFarmerId(product.getFarmerId());
            productOrder.setAddress(address);
            if (productOrderService.addProductOrder(productOrder) > 0) {
                res.put("result","success");
            } else {
                res.put("result","fail");
            }
        }
        return res;
    }

}
