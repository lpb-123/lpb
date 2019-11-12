package com.jk.service;

import com.jk.model.Car;

import java.util.List;

public interface CarService {


    List<Car> queryCarList() ;

    void addUser(Car usercar);

    void deletePowerById(String carId);

    Car queryUserById(String carId);











}
