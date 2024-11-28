package ru.itmo.wp.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import ru.itmo.wp.domain.Notice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AddNoticePage extends Page{
    
    @GetMapping("/addNotice")
    public String saveNotice(Model model) {
        model.addAttribute("notice", new Notice());
        return "AddNotice";
    }

    @PostMapping("/addNotice")
    public String saveNotice(@Valid @ModelAttribute("notice") Notice notice, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "AddNotice";
        }
        noticeService.addNotice(notice);
        setMessage(httpSession, "Your message was sucessfully added!");
        return "redirect:/addNotice";
    }
    
}
