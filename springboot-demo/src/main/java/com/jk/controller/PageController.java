package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("index")
    public String index(){

        return "index2";

    }
    //查询
    @RequestMapping("show")
    public String show(){
        return "index";
    }
    //权限
    @RequestMapping("main")
    public String main(){
        return "main";
    }

    //注册页面
    @RequestMapping("zhuce")
    public String zhuce(){
        return "zhuce";
    }

    //登陆页面
    @RequestMapping("login")
    public String login(){
        return "login";
    }


}
