package com.jk.service;

import com.jk.model.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

public interface UserSrervice {


    HashMap<String, Object> queryUserPage(Integer rows, Integer page, UserModel userModel);

    List<TreeModel> queryTree(HttpSession session);

    void addUser(UserModel userModel);


    List<InfoModel> queryRole();

    UserModel queryUserById(Integer id);

    List<AreaModel> queryshen(Integer pid);

    List<TreeModel> queryPowerTree(Integer roleid);

    void addPower(TreeModel treeModel);

    void deletePowerById(Integer powerid);

    void updatePowerById(TreeModel addTree);


    List<MenuModel> queryMenu(Integer powerid);

    void saveMenu(MenuModel menuModel);

    void saveRolePower(Integer roleid, String[] ids);

    UserModel queryUserName(Integer loginnumber);

    void zhuceuser(UserModel u);
}
