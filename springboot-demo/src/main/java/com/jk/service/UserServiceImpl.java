package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserSrervice {
    @Autowired
    private UserMapper userMapper;


    @Override
    public HashMap<String, Object> queryUserPage(Integer rows, Integer page, UserModel userModel) {
        int total = userMapper.queryCount(userModel);
        int start = (page - 1) * rows;
        List<UserModel> list = userMapper.queryUserPage(start, rows, userModel);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", list);
        return  map;
    }

    @Override
    public List<TreeModel> queryTree(HttpSession session) {
        int pid=0;
        List<TreeModel> list = queryTi(pid);
        return list;
    }

    @Override
    public void addUser(UserModel userModel) {
        Integer id = userModel.getId();
        if (id != null) {// 修改
            // 修改用户
            userMapper.updateUser(userModel);
            // 修改用户角色中间表 1、删除 2、新增
            // 删除：根据用户id，用户角色中间删除
            /* userDao.deleteUserRole(id); */
        } else {// 新增
            // 新增用户
            userMapper.addUser(userModel);
        }

    }

    @Override
    public List<InfoModel> queryRole() {
        return userMapper.queryRole();
    }

    @Override
    public UserModel queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public List<AreaModel> queryshen(Integer pid) {
        return userMapper.queryshen(pid);
    }

    @Override
    public List<TreeModel> queryPowerTree(Integer roleid) {
        List<TreeModel> rolePower = userMapper.queryPowerTreeByRoleid(roleid);

        int pid = 0;
        // 查询一级节点
        // 提取公共方法的快捷键：alt+shift+m
        List<TreeModel> list = queryPowerNodes(pid, rolePower);

        // 添加虚拟的根节点
        TreeModel tree = new TreeModel();
        tree.setId(0);
        tree.setPid(-1);
        tree.setText("根节点");
        tree.setChildren(list);

        ArrayList<TreeModel> list2 = new ArrayList<TreeModel>();
        list2.add(tree);
        return list2;
    }

    @Override
    public void addPower(TreeModel treeModel) {

        userMapper.addPower(treeModel);

    }

    @Override
    public void deletePowerById(Integer powerid) {
        userMapper.deletePowerById(powerid);
    }

    @Override
    public void updatePowerById(TreeModel addTree) {
        userMapper.updatePowerById(addTree);
    }

    @Override
    public List<MenuModel> queryMenu(Integer powerid) {
        return userMapper.queryMenu(powerid);
    }

    @Override
    public void saveMenu(MenuModel menuModel) {
        userMapper.saveMenu(menuModel);
    }

    @Override
    public void saveRolePower(Integer roleid, String[] ids) {
        //删除
        userMapper.deleteByRoleid(roleid);
        if (ids.length>0){
            //新增
            userMapper.addRolePower(roleid,ids);
        }
    }

    @Override
    public UserModel queryUserName(Integer loginnumber) {
        return userMapper.queryUserName(loginnumber);
    }

    @Override
    public void zhuceuser(UserModel u) {
        userMapper.zhuceuser(u);
    }


    private List<TreeModel> queryPowerNodes(int pid, List<TreeModel> rolePower) {
        List<TreeModel> list = userMapper.queryTreeByPid2(pid);

        for (TreeModel treeBean : list) {
            Integer id = treeBean.getId();
            // 查询对应的子节点
            List<TreeModel> nodes = queryPowerNodes(id, rolePower);// 递归：自己调自己
            treeBean.setChildren(nodes);

            // 把所有的权限，跟当前角色拥有的权限比较：checked属性：true
            for (TreeModel treeBean2 : rolePower) {
                Integer id2 = treeBean.getId();
                Integer id3 = treeBean2.getId();
                if (nodes.size() <= 0 && id2 == id3) {// 是子节点 并且 有权限
                    treeBean.setChecked(true);
                }
            }
        }
        return list;
    }

    private List<TreeModel> queryTi(int pid) {
        List<TreeModel> list =userMapper.queryNodes(pid);
        for (TreeModel tree : list) {
            Integer id = tree.getId();
            List<TreeModel>  children= queryTi(id);
            tree.setChildren(children);
        }

        return list;
    }

}
