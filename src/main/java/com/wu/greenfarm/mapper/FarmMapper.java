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

    Farm queryFarmById(@Param("id")int id);

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

    /**
     * 将农场设置为已出租
     * @param id
     * @return
     */
    int setFarmRentOut(@Param("id")int id);

    /**
     * 按条件查询
     * @param condition
     * @return
     */
    List<Farm> queryFarmByCondition(String condition);

    /**
     * 按租赁用户查询农场
     * @param id
     * @return
     */
    List<Farm> queryFarmByCustomerId(@Param("id")int id);

    /**
     * 多条件查询
     * @param address
     * @param areaMin
     * @param areaMax
     * @param priceMin
     * @param priceMax
     * @param description
     * @param serviceLifeMin
     * @param serviceLifeMax
     * @return
     */
    List<Farm> queryFarmByMultiCondition(String address,
                                         String description,
                                         @Param("areaMin")double areaMin, @Param("areaMax")double areaMax,
                                         @Param("priceMin")double priceMin, @Param("priceMax")double priceMax,
                                         @Param("serviceLifeMin")int serviceLifeMin, @Param("serviceLifeMax")int serviceLifeMax);
}
