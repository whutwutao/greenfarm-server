package com.wu.greenfarm.service;

import com.wu.greenfarm.pojo.Cart;
import com.wu.greenfarm.pojo.CartAdapterItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    int addCart(Cart cart);

    List<CartAdapterItem> getCartAdapterItem(int customerId);
}
