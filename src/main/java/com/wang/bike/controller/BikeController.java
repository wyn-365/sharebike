package com.wang.bike.controller;

import com.wang.bike.pojo.Bike;
import com.wang.bike.service.BikeServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接受微信程序发来的 单车数据,存入数据库
 */
@Controller
public class BikeController {

//    @PostMapping("/bike")
//    @ResponseBody  //响应Ajax请求，会将响应的对象转成json
//    public String getById(@RequestBody String data) {
//        //(@RequestBody请求时结束json类型的数据
//        System.out.println(data);
//        return "succ";
//    }

    @Autowired
    private BikeServce bikeServce;

    /**mysql
    @GetMapping("/bike")
    @ResponseBody  //响应Ajax请求，会将响应的对象转成json
    public String getById(Bike bike) {
        //调用Service保存map
        bikeServce.save(bike);
        return "success";
    }
     **/
    //mongodb
    @PostMapping("/bike")
    @ResponseBody  //响应Ajax请求，会将响应的对象转成json
    public String save(@RequestBody Bike bike) {
        //调用Service保存map
        bikeServce.save(bike);
        return "success";
    }

    //查询所有的单车
    @GetMapping("/bikes")
    @ResponseBody  //响应Ajax请求，会将响应的对象转成json
    public List<Bike> findAll() {

        List<Bike> bikes = bikeServce.findAll();
        return bikes;
    }

    //后台查询所有的单车信息
    @GetMapping("/bike_list")
    public String toList() {
        return "bike/list";
    }

}
