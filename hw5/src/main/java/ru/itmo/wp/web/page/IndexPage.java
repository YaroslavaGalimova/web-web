package ru.itmo.wp.web.page;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class IndexPage {
    private void action(Map<String, Object> view, HttpServletRequest request){
        view.put("name", "gera");
    }
}
