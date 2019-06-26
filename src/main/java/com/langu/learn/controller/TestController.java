package com.langu.learn.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
public class TestController {

    /**
     * 看看springsecurity把用户存到哪里去了，如果拿到
     *
     * @param session
     * @return
     */
    @GetMapping("/session")
    @ResponseBody
    public String getSession(HttpSession session) {
        Enumeration<String> attributeNames = session.getAttributeNames();
        System.out.println(attributeNames.hasMoreElements());
        Object security = session.getAttribute("SPRING_SECURITY_CONTEXT");
        System.out.println(security.getClass());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println(authentication);
        return "ok";

    }

}
