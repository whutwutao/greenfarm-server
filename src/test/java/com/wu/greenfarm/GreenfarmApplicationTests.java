package com.wu.greenfarm;

import com.wu.greenfarm.mapper.FarmMapper;
import com.wu.greenfarm.mapper.FarmOrderMapper;
import com.wu.greenfarm.mapper.ProductMapper;
import com.wu.greenfarm.mapper.UserMapper;
import com.wu.greenfarm.pojo.Farm;
import com.wu.greenfarm.pojo.FarmOrder;
import com.wu.greenfarm.pojo.Product;
import com.wu.greenfarm.pojo.User;
import com.wu.greenfarm.service.FarmService;
import com.wu.greenfarm.service.UserServiceImpl;
import com.wu.greenfarm.utils.ImageUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GreenfarmApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserMapper userMapper;

    @Autowired
    FarmMapper farmMapper;

    @Autowired
    FarmOrderMapper farmOrderMapper;


    @Test
    void addUserTest() {
        User user = new User("小红","123","10010");
        userMapper.addUser(user);
    }


    @Autowired
    UserServiceImpl userService;
    @Test
    void registerUserTest() {
        User user = new User("小黑","123","12580");
        if (userService == null) {
            System.out.println("null");
        } else {
            userService.register(user);
        }
    }

    @Test
    void loginTest() {
        User user = new User(null,"123","10086");
        System.out.println(userService.login(user));
    }

    @Test
    void getAllUserTest() {
        List<User> userList = userService.getAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void queryUserByIdTest() {
        User user = userMapper.queryUserById(1);
        System.out.println(user);
    }

    @Test
    void getUserLimitTest() {
//        List<User> userList = userMapper.getUserLimit(1,5);
//        for (User user : userList) {
//            System.out.println(user);
//        }
        List<User> userList = userService.getUserLimit(30,7);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void changePasswordTest() {
        User user = new User();
        user.setId(13);
        user.setPassword("4321");
        System.out.println(userService.changePassword(user));
    }

    @Test
    void changeUsernameTest() {
        User user = new User();
        user.setId(15);
        user.setUsername("Kate");
        System.out.println(userService.changeUsername(user));
    }

    @Test
    void changeTelephoneTest() {
        User user = new User();
        user.setId(15);
        user.setTelephone("13886476506");
        System.out.println(userService.changeTelephone(user));
    }

    @Test
    void addFarmTest() {
        Farm farm = new Farm();
        farm.setAddress("湖北省武汉市");
        farm.setArea(30.0);
        farm.setDescription("土地质量良好");
        farm.setPrice(20.0);
        farm.setOwnerId(1);
        farmMapper.addFarm(farm);
    }

    @Autowired
    FarmService farmService;
    @Test
    void publish() {
        Farm farm = new Farm();
        farm.setAddress("湖北省武汉市");
        farm.setArea(30.0);
        farm.setDescription("广州海鸥岛8亩私人钓场农庄转让");
        farm.setPrice(20.0);
        farm.setOwnerId(2);
        farmService.addFarm(farm);
    }

    @Test
    void queryFarmById() {
        Farm farm = farmMapper.queryFarmById(37);
        System.out.println(farm);
    }

    @Test
    void queryFarmByOwnerId() {
        List<Farm> farmList = farmMapper.queryFarmByOwnerId(2);
        for (Farm farm : farmList) {
            System.out.println(farm);
        }
    }

    @Test
    void queryAllFarm() {
        List<Farm> farmList = farmMapper.queryAllFarm();
        for (Farm farm : farmList) {
            System.out.println(farm);
        }
    }

    @Test
    void queryFarmLimit() {
        List<Farm> farmList = farmMapper.queryFarmLimit(2,2);
        for (Farm farm : farmList) {
            System.out.println(farm);
        }
    }

    @Test
    void getFarmLimit() {
        List<Farm> farmList = farmService.getFarmLimit(1,3);
        for (Farm farm : farmList) {
            System.out.println(farm);
        }
    }

    @Test
    void picturePathGenerate() {
        System.out.println(ImageUtil.getFileName(1));
    }

    @Test
    public void getTelephone() {
        System.out.println(userService.getTelephone(13));
    }

    @Test
    public void addFarmOrderTest() {
        FarmOrder farmOrder = new FarmOrder();
        farmOrder.setFarmId(37);
        farmOrder.setCustomerId(25);
        farmOrderMapper.addFarmOrder(farmOrder);
    }

    @Test
    public void queryFarmOrderById() {
        System.out.println(farmOrderMapper.queryFarmOrderById(1));
    }

    @Test
    public void queryFarmOrderByFarmId() {
        System.out.println(farmOrderMapper.queryFarmOrderByFarmId(37));
    }

    @Test
    public void queryFarmOrderByCustomerId() {
        System.out.println(farmOrderMapper.queryFarmOrderByCustomerId(25));
    }

    @Test
    public void setFarmRentOut() {
        farmMapper.setFarmRentOut(1);
    }

    @Test
    public void queryFarmByCondition() {
        List<Farm> farmList = farmMapper.queryFarmByCondition("0");
        for (Farm farm : farmList) {
            System.out.println(farm);
        }
    }

    @Test
    public void queryFarmByCustomerId() {
        List<Farm> farms = farmMapper.queryFarmByCustomerId(16);
        for (Farm farm : farms) {
            System.out.println(farm);
        }
    }

    @Autowired
    ProductMapper productMapper;
    @Test
    public void addProduct() {
        Product product = new Product(0,"辣椒","变态辣",null,0,0);
        productMapper.addProduct(product);
    }

    @Test
    public void queryAllSaleProduct() {
        List<Product> products = productMapper.queryAllSaleProduct();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void queryAllPlantProduct() {
        List<Product> products = productMapper.queryAllPlantProduct();
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
