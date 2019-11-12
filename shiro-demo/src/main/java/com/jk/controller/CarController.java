package com.jk.controller;

import com.jk.model.UserModel;
import com.jk.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class CarController {
@Autowired
    private CarService carService;


@RequestMapping("login")
    public String login(){

    return "login";
}

@RequestMapping("index")
public String index(){

    return "index";

}


    @RequestMapping("queryUserPage")
    @ResponseBody
    public HashMap<String,Object> queryUserPage(Integer rows, Integer page, UserModel userModel){

        return carService.queryUserPage(rows,page,userModel);

    }


    @RequestMapping("login")
    @ResponseBody
    public String login(UserModel user, HttpSession session){

return null;
    }




}
