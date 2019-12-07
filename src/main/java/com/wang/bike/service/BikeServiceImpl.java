package com.wang.bike.service;


import com.wang.bike.mapper.BikeMapper;
import com.wang.bike.pojo.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BikeServiceImpl implements BikeServce {
    //注入mongodb操作模板
    @Autowired
    private MongoTemplate  mongoTemplate;

    @Autowired
    private BikeMapper bikeMapper;
    //mybatis存储到mysql
    @Override
    public void save(Bike bike) {
        bikeMapper.save(bike);
        //int i = 100 / 0;
        bikeMapper.save(bike);
    }

    //存储到mongodb
    @Override
    public void save(String bike) {
        mongoTemplate.save(bike,"bike");
    }

    //查询所有的单车 在mongodb 返回一个集合
    @Override
    public List<Bike> findAll() {
        return  mongoTemplate.findAll(Bike.class,"bike");
    }
}
