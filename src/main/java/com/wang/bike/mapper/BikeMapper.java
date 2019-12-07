package com.wang.bike.mapper;


import com.wang.bike.pojo.Bike;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BikeMapper {

    public void save(Bike bike);
}
