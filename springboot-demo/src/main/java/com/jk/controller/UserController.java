package com.jk.controller;
import com.jk.model.*;
import com.jk.service.UserSrervice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
   @Autowired
    private UserSrervice userSrervice;


   //查询
     @RequestMapping("queryUserPage")
     @ResponseBody
    public HashMap<String, Object> queryUserPage(Integer rows, Integer page, UserModel userModel){

           return  userSrervice.queryUserPage(rows,page,userModel);

     }
    //树
    @RequestMapping("queryTree")
    @ResponseBody
    public List<TreeModel> queryTree(HttpSession session){
        return userSrervice.queryTree(session);
    }
   //新增
   @RequestMapping("addUser")
   @ResponseBody
   public void addUser(UserModel userModel){

       userSrervice.addUser(userModel);
   }
    //角色
    @RequestMapping("queryRole")
    @ResponseBody
    public List<InfoModel> queryRole(){
        return userSrervice.queryRole();
    }
    @RequestMapping("queryUserById")
    @ResponseBody
    public UserModel queryUserById(Integer id) {

        return userSrervice.queryUserById(id);
    }

    //省数据
    @RequestMapping("queryshen")
    @ResponseBody
    public List<AreaModel> queryshen(Integer pid){
        return userSrervice.queryshen(pid);
    }
    //初始化权限树
    @RequestMapping("queryPowerTree")
    @ResponseBody
    public List<TreeModel> queryPowerTree(Integer roleid){


        return userSrervice.queryPowerTree(roleid);
    }
//新增权限树
@RequestMapping("addPower")
@ResponseBody
public void  addPower(TreeModel treeModel) {
    userSrervice.addPower(treeModel);
}
//删除权限树
@RequestMapping("deletePowerById")
@ResponseBody
public void deletePowerById(Integer powerid) {

    userSrervice.deletePowerById(powerid);
}
    //修改权限节点
    @RequestMapping("updatePowerById")
    @ResponseBody
    public void updatePowerById(TreeModel addTree) {
        userSrervice.updatePowerById(addTree);
    }

    //权限表
    @RequestMapping("queryMenu")
    @ResponseBody
    public List<MenuModel> queryMenu(Integer powerid) {
        return userSrervice.queryMenu(powerid);
    }
//新增权限 表
    @RequestMapping("saveMenu")
    @ResponseBody
    public void saveMenu(MenuModel menuModel){

          userSrervice.saveMenu(menuModel);
    }

//修改角色
    @RequestMapping("saveRolePower")
    @ResponseBody
    public void saveRolePower(Integer roleid,String[] ids){
     userSrervice.saveRolePower(roleid,ids);

    }
    @RequestMapping("login")
    @ResponseBody
    public String login(UserModel user,String code,HttpSession session){
        //验证验证码
       /* String codeName = session.getAttribute("checkcode").toString();
        if(!code.equalsIgnoreCase(codeName)){
            return "验证码错误！";
        }*/
        //验证用户名
        UserModel user2 = userSrervice.queryUserName(user.getLoginnumber());
        if(user2==null){
            return "用户名不存在！";
        }
        //验证密码
        if(!user.getPassword().equals(user2.getPassword())){
            return "密码错误！";
        }
        session.setAttribute("user", user2);
        return "登录成功！";
    }

    @RequestMapping("zhuceuser")
    @ResponseBody
    public String zhuceuser(UserModel u){
        //检验用户名是否存在
        UserModel user = userSrervice.queryUserName(u.getLoginnumber());
        if (user!=null) {
            return "用户名已经存在！";
        }
        userSrervice.zhuceuser(u);
        return "注册成功!";
    }






}
