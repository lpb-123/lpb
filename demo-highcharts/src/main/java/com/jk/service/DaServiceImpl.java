package com.jk.service;

import com.jk.mapper.DaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DaServiceImpl implements DaService {
    @Autowired
    private DaMapper daMapper;


    @Override
    public List<Map<String, Object>> querycar() {

        return daMapper.querycar();
    }

    @Override
    public List<Map<String, Object>> queryCarAll() {
        return daMapper.queryCarAll();
    }

    @Override
    public List<Map<String, Object>> queryzhu() {
        return daMapper.queryzhu();
    }
}
