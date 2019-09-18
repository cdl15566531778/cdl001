package com.ujiuye.usual.controller;

import com.ujiuye.usual.bean.Evaluate;
import com.ujiuye.usual.bean.Forumpost;
import com.ujiuye.usual.service.ForumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("forum")
public class ForumController {
    @Resource
    private ForumService forumService;

    @Resource
    private JedisPool jedisPool;



    @RequestMapping("addForum")
    public String addForum(Forumpost forumpost){
        Jedis jedis = jedisPool.getResource();
        String eid = jedis.hget("employee", "eid");
        forumpost.setEmpFk3(Integer.parseInt(eid));
        boolean flag = forumService.addForum(forumpost);
        if(flag){
            return "redirect:/forum-showmyself.jsp";
        }else {
            return "error";
        }
    }

    @RequestMapping("showAllForum")
    @ResponseBody
    public List<Forumpost> showAllForum(){
        return forumService.showAllForum();
    }


    @RequestMapping("getForumAndReply")
    public String getForumAndReply(@ModelAttribute("fid") Integer fid, HttpSession session){
        Forumpost forumpost = forumService.getForumAndReply(fid);
        System.out.println(forumpost);
        session.setAttribute("forum" ,forumpost);
        return "forum-reply";
    }

    //添加评论
    @RequestMapping("addEvaluate")
    public String addEvaluate(Evaluate evaluate, RedirectAttributes ra){
        Jedis jedis = jedisPool.getResource();
        String eid = jedis.hget("employee","eid");
        evaluate.setEmpFk4(Integer.parseInt(eid));
        boolean flag = forumService.addEvaluate(evaluate);
        if(flag){
            ra.addFlashAttribute("fid",evaluate.getForumFk());
            return "redirect:/forum/getForumAndReply";
        }else {
            return "error";
        }
    }
}
