package com.wu.greenfarm.service;

import org.springframework.stereotype.Service;

@Service
public interface FarmOrderService {
    int addFarmOrder(int farmId, int customerId);
}
