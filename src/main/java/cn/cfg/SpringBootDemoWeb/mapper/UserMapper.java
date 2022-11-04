
package cn.cfg.SpringBootDemoWeb.mapper;

import java.util.*;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import cn.cfg.SpringBootDemoWeb.model.User;

/**
* 这是文档注释
* @author 柴方贵
* @version 创建时间：2022年11月2日 下午11:51:30
*/
@Mapper
public interface UserMapper {
	@Insert("insert into user(username,password) values (#{username},#{password})")
	void adduser(User user); 
	@Select("select * from user where username = #{username}")
	User getUser(String username);
	@Select("select * from user where username = #{username} and password = #{password}")
	User login(String username,String password);
	@Delete("delete from user where username = #{username}")
	void deleteUser(String username);
	@Update("update user set password = #{password} where username = #{username}")
	void updatepassword(String username,String password);

}
