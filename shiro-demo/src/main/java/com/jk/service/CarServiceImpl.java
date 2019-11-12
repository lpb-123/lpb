package com.jk.service;

import com.jk.mapper.cMapper;
import com.jk.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private cMapper cMapper;


    @Override
    public HashMap<String, Object> queryUserPage(Integer rows, Integer page, UserModel userModel) {
        int total = cMapper.queryCount(userModel);
        int start = (page - 1) * rows;
        List<UserModel> list = cMapper.queryUserPage(start, rows, userModel);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
}
