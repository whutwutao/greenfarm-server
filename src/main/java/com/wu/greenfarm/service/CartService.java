package com.wu.greenfarm.service;

import com.wu.greenfarm.pojo.Cart;
import com.wu.greenfarm.pojo.CartAdapterItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    int addCart(Cart cart);

    /**
     * 批量删除购物车
     * @param cartIdList
     * @return
     */
    int deleteCartList(List<Integer> cartIdList);

    List<CartAdapterItem> getCartAdapterItem(int customerId);
}
