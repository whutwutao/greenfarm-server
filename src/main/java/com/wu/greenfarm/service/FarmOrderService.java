package com.wu.greenfarm.service;

import com.wu.greenfarm.pojo.FarmOrderBean;
import com.wu.greenfarm.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FarmOrderService {
    int addFarmOrder(int farmId, int customerId);

    int processFarmOrder(int id);

    User getCustomer(int farmId);

    List<FarmOrderBean> getNotProcessedFarmOrder(int farmerId);

    List<FarmOrderBean> getProcessedFarmOrder(int farmerId);

    List<FarmOrderBean> getCustomerNotProcessedFarmOrder(int customerId);

    List<FarmOrderBean> getCustomerProcessedFarmOrder(int customerId);
}
