package com.wu.greenfarm.controller;

import com.wu.greenfarm.pojo.Farm;
import com.wu.greenfarm.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class FarmController {

    @Autowired
    FarmService farmService;

    @RequestMapping(value = "/getFarmLimit", method = RequestMethod.POST)
    public List<Farm> getFarmLimit(@RequestBody HashMap<String, Integer> map) {
        if (map != null) {
            int start = map.get("start");
            int len = map.get("len");
            return farmService.getFarmLimit(start,len);
        } else {
            return new ArrayList<Farm>();
        }
    }


}
