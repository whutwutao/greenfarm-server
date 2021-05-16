package com.wu.greenfarm.service;

import com.wu.greenfarm.mapper.FarmMapper;
import com.wu.greenfarm.mapper.UserMapper;
import com.wu.greenfarm.pojo.Farm;
import com.wu.greenfarm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService{

    @Autowired
    UserMapper userMapper;

    @Autowired
    FarmMapper farmMapper;

    @Override
    public int addFarm(Farm farm) {
        int ownerId = farm.getOwnerId();
        User user = userMapper.queryUserById(ownerId);
        if (user == null) {//因为owner_id是t_user的主键，所以要确保在t_user中存在其对应的记录
            return -1;
        } else {
            return farmMapper.addFarm(farm);
        }
    }

    @Override
    public List<Farm> getAllFarm() {
        return farmMapper.queryAllFarm();
    }

    @Override
    public List<Farm> getFarmLimit(int start, int len) {
        return farmMapper.queryFarmLimit(start, len);
    }

    @Override
    public List<Farm> getFarmByOwnerId(int ownerId) {
        return farmMapper.queryFarmByOwnerId(ownerId);
    }

    @Override
    public int setFarmSentOut(int farmId) {
        return farmMapper.setFarmRentOut(farmId);
    }

    @Override
    public List<Farm> searchFarmByCondition(String condition) {
        return farmMapper.queryFarmByCondition(condition);
    }

    @Override
    public List<Farm> getCustomerFarmList(User user) {
        return farmMapper.queryFarmByCustomerId(user.getId());
    }

    @Override
    public List<Farm> getFarmByMultiCondition(String address, String description, double areaMin, double areaMax, double priceMin, double priceMax, int serviceLifeMin, int serviceLifeMax) {
        return farmMapper.queryFarmByMultiCondition(address, description, areaMin, areaMax, priceMin, priceMax, serviceLifeMin, serviceLifeMax);
    }
}
