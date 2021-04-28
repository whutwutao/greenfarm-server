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
     * 根据客户id查询种植记录
     * @param id
     * @return
     */
    List<Plant> queryPlantByCustomerId(@Param("id") int id);
}
