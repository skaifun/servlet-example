package fun.skai.example.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(HelloServlet.class);
    private String defaultName;

    @Override
    public void init() {
        // 获取初始化参数
        String defaultName = getInitParameter("defaultName");
        this.defaultName = defaultName != null && !defaultName.isEmpty() ? defaultName : "world";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取请求参数 name
        String name = request.getParameter("name");
        log.info("name from request params is {}", name);
        if (name == null || name.isEmpty()) {
            log.info("empty name, use default name {}", this.defaultName);
            name = this.defaultName;
        }
        // 响应请求
        log.info("writing hello message to response...");
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.format("hello, %s", name);
        out.close();
    }

}
