package com.junes.springboot.myfirstwebapp.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    // say-hello => "Hello! What are you learning today?"

    // http://localhost:8080/say-hello
    @RequestMapping("/say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello! What are you learning today?";
    }

    // html 응답 위한 방법
    @RequestMapping("say-hello-html")
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My First HTML Page - Changed</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first html page with body - Changed");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    // JSP사용
    // say-hello-jsp => SayHelloController => sayHelloJsp method => sayHello
    // 경로 : src/main/webapp/WEB-INF/jsp/sayHello.jsp
    @RequestMapping("/say-hello-jsp")
    public String sayHelloKJsp() {
        return "sayHello";
    }


}
