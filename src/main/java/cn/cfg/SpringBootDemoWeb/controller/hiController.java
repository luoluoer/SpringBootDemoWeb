
package cn.cfg.SpringBootDemoWeb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 这是文档注释
* @author 柴方贵
* @version 创建时间：2022年11月3日 下午3:24:58
*/
@RestController   //请求不返回到html页面,而是返回到主体
public class hiController {
	@GetMapping("/hi")  //请求映射,浏览器中请求的路径
	@RequestMapping("/hi")
	public String hi() {
		return "hi Springboot";
	}
}
