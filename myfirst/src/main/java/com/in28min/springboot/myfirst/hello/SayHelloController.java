package com.in28min.springboot.myfirst.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		logger.debug("Did not expect to see you!");
		return "Hello Darkness, my old friend!";
	}
	
	@RequestMapping("hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb= new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Trial Html</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first Page using Spring boot");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJSP() {
		return "sayHello";
	}
}
