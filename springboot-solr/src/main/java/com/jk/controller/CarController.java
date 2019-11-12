package com.jk.controller;

import com.jk.model.Car;
import com.jk.service.CarService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller

public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private SolrClient client;

@RequestMapping("index")
public String index(){
    return "index";
}





    /**
     * 综合查询: 在综合查询中, 有按条件查询, 条件过滤, 排序, 分页, 高亮显示, 获取部分域信息
     * @return
     */
    @RequestMapping("search")
    @ResponseBody
    public List<Car> queryCarList(){


        List<Car> list= carService.queryCarList();


        return list;
    }

    @RequestMapping("del")
    @ResponseBody
    public String del(Integer id) {

        carService.deletePowerById(id);

        try {
            client.deleteById("core1",id);
            client.commit("core1");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }




    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(Car usercar){
        carService.addUser(usercar);

        try {
            SolrInputDocument doc = new SolrInputDocument();
            doc.setField("id", usercar.getCarId());
            doc.setField("mname",usercar.getCarName() );
            doc.setField("mauthor",usercar.getCarShow());
            doc.setField("mdate",usercar.getCarShow());



            client.add("core1", doc);
            //client.commit();
            client.commit("core1");

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;





    }


    //修改
    @RequestMapping("upda")
    @ResponseBody
    public Car queryUserById(String carId){

        Car model =  carService.queryUserById(carId);

        return model;

    }



    @RequestMapping("update")
    @ResponseBody
    public String update(Car usercar) {

        carService.update(usercar);

        try {
            SolrInputDocument doc = new SolrInputDocument();
            doc.setField("id", usercar.getCarId());
            doc.setField("mname",usercar.getCarName() );
            doc.setField("mauthor",usercar.getCarShow());
            doc.setField("mdate",usercar.getCarShow());


            client.add("core1", doc);
            //client.commit();
            client.commit("core1");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }










}
