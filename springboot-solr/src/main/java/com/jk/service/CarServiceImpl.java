package com.jk.service;

import com.jk.mapper.caMapper;
import com.jk.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
  private caMapper camapper;


    @Override
    public List<Car> queryCarList() {


        return camapper.queryCarList();
    }

    @Override
    public void deletePowerById(Integer id) {
        camapper.deletePowerById(id);
    }


    @Override
    public void addUser(Car Carmodel) {

            camapper.addUser(Carmodel);



    }

    @Override
    public Car queryUserById(String carId) {
        return camapper.queryUserById(carId);
    }

    @Override
    public void update(Car usercar) {
        camapper.updateid(usercar);
    }
}
