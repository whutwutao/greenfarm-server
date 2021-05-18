package com.wu.greenfarm.controller;

import com.wu.greenfarm.pojo.Cart;
import com.wu.greenfarm.pojo.CartAdapterItem;
import com.wu.greenfarm.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping(value = "/addCart")
    public HashMap<String,String> addCart(@RequestBody Cart cart) {
        HashMap<String,String> res = new HashMap<>();
        if (cart != null) {
            if (cartService.addCart(cart) > 0) {
                res.put("result","success");
            } else {
                res.put("result","fail");
            }
        } else {
            res.put("result","fail");
        }
        return res;
    }

    @RequestMapping(value = "/getCartAdapterItem")
    public List<CartAdapterItem> getCartAdapterItem(@RequestBody HashMap<String,String> request) {
        if (request != null) {
            String strCustomerId = request.get("customerId");
            int customerId = Integer.parseInt(strCustomerId);
            return cartService.getCartAdapterItem(customerId);
        } else {
            return null;
        }
    }

}
