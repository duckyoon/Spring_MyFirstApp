package com.junes.springboot.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") // 사용하려는 모든 컨트롤러에 넣어줘야한다.
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String gotoWelcomPage(@RequestParam String name, @RequestParam String password,
                                 ModelMap model) {

        if (authenticationService.authenticate(name, password)){
            model.put("name", name);
            model.put("password", password);
            return "welcome";
        }
        model.put("errorMessage", "Invalid Credentials! Please try again.");
        return "login";

    }
}
