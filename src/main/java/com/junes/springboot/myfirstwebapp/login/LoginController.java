package com.junes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginJsp(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        // JSP 사용 시, return 값은 jsp 파일명과 일치해야 한다!
        return "login";
    }
}
