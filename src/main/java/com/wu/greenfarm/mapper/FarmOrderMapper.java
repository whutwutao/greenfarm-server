package com.wu.greenfarm.mapper;

import com.wu.greenfarm.pojo.FarmOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FarmOrderMapper {
    //添加订单记录
    int addFarmOrder(FarmOrder farmOrder);

    //处理订单
    int processFarmOrder(@Param("id") int id);

    FarmOrder queryFarmOrderById(@Param("id")int id);

    FarmOrder queryFarmOrderByFarmId(@Param("farmId")int farmId);

    FarmOrder queryFarmOrderByCustomerId(@Param("customerId")int customerId);


    int getCustomerId(@Param("farmId") int farmId);

    List<FarmOrder> queryNotProcessFarmOrderByOwnerId(@Param("farmerId") int farmerId);

    List<FarmOrder> queryProcessedFarmOrderByOwnerId(@Param("farmerId") int farmerId);

    List<FarmOrder> queryNotProcessedFarmOrderByCustomerId(@Param("customerId") int customerId);

    List<FarmOrder> queryProcessedFarmOrderByCustomerId(@Param("customerId") int customerId);
}
