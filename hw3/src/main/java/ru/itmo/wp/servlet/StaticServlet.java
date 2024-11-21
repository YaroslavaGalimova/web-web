package ru.itmo.wp.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.StringTokenizer;

public class StaticServlet extends HttpServlet {

    private final void response(HttpServletRequest request, HttpServletResponse response, File file) throws IOException {
        if (!response.containsHeader("Content-Type")) {
            response.setContentType(getServletContext().getMimeType(file.getName()));
        }
        try (OutputStream outputStream = response.getOutputStream()) {
            Files.copy(file.toPath(), outputStream);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uriTokens = request.getRequestURI();
        StringTokenizer tokenizer = new StringTokenizer(uriTokens, "+");
        while (tokenizer.hasMoreTokens()) {
            String uri = tokenizer.nextToken();
            File file;
            if ((file = new File("C:\\Users\\LENOVO\\ITMO\\web-web\\hw3\\src\\main\\webapp\\static\\", uri)).isFile()) {
                response(request, response, file);
            } else if ((file = new File(getServletContext().getRealPath("/static/" + uri))).isFile()) {
                response(request, response, file);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
        }
    }
}
