package ru.itmo.wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Random;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.itmo.wp.util.ImageUtils;

public class CaptchaFilter extends HttpFilter{

    private static final String first = "<!DOCTYPE html>\r\n" + //
    "<html lang=\"en\">\r\n" + //
    "<head>\r\n" + //
    "    <meta charset=\"UTF-8\">\r\n" + //
    "    <title>CAPTCHA</title>\r\n" + //
    "    <link rel=\"shortcut icon\" href=\"data:,\" />\r\n" + //
    "</head>\r\n" + //
    "\r\n" + //
    "<body>\r\n" + //
    "    <div id=\"captcha\">\r\n" + //
    "        <img src=\"data:image/png;base64, ";

    private static final String second = "\" alt=\"OH NO CAPTCHA Image :(\" />\r\n" + //
    "        <form method=\"get\">\r\n" + //
    "            <input name=\"captcha\" id=\"captcha\" placeholder=\"Enter the captcha\" />\r\n" + //
    "        </form>\r\n" + //
    "    </div>\r\n" + //
    "</body>\r\n" + //
    "\r\n" + //
    "</html>";

    private static void sendCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Random random = new Random();
        String captcha = Integer.toString(random.nextInt(899) + 100);
        request.getSession().setAttribute("captcha", captcha);
        byte[] captchaBytes = ImageUtils.toPng(captcha);
        String captchaBase64 = Base64.getEncoder().encodeToString(captchaBytes);
        try (PrintWriter writer = response.getWriter()) {
            writer.print(
                first+captchaBase64+second
            );
            writer.flush();
        }
        response.setContentType("text/html");
    }
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getMethod().equals("GET")) {
            String captcha = (String) request.getSession().getAttribute("captcha");
            if (captcha == null) {
                sendCaptcha(request, response);
            } else if (captcha.equals("accepted")) {
                chain.doFilter(request, response);
            } else {
                if (captcha.equals(request.getParameter("captcha"))) {
                    request.getSession().setAttribute("captcha", "accepted");
                    chain.doFilter(request, response);
                } else {
                    sendCaptcha(request, response);
                }
            }
        } else {
            chain.doFilter(request, response);
        }
    }
}
