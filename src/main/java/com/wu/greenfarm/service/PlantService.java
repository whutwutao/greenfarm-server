package com.wu.greenfarm.service;

import com.wu.greenfarm.pojo.Plant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlantService {

    int addPlant(Plant plant);

    /**
     * 根据用户id获取种植记录
     * @param customerId
     * @return
     */
    List<Plant> getCustomerPlantList(int customerId, int farmId);

    /**
     * 根据农场id获取种植记录
     * @param farmId
     * @return
     */
    List<Plant> getFarmerPlantList(int farmId);

    /**
     * 设置种植状态
     * @param plant
     * @return
     */
    int setPlantStatus(Plant plant);
}
