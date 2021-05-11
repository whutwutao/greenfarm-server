package com.wu.greenfarm.controller;

import com.wu.greenfarm.pojo.Farm;
import com.wu.greenfarm.pojo.User;
import com.wu.greenfarm.service.FarmService;
import com.wu.greenfarm.service.UserService;
import com.wu.greenfarm.utils.ImageUtil;
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
public class FarmController {

    @Autowired
    FarmService farmService;

    @Autowired
    UserService userService;

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

    @RequestMapping(value = "/addFarm", method = RequestMethod.POST)
    public Farm addFarm(@RequestBody HashMap<String,String> map) {
        if (map != null) {
            int ownerId = Integer.valueOf(map.get("ownerId"));
            String description = map.get("description");
            String address = map.get("address");
            int serviceLife = Integer.valueOf(map.get("serviceLife"));
            double area = Double.valueOf(map.get("area"));
            double price = Double.valueOf(map.get("price"));
            String encodePictureText = map.get("picture");

            String pictureFileName = ImageUtil.getFileName(ownerId);//图片文件名
            String pictureWritePath = ImageUtil.getFilePath(pictureFileName);//图片在本地的保存位置
            String pictureUrl = ImageUtil.getPictureUrl("farm",pictureFileName);

            ImageUtil.decodeAndWrite(encodePictureText,pictureWritePath);

            Farm farm = new Farm(0,ownerId,address,description,pictureUrl,serviceLife,area,price,null);
            if (farmService.addFarm(farm) > 0) {
                return farm;
            } else {
                return null;
            }

        } else {
            return null;
        }
    }

    @RequestMapping(value = "/getOwner", method = RequestMethod.POST)
    public HashMap<String,User> getOwnerTelephone(@RequestBody Farm farm) {
        if (farm == null) {
            return new HashMap<String,User>();
        } else {
            HashMap<String, User> result = new HashMap<>();
            User owner = userService.getUserById(farm.getOwnerId());
            result.put("owner",owner);
            return result;
        }
    }

    @RequestMapping(value = "/getFarmByOwnerId", method = RequestMethod.POST)
    public List<Farm> getFarmByOwnerId(@RequestBody Map<String,Integer> map) {
        if (map == null) {
            return new ArrayList<Farm>();
        } else {
            int ownerId = map.get("ownerId");
            return farmService.getFarmByOwnerId(ownerId);
        }
    }

    @RequestMapping(value = "/searchFarm", method = RequestMethod.POST)
    public List<Farm> searchFarmByCondition(@RequestBody Map<String,String> map) {
        if (map == null) {
            return new ArrayList<>();
        } else {
            String condition = map.get("condition");
            return farmService.searchFarmByCondition(condition);
        }
    }

    @RequestMapping(value = "/getCustomerFarmList",method = RequestMethod.POST)
    public List<Farm> getCustomerFarmList(@RequestBody User user) {
        if (user == null) {
            return new ArrayList<>();
        } else {
            return farmService.getCustomerFarmList(user);
        }
    }

    @RequestMapping(value = "/getFarmerFarmList", method = RequestMethod.POST)
    public List<Farm> getFarmerFarList(@RequestBody User user) {
        if (user == null) {
            return new ArrayList<>();
        } else {
            return farmService.getFarmByOwnerId(user.getId());
        }
    }

}
