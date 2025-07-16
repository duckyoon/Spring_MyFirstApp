package com.junes.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        // 하드코딩된 사용자 ID를 수정
        model.put("name", getLoggedinUsername());
        return "welcome";
    }

    // spring secrity 로부터 유저네임을 받는다
    private String getLoggedinUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();

    }
}
