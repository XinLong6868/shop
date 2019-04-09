package com.fh.shop.backend.common;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DELL
 * @title: WebContext
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/2818:49
 */
public class WebContext {
    private static final ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<>();

    public static void set(HttpServletRequest request){
        requestThreadLocal.set(request);
    }

    public static HttpServletRequest get(){
        return requestThreadLocal.get();
    }

    public static void remove(){
        requestThreadLocal.remove();
    }
}
