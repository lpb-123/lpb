package com.jk.mapper;

import com.jk.model.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CarMapper {

   @Select("select * from t_carmodel")
    List<Car> queryCarList();
    @Insert(" insert into t_carmodel(carName,carPrice,carShow,carTime) values(#{carName},#{carPrice},#{carShow},#{carTime})")
    void addUser(Car usercar);
   @Delete("delete from t_carmodel where carId=#{carId}")
    void deletePowerById(String carId);
    @Select("select * from t_carmodel where carId=#{carId}")
    Car queryUserById(String carId);
    @Update("update t_carmodel m set m.carName=#{carName},m.carPrice=#{carPrice},m.carShow=#{carShow} where m.carId=#{carId}")
    void updateid(Car carmodel);


}
