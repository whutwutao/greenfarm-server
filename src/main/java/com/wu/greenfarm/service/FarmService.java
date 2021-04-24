package com.wu.greenfarm.service;

import com.wu.greenfarm.pojo.Farm;
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
}
