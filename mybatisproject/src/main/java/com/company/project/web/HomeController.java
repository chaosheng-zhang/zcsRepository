package com.company.project.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.model.Msg;
import com.company.project.model.User;
import com.company.project.service.RedisService;


/**
 * 
 * @author: zhangcs
 * @Description: 
 * @date: 2017年12月26日 上午9:03:30
 */
@Controller
public class HomeController {
	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private RedisService redisService;
	
    @RequestMapping("/")
    public String index(Model model,@ModelAttribute  User user) {
    	logger.info("进入HomeController测试~~~~~~~~~~~~~~~~");
    	System.out.println("进入HomeController测试~~~~1~~~~~~~~~~~~"+user.getName());
//        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
    	String name1 ="admin";
    	
    	System.out.println("user is null-----"+(user!=null));
    	System.out.println("username-----"+("".equals(user.getName()))+user.getName());
    	if(user!=null&& !"".equals(user.getName()) && (user.getName() !=null)) {
    		
    		name1 = (String) redisService.get(user.getName());
    	}
    	System.out.println("username=="+name1);
    	Msg msg = new Msg(user.getName(), name1, "");
        model.addAttribute("msg", msg);
        return "index";
    }
    @RequestMapping("/index1")
    public String index1(Model model) {
    	logger.info("进入HomeController测试~~~~~~~~~~~~~~~~");
    	System.out.println("进入HomeController测试~~~~1~~~~~~~~~~~~");
    	Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
    	model.addAttribute("msg", msg);
    	return "index";
    }
    
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        System.out.println(name+" welcome . My is microservice provider user");
        return name+" welcome . My is microservice provider user";
    }
}
