package com.jk.mapper;

import com.jk.model.UserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface cMapper {


    int queryCount(@Param("userModel") UserModel userModel);

    List<UserModel> queryUserPage(@Param("start") int start,@Param("rows") Integer rows,@Param("userModel") UserModel userModel);
}
