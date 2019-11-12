package com.jk.mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface UserMapper {


    int queryCount(@Param("userModel") UserModel userModel);

    List<UserModel> queryUserPage(@Param("start") int start,@Param("rows") Integer rows,@Param("userModel") UserModel userModel);

    List<TreeModel> queryNodes(@Param("pid") int pid);

    void addUser(UserModel userModel);


    List<InfoModel> queryRole();

    UserModel queryUserById(@Param("id") Integer id);

    List<AreaModel> queryshen(@Param("pid") Integer pid);

    void updateUser(UserModel userModel);

    List<TreeModel> queryPowerTreeByRoleid(@Param("roleid") Integer roleid);

    List<TreeModel> queryTreeByPid2(@Param("pid") int pid);

    void addPower(TreeModel treeModel);

    void deletePowerById(Integer powerid);

    void updatePowerById(TreeModel addTree);

    List<MenuModel> queryMenu(Integer powerid);

    void saveMenu(MenuModel menuModel);

    void deleteByRoleid(@Param("roleid") Integer roleid);

    void addRolePower(@Param("roleid") Integer roleid,@Param("ids") String[] ids);

    UserModel queryUserName(Integer loginnumber);

    void zhuceuser(UserModel u);





}
