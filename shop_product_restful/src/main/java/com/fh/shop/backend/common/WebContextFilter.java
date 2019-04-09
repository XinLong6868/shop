package com.fh.shop.backend.common;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author DELL
 * @title: ${NAME}
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/2819:08
 */
public class WebContextFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        WebContext.set((HttpServletRequest) req);
        try {
            chain.doFilter(req, resp);
        }finally {
            WebContext.remove();
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
