package com.junes.springboot.myfirstwebapp.login;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping("/login")
    public String loginJsp(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        logger.debug("Request param is {}", name);
        logger.info("I want this printed at info level");
        // JSP 사용 시, return 값은 jsp 파일명과 일치해야 한다!
        return "login";
    }
}
