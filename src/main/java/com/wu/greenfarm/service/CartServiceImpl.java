package com.wu.greenfarm.service;

import com.wu.greenfarm.mapper.CartMapper;
import com.wu.greenfarm.pojo.Cart;
import com.wu.greenfarm.pojo.CartAdapterItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartMapper cartMapper;

    @Override
    public int addCart(Cart cart) {
        return cartMapper.addCart(cart);
    }

    @Override
    public List<CartAdapterItem> getCartAdapterItem(int customerId) {
        return cartMapper.getCartAdapterItem(customerId);
    }
}
