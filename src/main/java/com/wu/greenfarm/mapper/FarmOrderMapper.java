package com.wu.greenfarm.mapper;

import com.wu.greenfarm.pojo.FarmOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FarmOrderMapper {
    //添加订单记录
    int addFarmOrder(FarmOrder farmOrder);

    FarmOrder queryFarmOrderById(@Param("id")int id);

    FarmOrder queryFarmOrderByFarmId(@Param("farmId")int farmId);

    FarmOrder queryFarmOrderByCustomerId(@Param("customerId")int customerId);


    int getCustomerId(@Param("farmId") int farmId);

}
