package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.CarMapper;
import com.jk.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0")
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;


    @Override
    public List<Car> queryCarList() {

        return carMapper.queryCarList();
    }

    @Override
    public void addUser(Car Carmodel) {
        Integer id=Carmodel.getCarId();
        if (id != null){

            carMapper.updateid(Carmodel);

        }else{
            carMapper.addUser(Carmodel);
        }


    }

    @Override
    public void deletePowerById(String carId) {
        carMapper.deletePowerById(carId);
    }

    @Override
    public Car queryUserById(String carId) {

        return carMapper.queryUserById(carId);
    }




}
