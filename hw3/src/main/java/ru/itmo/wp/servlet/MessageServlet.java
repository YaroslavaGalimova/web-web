package ru.itmo.wp.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

public class MessageServlet extends HttpServlet {

    private static class Message {
        private final String user;
        private final String text;

        private Message(String user, String text) {
            this.user = user;
            this.text = text;
        }
    }

    private List<Message> Messages = new ArrayList<Message>();
    private void jsonResponse(Object obj, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("application/json");
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        response.getWriter().print(new Gson().toJson(obj));
        response.getWriter().flush();
        response.getWriter().close();
    }

    private final void messageAuth (HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String user = request.getParameter("user");
        if (user != null) {
            session.setAttribute("username", user);
        }
        if (session.getAttribute("username") != null) {
            jsonResponse((String) session.getAttribute("username"), response);
        } else {
            jsonResponse("", response);
        }
    }

    private final void messageAdd (HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        String message = request.getParameter("text");
        System.out.println(message);
        if (message != null && !message.trim().isEmpty()) {
            Messages.add(new Message(username, message));
            jsonResponse(message, response);
        } else {
            jsonResponse("", response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        HttpSession session =  request.getSession();
        switch (uri) {
            case "/message/auth": {
                messageAuth(request, response, session);
                break;
            }
            case "/message/findAll": {
                jsonResponse(Messages, response);
                break;
            }
            case "/message/add": {
                messageAdd(request, response, session);
                break;
            }
            default: {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
        }
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
