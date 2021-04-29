package com.wu.greenfarm.controller;

import com.wu.greenfarm.pojo.Plant;
import com.wu.greenfarm.pojo.User;
import com.wu.greenfarm.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class PlantController {

    @Autowired
    PlantService plantService;

    @RequestMapping(value = "addPlant", method = RequestMethod.POST)
    public HashMap<String,String> addPlant(@RequestBody Plant plant) {
        HashMap<String,String> result = new HashMap<>();
        if (plant != null) {
            if (plantService.addPlant(plant) > 0) {
                result.put("result","succeed");
            } else {
                result.put("result","fail to add");
            }
        } else {
            result.put("result","plant is null");
        }
        return result;
    }


    @RequestMapping(value = "/getCustomerPlantList", method = RequestMethod.POST)
    public List<Plant> getCustomerPlantList(@RequestBody HashMap<String,Integer> map) {
        if (map != null) {
            return plantService.getCustomerPlantList(map.get("customerId"),map.get("farmId"));
        } else {
            return new ArrayList<>();
        }
    }

    @RequestMapping(value = "/getFarmerPlantList", method = RequestMethod.POST)
    public List<Plant> getFarmerPlantList(@RequestBody HashMap<String,Integer> map) {
        if (map != null) {
            return plantService.getFarmerPlantList(map.get("farmId"));
        } else {
            return new ArrayList<>();
        }
    }

    @RequestMapping(value = "/setPlantStatus", method = RequestMethod.POST)
    public HashMap<String,String> setPlantStatus(@RequestBody Plant plant) {
        HashMap<String,String> result = new HashMap<>();
        if (plant == null) {
            result.put("result","data from client is null");
        } else {
            if (plantService.setPlantStatus(plant) > 0) {
                result.put("result","succeed");
            } else {
                result.put("result","fail");
            }
        }
        return result;
    }
}
