package com.jk.mapper;

import java.util.List;
import java.util.Map;

public interface DaMapper {
    List<Map<String, Object>> querycar();

    List<Map<String, Object>> queryCarAll();

    List<Map<String, Object>> queryzhu();
}
