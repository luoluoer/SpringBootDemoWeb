
package cn.cfg.SpringBootDemoWeb.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cfg.SpringBootDemoWeb.mapper.UserMapper;
import cn.cfg.SpringBootDemoWeb.model.User;

/**
* 这是文档注释
* @author 柴方贵
* @version 创建时间：2022年11月3日 下午3:24:58
*/
@Controller   //@rescontroller请求不返回到html页面,而是返回到主体
public class hiController {
	@Autowired
	UserMapper usermapper;
	@GetMapping("/register")  //请求映射,浏览器中请求的路径
	public String reg() {
		return "register";
	}
	@RequestMapping("/register")
	public String register(HttpServletRequest request,Map<String,Object> map) {
		System.out.println("request的信息是:"+request);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		User user = new User();
		System.out.println("这是初次打印user:"+user);
		user.setUsername(username);
		System.out.println("这是第一次打印user:"+user);
		user.setPassword(password);
		System.out.println("这是第二次打印user:"+user);
		User user1 = usermapper.getUser(username);
		if(!(user1 ==null)) {
			map.put("msg1","the user has been registered please register agin");
			return "register";
		}else {
			usermapper.adduser(user);
			return "login";
		}

	}
	@RequestMapping("/deleteuser")
	public String deleteuser(HttpServletRequest request,Map<String ,Object> map) {
		String username = request.getParameter("username");
		User getuser = usermapper.getUser(username);
		if (!(getuser==null)){
			usermapper.deleteUser(username);
			map.put("msgdelete","the user has been deleted");
			return "login";
		}else {
			map.put("msgdelete","the user is not found");
			return "register";
		}
		//return null;
	}
	@RequestMapping("/getuser")
	public String getuser(HttpServletRequest request,Map<String ,Object> map) {
		String username = request.getParameter("username");
		User user = usermapper.getUser(username);
		if (user == null) {
			map.put("msg","the user has not been used");
			return "register";
		}else {
			map.put("msg","the user has been registered");
			return "register";
		}
	}
	@RequestMapping("updateuser")
	public String updateuser(HttpServletRequest request,Map<String ,Object> map) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User updateuser = usermapper.getUser(username);
		if(!(updateuser==null)) {
			usermapper.updatepassword(username,password);
			map.put("msgupdate","the password has been updated");
			return "login";
		}else {
			map.put("msgupdate","the user is not a legal user");
			return "login";
		}
		
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Map<String,Object> map) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User loginuser = usermapper.login(username,password);
		System.out.println(loginuser);
		map.put("msglogin","the user "+ loginuser+" login");
		return "login";
		
	}
}
