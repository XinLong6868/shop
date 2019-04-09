package com.fh.shop.backend.common;

import javax.servlet.http.HttpServletRequest;

public class WebContext {

    private static ThreadLocal<HttpServletRequest> requestContext=new ThreadLocal<HttpServletRequest>();

    //以前请求所对应的线程作为key,以request作为value进行储存，将当前所对应的线程和request进行绑定
    public static void setRequest(HttpServletRequest request){
        requestContext.set(request);
    }

    //以当前请求所对应的线程作为key，获取key对应的value，即request
    public static HttpServletRequest getRequest(){
        return requestContext.get();
    }

    //从ThreadLocal中上删除当前key,解除request和当前线程的绑定
    public static void remove(){
        requestContext.remove();
    }
}
