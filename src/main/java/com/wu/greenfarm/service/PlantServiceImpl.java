package com.wu.greenfarm.service;

import com.wu.greenfarm.mapper.PlantMapper;
import com.wu.greenfarm.pojo.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantServiceImpl implements PlantService {

    @Autowired
    PlantMapper plantMapper;

    @Override
    public int addPlant(Plant plant) {
        return plantMapper.addPlant(plant);
    }

    @Override
    public List<Plant> getCustomerPlantList(int customerId) {
        return plantMapper.queryPlantByCustomerId(customerId);
    }
}
