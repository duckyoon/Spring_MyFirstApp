package com.junes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") // 사용하려는 모든 컨트롤러에 넣어줘야한다.
public class WelcomeController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("name", "junes");
        return "welcome";
    }
}
