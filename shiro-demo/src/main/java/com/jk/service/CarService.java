package com.jk.service;

import com.jk.model.UserModel;

import java.util.HashMap;

public interface CarService {


    HashMap<String, Object> queryUserPage(Integer rows, Integer page, UserModel userModel);
}
