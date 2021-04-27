package com.wu.greenfarm.service;

import com.wu.greenfarm.mapper.FarmMapper;
import com.wu.greenfarm.mapper.FarmOrderMapper;
import com.wu.greenfarm.mapper.UserMapper;
import com.wu.greenfarm.pojo.FarmOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmOrderServiceImpl implements FarmOrderService{
    @Autowired
    FarmOrderMapper farmOrderMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    FarmMapper farmMapper;

    @Override
    public int addFarmOrder(int farmId, int customerId) {
        if (userMapper.queryUserById(customerId) != null && farmMapper.queryFarmById(farmId) != null) {
            FarmOrder farmOrder = new FarmOrder();
            farmOrder.setFarmId(farmId);
            farmOrder.setCustomerId(customerId);
            return farmOrderMapper.addFarmOrder(farmOrder);
        } else {
            return -1;
        }
    }
}
