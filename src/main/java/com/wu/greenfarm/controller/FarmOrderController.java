package com.wu.greenfarm.controller;

import com.wu.greenfarm.pojo.FarmOrderBean;
import com.wu.greenfarm.pojo.User;
import com.wu.greenfarm.service.FarmOrderService;
import com.wu.greenfarm.service.FarmService;
import com.wu.greenfarm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FarmOrderController {
    @Autowired
    FarmOrderService farmOrderService;

    @Autowired
    UserService userService;

    @Autowired
    FarmService farmService;
    @RequestMapping(value = "/addFarmOrder", method = RequestMethod.POST)
    public Map<String,String> addFarmOrderController(@RequestBody Map<String,Integer> map) {
        HashMap<String,String> result = new HashMap<>();
        if (map == null) {
            result.put("result","the data is null");
        } else {
            int farmId = map.get("farmId");
            int customerId = map.get("customerId");
            System.out.println("farmId:"+farmId);
            System.out.println("customerId:"+customerId);
            if (farmOrderService.addFarmOrder(farmId,customerId) != -1 && farmService.setFarmSentOut(farmId) > 0) {
                result.put("result","succeed");
            } else {
                result.put("result","fail");
            }
        }
        return result;
    }


    @RequestMapping(value = "/getCustomer", method = RequestMethod.POST)
    public User getCustomer(@RequestBody HashMap<String,Integer> map) {
        if (map == null) {
            return null;
        } else {
            return farmOrderService.getCustomer(map.get("farmId"));
        }
    }

    @RequestMapping(value = "/getFarmerFarmOrderBean")
    public List<FarmOrderBean> getFarmerFarmOrderBean(@RequestBody HashMap<String,Integer> map) {
        if (map == null) {
            return new ArrayList<>();
        } else {
            int farmerId = map.get("farmerId");
            return farmOrderService.getNotProcessedFarmOrder(farmerId);
        }
    }

    @RequestMapping(value = "/getFarmerProcessedFarmOrderBean")
    public List<FarmOrderBean> getFarmerNotProcessedFarmOrderBean(@RequestBody HashMap<String,Integer> map) {
        if (map == null) {
            return new ArrayList<>();
        } else {
            int farmerId = map.get("farmerId");
            return farmOrderService.getProcessedFarmOrder(farmerId);
        }
    }

    @RequestMapping(value = "/processFarmerFarmOrder")
    public HashMap<String,String> processFarmerFarmOrder(@RequestBody List<Integer> farmOrderIdList) {
        HashMap<String,String> result  = new HashMap<>();
        if (farmOrderIdList == null && farmOrderIdList.isEmpty()) {
            result.put("result","data is null");
        } else {
            boolean flag = true;
            for (Integer orderId : farmOrderIdList) {
                if (farmOrderService.processFarmOrder(orderId) <= 0) {
                    flag = false;
                }
            }
            if (!flag) {
                result.put("result","some order process fail");
            } else {
                result.put("result","success");
            }
        }
        return result;
    }

    @RequestMapping(value = "/getCustomerNotProcessedFarmOrderBeanList")
    public List<FarmOrderBean> getCustomerFarmOrderBeanList(@RequestBody HashMap<String,Integer> map) {
        if (map == null) {
            return new ArrayList<>();
        } else {
            int customerId = map.get("customerId");
            return farmOrderService.getCustomerNotProcessedFarmOrder(customerId);
        }
    }

    @RequestMapping(value = "/getCustomerProcessedFarmOrderBeanList")
    public List<FarmOrderBean> getCustomerProcessedFarmOrderBeanList(@RequestBody HashMap<String,Integer> map) {
        if (map == null) {
            return new ArrayList<>();
        } else {
            int customerId = map.get("customerId");
            return farmOrderService.getCustomerProcessedFarmOrder(customerId);
        }
    }
}
