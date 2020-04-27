package ru.study.parking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.study.parking.dao.dao.UserDao;
import ru.study.parking.entity.UserEntity;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/main")
public class WebController {

    UserDao userDao;

    @Autowired
    public WebController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public String mainPage(Model model, @AuthenticationPrincipal UserEntity user){
        Map<Object, Object> data = new HashMap<>();
        data.put("profile", user);

        model.addAttribute("frontendData", data);
        return "index";
    }

}
