package com.wu.greenfarm;

import com.wu.greenfarm.mapper.*;
import com.wu.greenfarm.pojo.*;
import com.wu.greenfarm.service.FarmOrderService;
import com.wu.greenfarm.service.FarmService;
import com.wu.greenfarm.service.TalkService;
import com.wu.greenfarm.service.UserServiceImpl;
import com.wu.greenfarm.utils.ImageUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
    PlantMapper plantMapper;
    @Test
    public void addPlant() {
        Plant plant = new Plant(0,"花菜","无","10斤",2,3,0);
        plantMapper.addPlant(plant);
    }

    @Test
    public void queryPlantByCustomerId() {
        List<Plant> plants = plantMapper.queryPlantByCustomerIdAndFarmId(3,2);
        for (Plant plant : plants) {
            System.out.println(plant);
        }
    }

    @Test
    public void getCustomerId() {
        System.out.println(farmOrderMapper.getCustomerId(2));
    }

    @Autowired
    FarmOrderService farmOrderService;

    @Test
    public void getCustomer() {

        System.out.println(farmOrderService.getCustomer(2));
    }

    @Test
    public void setPlantStatus() {
        Plant plant = new Plant();
        plant.setId(3);
        plant.setStatus(1);
        plantMapper.setPlantStatus(plant);
    }

    @Test
    public void queryFarmOrderByOwnerId() {
        System.out.println(farmOrderMapper.queryNotProcessFarmOrderByOwnerId(13));

    }

    @Test
    public void queryNotProcessedFarmOrderByCustomerId() {
        List<FarmOrder> farmOrderList = farmOrderMapper.queryNotProcessedFarmOrderByCustomerId(15);
        for (FarmOrder farmOrder : farmOrderList) {
            System.out.println(farmOrder);
        }
    }

    @Test
    public void queryProcessedFarmOrderByCustomerId() {
        List<FarmOrder> farmOrderList = farmOrderMapper.queryProcessedFarmOrderByCustomerId(16);
        for (FarmOrder farmOrder : farmOrderList) {
            System.out.println(farmOrder);
        }
    }

    @Test
    public void getCustomerNotProcessedFarmOrder() {
        List<FarmOrderBean> list = farmOrderService.getCustomerNotProcessedFarmOrder(15);
        for (FarmOrderBean farmOrderBean : list) {
            System.out.println(farmOrderBean);
        }
    }

    @Test
    public void getCustomerProcessedFarmOrder() {
        List<FarmOrderBean> list = farmOrderService.getCustomerProcessedFarmOrder(16);
        for (FarmOrderBean farmOrderBean : list) {
            System.out.println(farmOrderBean);
        }
    }

    @Autowired
    TalkService talkService;

    @Test
    public void addTalk() {
        Talk talk = new Talk();
        talk.setSender(13);
        talk.setReceiver(16);
        System.out.println(talkService.addTalk(talk));
    }

    @Test
    public void getTalkBySender() {
        List<Talk> list = talkService.getTalkBySender(16);
        for (Talk talk : list) {
            System.out.println(talk);
        }
    }

    @Test
    public void queryFarmByMultiCondition() {
        List<Farm> list= farmMapper.queryFarmByMultiCondition("","猕猴桃",0,10,1000,5000,0,5);
        for (Farm farm : list) {
            System.out.println(farm);
        }

    }

    @Autowired
    CategoryMapper categoryMapper;

    @Test
    public void addCategory() {
        Category category = new Category();
        category.setCname("叶菜类");
        categoryMapper.addCategory(category);
    }

    @Test
    public void getAllCategory() {
        List<Category> list = categoryMapper.getAllCategory();
        for (Category category : list) {
            System.out.println(category);
        }
    }

    @Autowired
    ProductMapper productMapper;
    @Test
    public void addProduct() {
        Product product = new Product();
        product.setName("上海青苗");
        product.setDescription("500g一份");
        product.setFarmerId(13);
        product.setCategory(5);
        product.setPictureUrl("/static/product/QQ20210516-10.jpg");
        product.setPrice(6);
        productMapper.addProduct(product);
    }

    @Test
    public void getProductByCategoryLimit() {
        List<Product> products = productMapper.getProductByCategoryLimit(2,0,5);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void getProductByName() {
        List<Product> products = productMapper.getProductByName("红辣椒");
        for (Product product : products) {
            System.out.println(product);
        }
    }

}
