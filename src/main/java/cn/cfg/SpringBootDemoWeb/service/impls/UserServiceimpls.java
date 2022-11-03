
package cn.cfg.SpringBootDemoWeb.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cfg.SpringBootDemoWeb.mapper.UserMapper;
import cn.cfg.SpringBootDemoWeb.model.User;
import cn.cfg.SpringBootDemoWeb.service.UserService;

/**
* 这是文档注释
* @author 柴方贵
* @version 创建时间：2022年11月3日 下午1:40:19
*/
@Service
public class UserServiceimpls implements UserService {
	@Autowired
	private UserMapper usermapper; 
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		List <User> users = usermapper.userlist();
		return null;
	}

}
