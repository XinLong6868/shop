package com.fh.shop.backend.aspect;

import com.fh.shop.backend.annnotation.Log;
import com.fh.shop.backend.biz.log.ILogService;
import com.fh.shop.backend.common.ResponseEnum;
import com.fh.shop.backend.common.ServerResponse;
import com.fh.shop.backend.common.WebContext;
import com.fh.shop.backend.po.log.LogInfo;
import com.fh.shop.backend.po.user.UserInfo;

import com.fh.shop.backend.util.SystemContent;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;


public class LogAspect {
    @Resource(name = "logService")
    private ILogService logService;

    private static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);

    public Object doLog(ProceedingJoinPoint pjp) {
        Object result = null;
        UserInfo user = null;
        //动态获取类名
        String className = pjp.getTarget().getClass().getCanonicalName();
        //动态获取方法名
        String methodName = pjp.getSignature().getName();
        //动态获取返回值
        MethodSignature ms = (MethodSignature) pjp.getSignature();
        String methodReturnType = ms.getReturnType().getSimpleName();
        Method method = ms.getMethod();
        String content = "";
        //判断方法上是否有自定义注解
        if (method.isAnnotationPresent(Log.class)) {
            //获取指定的自定义注解
            Log annotation = method.getAnnotation(Log.class);
            //获取注解的内容
            content = annotation.value();
        }
        LogInfo logInfo = new LogInfo();
        try {
            //返回当前毫秒值
            long start = System.currentTimeMillis();
            // 执行真正的方法,方法执行后的返回值：result
            result = pjp.proceed();
            //返回当前毫秒值
            long end = System.currentTimeMillis();
            //获取用户信息,在login方法执行之后才会将信息存放在session中
            user = (UserInfo) WebContext.getRequest().getSession().getAttribute("userInfo");
            //判断user对象是否为空
            if (user == null) {
                return result;
            }
            LOG.info("{}执行{}的{}()成功", user.getUserName(), className, methodName);
            logInfo.setUserName(user.getUserName());
            logInfo.setInfo("执行" + className + "的" + methodName + "成功");
            logInfo.setCreateTime(new Date());
            logInfo.setExcuteTime((int) (end - start));
            logInfo.setStatus(SystemContent.STATUS_SUCCESS);
            //记录日志
            logInfo.setContent(content);
            logService.addLog(logInfo);
        } catch (Throwable e) {
            e.printStackTrace();
            user = (UserInfo) WebContext.getRequest().getSession().getAttribute("userInfo");

            LOG.error("{}进入{}的()失败:{}", user.getUserName(), className, methodName, e.getMessage());
            logInfo.setUserName(user.getUserName());
            logInfo.setInfo("执行" + className + "的" + methodName + "失败:" + e.getMessage());
            logInfo.setCreateTime(new Date());
            logInfo.setExcuteTime(SystemContent.EXCUTE_TIME_ERROR);
            logInfo.setStatus(SystemContent.STATUS_ERROR);
            logInfo.setContent(content + "失败了");
            //记录日志
            logService.addLog(logInfo);
            //错误日志异常信息
            if (methodReturnType.equalsIgnoreCase("string")) {
                return "error.jsp";
            } else {
                return ServerResponse.error();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new HashMap<>();
    }

}
