package com.wu.greenfarm.service;

import com.wu.greenfarm.mapper.FarmMapper;
import com.wu.greenfarm.mapper.FarmOrderMapper;
import com.wu.greenfarm.mapper.UserMapper;
import com.wu.greenfarm.pojo.FarmOrder;
import com.wu.greenfarm.pojo.FarmOrderBean;
import com.wu.greenfarm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FarmOrderServiceImpl implements FarmOrderService{
    @Autowired
    FarmOrderMapper farmOrderMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    FarmMapper farmMapper;

    @Override
    public int addFarmOrder(int farmId, int customerId, String address) {
        if (userMapper.queryUserById(customerId) != null && farmMapper.queryFarmById(farmId) != null) {
            FarmOrder farmOrder = new FarmOrder();
            farmOrder.setFarmId(farmId);
            farmOrder.setCustomerId(customerId);
            farmOrder.setAddress(address);
            return farmOrderMapper.addFarmOrder(farmOrder);
        } else {
            return -1;
        }
    }

    @Override
    public int processFarmOrder(int id) {
        return farmOrderMapper.processFarmOrder(id);
    }

    @Override
    public User getCustomer(int farmId) {

        FarmOrder farmOrder = farmOrderMapper.queryFarmOrderByFarmId(farmId);
        if (farmOrder == null) {
            return null;
        } else {
            int customerId = farmOrderMapper.getCustomerId(farmId);
            User user = userMapper.queryUserById(customerId);
            return user;
        }
    }

    @Override
    public List<FarmOrderBean> getNotProcessedFarmOrder(int farmerId) {
        List<FarmOrderBean> farmOrderBeanList = new ArrayList<>();
        List<FarmOrder> farmOrderList = farmOrderMapper.queryNotProcessFarmOrderByOwnerId(farmerId);
        for (FarmOrder farmOrder : farmOrderList) {
            int customerId = farmOrder.getCustomerId();
            int farmId = farmOrder.getFarmId();
            FarmOrderBean farmOrderBean = new FarmOrderBean();
            farmOrderBean.setCustomer(userMapper.queryUserById(customerId));
            farmOrderBean.setFarm(farmMapper.queryFarmById(farmId));
            farmOrderBean.setOrder(farmOrder);
            farmOrderBean.setSelected(false);
            farmOrderBeanList.add(farmOrderBean);
        }
        return farmOrderBeanList;
    }

    @Override
    public List<FarmOrderBean> getProcessedFarmOrder(int farmerId) {
        List<FarmOrderBean> farmOrderBeanList = new ArrayList<>();
        List<FarmOrder> farmOrderList = farmOrderMapper.queryProcessedFarmOrderByOwnerId(farmerId);
        for (FarmOrder farmOrder : farmOrderList) {
            int customerId = farmOrder.getCustomerId();
            int farmId = farmOrder.getFarmId();
            FarmOrderBean farmOrderBean = new FarmOrderBean();
            farmOrderBean.setCustomer(userMapper.queryUserById(customerId));
            farmOrderBean.setFarm(farmMapper.queryFarmById(farmId));
            farmOrderBean.setOrder(farmOrder);
            farmOrderBean.setSelected(false);
            farmOrderBeanList.add(farmOrderBean);
        }
        return farmOrderBeanList;
    }

    @Override
    public List<FarmOrderBean> getCustomerNotProcessedFarmOrder(int customerId) {
        List<FarmOrderBean> farmOrderBeanList = new ArrayList<>();
        List<FarmOrder> farmOrderList = farmOrderMapper.queryNotProcessedFarmOrderByCustomerId(customerId);
        for (FarmOrder order : farmOrderList) {
            int farmId = order.getFarmId();
            FarmOrderBean farmOrderBean = new FarmOrderBean();
            farmOrderBean.setCustomer(userMapper.queryUserById(customerId));
            farmOrderBean.setFarm(farmMapper.queryFarmById(farmId));
            farmOrderBean.setOrder(order);
            farmOrderBean.setSelected(false);
            farmOrderBeanList.add(farmOrderBean);
        }
        return farmOrderBeanList;
    }

    @Override
    public List<FarmOrderBean> getCustomerProcessedFarmOrder(int customerId) {
        List<FarmOrderBean> farmOrderBeanList = new ArrayList<>();
        List<FarmOrder> farmOrderList = farmOrderMapper.queryProcessedFarmOrderByCustomerId(customerId);
        for (FarmOrder order : farmOrderList) {
            int farmId = order.getFarmId();
            FarmOrderBean farmOrderBean = new FarmOrderBean();
            farmOrderBean.setCustomer(userMapper.queryUserById(customerId));
            farmOrderBean.setFarm(farmMapper.queryFarmById(farmId));
            farmOrderBean.setOrder(order);
            farmOrderBean.setSelected(false);
            farmOrderBeanList.add(farmOrderBean);
        }
        return farmOrderBeanList;
    }
}
