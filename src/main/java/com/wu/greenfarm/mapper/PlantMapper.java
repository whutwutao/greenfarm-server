package com.wu.greenfarm.mapper;

import com.wu.greenfarm.pojo.Plant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PlantMapper {
    /**
     * 添加种植记录
     * @param plant
     * @return
     */
    int addPlant(Plant plant);

    /**
     * 根据客户id和农场id查询种植记录
     * @param id
     * @return
     */
    List<Plant> queryPlantByCustomerIdAndFarmId(@Param("customerId") int id, @Param("farmId") int farmId);

    /**
     * 根据农场id查询种植记录
     * @param farmId
     * @return
     */
    List<Plant> queryPlantByFarmId(@Param("farmId") int farmId);

    /**
     * 设置Plant状态
     * @param plant
     * @return
     */
    int setPlantStatus(Plant plant);
}
