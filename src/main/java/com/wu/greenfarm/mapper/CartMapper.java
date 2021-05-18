package com.wu.greenfarm.mapper;

import com.wu.greenfarm.pojo.Cart;
import com.wu.greenfarm.pojo.CartAdapterItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartMapper {
    /**
     * 添加购物车
     * @param cart
     * @return
     */
    int addCart(Cart cart);

    /**
     * 删除购物车
     * @param id
     * @return
     */
    int deleteCart(@Param("id") int id);

    /**
     * 按客户id查询购物车
     * @param customerId
     * @return
     */
    List<Cart> getCartByCustomerId(@Param("customerId") int customerId);

    /**
     *
     * @param customerId
     * @return
     */
    List<CartAdapterItem> getCartAdapterItem(@Param("customerId") int customerId);
}
