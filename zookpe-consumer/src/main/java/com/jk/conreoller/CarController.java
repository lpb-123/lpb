package com.jk.conreoller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Car;
import com.jk.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarController {

    @Reference(version = "1.0")
   private CarService carService;



   @RequestMapping("show")
    public String show(){
       System.out.println(111111);
       return "show";
   }

    @RequestMapping("queryCarList")
    @ResponseBody
    public List<Car> queryCarList(){

        List<Car> list= carService.queryCarList();

        System.out.println("1111111");
        return list;
    }

    @RequestMapping("addUser")
    @ResponseBody
    public void addUser(Car usercar){
        carService.addUser(usercar);
    }
//删除
    @RequestMapping("deletePowerById")
    @ResponseBody
    public void deletePowerById(String carId){
        carService.deletePowerById(carId);
    }

    //修改
    @RequestMapping("queryUserById")
    @ResponseBody
    public Car queryUserById(String carId){

        return carService.queryUserById(carId);
    }








}
