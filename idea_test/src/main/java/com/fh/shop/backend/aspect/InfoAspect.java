package com.fh.shop.backend.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class InfoAspect {
                public Object say(ProceedingJoinPoint pjp){
                        System.out.println("888");

                    //将局部变量手动初始化（局部变量必须手动初始化）
                    Object result = null;
                    try {
                        //执行真正的业务逻辑代码
                        //result对应是方法的返回值
                        result=pjp.proceed();
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                    return result;
                }
}
