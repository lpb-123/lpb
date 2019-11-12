package com.jk.service;

import com.jk.model.Car;

import java.util.List;

public interface CarService {
    List<Car> queryCarList();

    void deletePowerById(Integer id);

    void addUser(Car usercar);

    Car queryUserById(String carId);

    void update(Car usercar);
}
