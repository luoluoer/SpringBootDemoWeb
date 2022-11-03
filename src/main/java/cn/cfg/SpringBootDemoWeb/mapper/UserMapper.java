
package cn.cfg.SpringBootDemoWeb.mapper;

import java.util.*;

import org.springframework.stereotype.Repository;

import cn.cfg.SpringBootDemoWeb.model.User;

/**
* 这是文档注释
* @author 柴方贵
* @version 创建时间：2022年11月2日 下午11:51:30
*/
@Repository
public class UserMapper {
	private static Map<String,User> usermap = new HashMap<>() ;
	static {
		usermap.put("zhangsan",new User(1,"zhangsan","111111"));
		usermap.put("lisi",new User(2,"lisi","222222"));
		usermap.put("wangwu",new User(3,"wangwu","333333"));
	}
	public List<User> userlist(){
		List<User> users  = new ArrayList<>();
		users.addAll(usermap.values());
		return users;
	}
}
