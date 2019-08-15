package com.cdl.controller;



import com.github.pagehelper.PageInfo;
import com.jbt.bean.User;
import com.jbt.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manageruser")
public class UserController {

    @Autowired
    private UserService userService;

    private static final String PAGE_Size = "3";

    @GetMapping("/")
    public String findAll(Model model){
        Map map = userService.findAll();
        List<User> list = (List<User>) map.get("list");
        model.addAttribute("page",list);
        model.addAttribute("ProviderVersion",map.get("ProviderVersion"));
        return "user/list";
    }

    //点击add 按钮，跳转到新增用户界面
    @RequestMapping("/toAdd")
    public String toAdd(){
        System.out.println("daoledaole当时的============");
        return "user/userAdd";
    }

    //新增
    @PostMapping("/")
    public String save(User user){
        userService.addUser(user);
        return "redirect:/manageruser/";
    }

    //删除
    @RequestMapping("user/{id}")
    public String delete(@PathVariable("id") Integer id){
        System.out.println("拿到id=" + id);
        userService.deleteUser(id);
        return "redirect:/manageruser/";
    }

   //点击edit连接，跳转到编辑页面
    @RequestMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id") Integer id,Model model){
        User user = userService.findOne(id);
        model.addAttribute("user",user);
        return "user/userEdit";
    }

    //在用户修改页面，点击保存，保存修改后的用户信息
    @PutMapping("/")
    public String update(User user){
        userService.updateUser(user.getId(),user);
        return "redirect:/manageruser/";
    }

    //分页查询
    @RequestMapping("/showInfo/{pageNum}")
    public String searchUserList(@PathVariable(value = "pageNum") Integer pageNum
    ,@RequestParam(value = "pageSize",required = false,defaultValue = PAGE_Size) Integer pageSize, Model model ){
        Map<String,User> map = new HashMap<>();
        PageInfo<User> list = userService.pageList(pageNum,pageSize);
        System.out.println(list.getList());
        model.addAttribute("list",list.getList());
        model.addAttribute("page",list);
        model.addAttribute("ProviderVersion",map.get("ProviderVersion"));
        return "user/list";
    }

    //查询
    @RequestMapping("/search")
    public String searchUser(@RequestParam(value = "username") String username,Model model){
        if("".equals(username)){
            return "redirect:/manageruser/";
        }else {
            Map<String, User> map = new HashMap<>();
            List<User> list = userService.searchUser(username);
            model.addAttribute("page", list);
            return "user/list";
        }
    }

    //下拉
    @GetMapping("/xiala")
    @ResponseBody
    public List<User> findAllUsername(){
        Map map = userService.findAll();
        List<User> list = (List<User>) map.get("list");
        return list;
    }
}
