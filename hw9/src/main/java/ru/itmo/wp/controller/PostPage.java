package ru.itmo.wp.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ru.itmo.wp.domain.Comment;
import ru.itmo.wp.domain.Post;

@Controller
public class PostPage extends Page {
    @GetMapping("/post/{id}")
    public String post(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("comment", new Comment());
        return "PostPage";
    }

    @PostMapping("/post/{id}")
    public String saveComment(@PathVariable Long id, @Valid @ModelAttribute("comment") Comment comment, 
                                BindingResult bindingResult, HttpSession httpSession, Model model) {
        Post post = postService.findById(id);
        if (bindingResult.hasErrors() || post == null) {
            model.addAttribute("post", post);
            return "PostPage";
        }
        comment.setUser(getUser(httpSession));
        post.addComment(comment);
        postService.save(post);
        putMessage(httpSession, "Comment saved successfully");
        return "redirect:/post/" + id.toString();
    }
}
