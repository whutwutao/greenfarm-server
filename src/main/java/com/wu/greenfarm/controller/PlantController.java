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
    public List<Plant> getCustomerPlantList(@RequestBody User user) {
        if (user != null) {
            return plantService.getCustomerPlantList(user.getId());
        } else {
            return new ArrayList<>();
        }
    }
}
