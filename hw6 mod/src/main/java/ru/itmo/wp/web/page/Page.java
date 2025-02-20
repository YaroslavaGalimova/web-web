package ru.itmo.wp.web.page;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.google.common.base.Strings;

import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.service.UserService;

public class Page {
    protected final UserService userService = new UserService();
    private HttpServletRequest request = null;

    protected void putMessage(Map<String, Object> view) {
        String message = (String) request.getSession().getAttribute("message");
        if (!Strings.isNullOrEmpty(message)) {
            view.put("message", message);
            request.getSession().removeAttribute("message");
        }
    }

    protected void setMessage(String message) {
        if (!Strings.isNullOrEmpty(message)) {
            request.getSession().setAttribute("message", message);
        }
    }
    
    private void putUser(Map<String, Object> view) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            view.put("user", user);
        }
    }

    protected User getUser() {
        User user = (User) request.getSession().getAttribute("user");
        return user;
    }

    protected void setUser(User user) {
        if (user != null) {
            request.getSession().setAttribute("user", user);
        }
    }

    protected void before(HttpServletRequest request, Map<String, Object> view) {
        this.request = request;
        view.put("userCount", userService.findCount());
        putUser(view);
        putMessage(view);
    }
    
    protected void after(HttpServletRequest request, Map<String, Object> view) {
        // No operations.
    }

    protected void action(HttpServletRequest request, Map<String, Object> view) {
        // no action
    }
}
