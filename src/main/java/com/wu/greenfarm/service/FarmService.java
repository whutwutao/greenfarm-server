package com.wu.greenfarm.service;

import com.wu.greenfarm.pojo.Farm;
import com.wu.greenfarm.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FarmService {
    /**
     * 发布农场信息
     * @param farm
     * @return
     */
    int addFarm(Farm farm);

    /**
     * 获取所有农场
     * @return
     */
    List<Farm> getAllFarm();

    /**
     * 分页获取未出租的农场列表
     * @param start
     * @param len
     * @return
     */
    List<Farm> getFarmLimit(int start, int len);


    List<Farm> getFarmByOwnerId(int ownerId);

    /**
     * 将农场设置为已出租
     * @param farmId
     * @return
     */
    int setFarmSentOut(int farmId);

    /**
     * 按条件查询农场
     * @param condition
     * @return
     */
    List<Farm> searchFarmByCondition(String condition);

    /**
     * 获取用户租赁的农场列表
     * @param user
     * @return
     */
    List<Farm> getCustomerFarmList(User user);

    /**
     * 多条件查询农场
     * @param address
     * @param description
     * @param areaMin
     * @param areaMax
     * @param priceMin
     * @param priceMax
     * @param serviceLifeMin
     * @param serviceLifeMax
     * @return
     */
    List<Farm> getFarmByMultiCondition(String address,
                                       String description,
                                       double areaMin, double areaMax,
                                       double priceMin, double priceMax,
                                       int serviceLifeMin, int serviceLifeMax);
}
