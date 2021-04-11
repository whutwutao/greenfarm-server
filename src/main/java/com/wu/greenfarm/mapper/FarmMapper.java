package com.wu.greenfarm.mapper;

import com.wu.greenfarm.pojo.Farm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FarmMapper {

    /**
     * 添加农场
     * @param farm
     * @return
     */
    int addFarm(Farm farm);

    /**
     * 根据拥有者的id查询农场
     * @param ownerId
     * @return
     */
    List<Farm> queryFarmByOwnerId(@Param("ownerId") int ownerId);

    /**
     * 查询所有农场
     * @return
     */
    List<Farm> queryAllFarm();

    /**
     * 分页查询
     * @param start
     * @param len
     * @return
     */
    List<Farm> queryFarmLimit(@Param("start") int start, @Param("len") int len);
}
