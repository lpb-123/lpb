package com.jk.controller;

import com.jk.service.DaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DaController {
    @Autowired
    private DaService daService;

@RequestMapping("index")
public String index(){

    System.out.println("ssss");

    return "index";
}
@RequestMapping("zhexian")
public String zhexian(){
    return "zhexian";
}
@RequestMapping("zhuzhang")
public String zhuzhang(){

    return "zhuzhang";
}


//饼状图
@RequestMapping("queryCar")
@ResponseBody
public List<Map<String,Object>> querycar(){
    //查询数据库数据
    List<Map<String,Object>> map1 =daService.querycar();
    //前台展示的返回的数据
    List<Map<String,Object>> map2 =new ArrayList<Map<String,Object>>();
    for (Map<String,Object> map:map1) {
        Map<String,Object> map3=new HashMap<>();
        map3.put("y",map.get("y"));
        map3.put("name",map.get("time"));
        map2.add(map3);
    }
    return map2;
}


//折线图
    @RequestMapping("queryCarAll")
    @ResponseBody
    public List<Map<String,Object>> queryCarAll(){
        List<Map<String,Object>> map =daService.queryCarAll();

        List<Map<String,Object>> map2 =new ArrayList<Map<String,Object>>();

        for (Map<String,Object> map1:map) {
            Map<String,Object> map3=new HashMap<>();
            map3.put("name",map1.get("time"));
            map3.put("date",map1.get("count"));
            map2.add(map3);

        }

        return map;
    }

//柱


    @RequestMapping("queryzhu")
    @ResponseBody
    public List<Map<String,Object>> queryzhu(){
        List<Map<String,Object>> map =daService.queryzhu();

        List<Map<String,Object>> map2 =new ArrayList<Map<String,Object>>();

        for (Map<String,Object> map1:map) {
            Map<String,Object> map3=new HashMap<>();
            map3.put("name",map1.get("time"));
            map3.put("date",map1.get("dou"));
            map3.put("cc",map1.get("y"));
            map2.add(map3);

        }

        return map;
    }












}
