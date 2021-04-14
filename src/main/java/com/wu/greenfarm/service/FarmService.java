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
    int publish(Farm farm);

    /**
     * 获取所有农场
     * @return
     */
    List<Farm> getAllFarm();

    List<Farm> getFarmLimit(int start, int len);
}