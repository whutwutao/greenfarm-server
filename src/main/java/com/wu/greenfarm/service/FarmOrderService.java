package com.wu.greenfarm.service;

import com.wu.greenfarm.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface FarmOrderService {
    int addFarmOrder(int farmId, int customerId);

    User getCustomer(int farmId);
}
