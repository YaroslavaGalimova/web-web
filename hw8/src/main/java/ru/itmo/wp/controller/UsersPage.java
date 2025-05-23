package ru.itmo.wp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.itmo.wp.domain.User;
import ru.itmo.wp.service.UserService;

@Controller
public class UsersPage extends Page {
    public UsersPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/all")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "UsersPage";
    }

    @PostMapping("/users/all")
    public String changeUserStatus(Long userId, boolean status, HttpSession httpSession) {
        User user = userService.findById(userId);
        userService.updateStatus(user, status);
        if (user != null) {
            setMessage(httpSession, "Status was changed sucessfully!");
        }
        return "redirect:/users/all";
    }

}
