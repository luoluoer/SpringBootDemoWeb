
package cn.cfg.SpringBootDemoWeb.model;

/**
* 这是文档注释
* @author 柴方贵
* @version 创建时间：2022年11月2日 下午11:47:20
*/
public class User {
	public User() {
		super();
	}
	public User(int id, String username, String pwd) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
	}
	
	private int id;
	private String username;
	private String pwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + "]";
	}
	
}
