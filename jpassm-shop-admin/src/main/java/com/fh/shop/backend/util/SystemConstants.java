package com.fh.shop.backend.util;

public final class SystemConstants {
    //记录日志的成功状态
    public static final int SUCCESS_STATUS=1;
    //记录日志的异常状态
    public static final int ERROR_STATUS=0;
    //记录日志的异常内容状态
    public static final int ERROR_USETIME=-1;
    //单个文件上传保存指定的文件夹
    public static final String PRODUCT_IMAGES_PATH="/images/product/";
    //多个文件上传保存指定的文件夹
    public static final String PRODUCT_IMAGESMONEY_PATH="/imagesMoney/product/";
    //记录日志的异常内容状态
    public static final String IMAGECODE="code";
    //用户账号锁定状态
    public static final int USER_LOCKED_STATUS=1;
    //用户当前错误的登陆次数
    public static final int CURRY_ERROR_LOGINCOUNT=3;
    //登陆成功时seeeion中的用户
    public static final String CURRY_SESSION_USER="user";
    //登陆页面url
    public static final String LOGIN_URL="/login.jsp";
    //白名单 拦截器中放行的url字符串
    public static final String WHITE_URL="/login.jhtml,/toAddUserPage.jhtml,/addUser.jhtml,/api/product/productList.jhtml";
    //获取排序的列
    public static final String GET_ORDER_COLUMN="order[0][column]";
    //获取排序的方向Direction
    public static final String GET_ORDER_DIRECTION="order[0][dir]";
    //排序时map映射
    public static final String FILELDMAPPING="{brandEntryTimeStr:brandEntryTime,brandUpdateTimeStr:brandUpdateTime}";
    /*//排序时map映射
    public static final Map FILELDMAPPING=new HashMap<>();
    //静态块  静态块只能调用静态变量
    static {
        FILELDMAPPING.put("brandEntryTimeStr","brandEntryTime");
        FILELDMAPPING.put("brandUpdateTimeStr","brandUpdateTime");
    }*/
    //https://fh-1808-shop-1258899169.cos.ap-shanghai.myqcloud.com
    public static final String COS_URL = "https://xinlong-1258899144.cos.ap-beijing.myqcloud.com/";
    public static final String COS_ACCESSKEY = "AKIDWfdOT9PTN7yBFlCttFrStEOSKfsumgOv";
    public static final String COS_SECRETKEY = "iFarBNRY4RluGz5hQ3c5OXYcYlroaDfz";
    public static final String COS_BUCKETNAME = "xinlong-1258899144";
    public static final String COS_AREA = "ap-beijing";
    // 1258899169
    //SecretId: AKID1qQmsjGAk49ymMzry85mGWWHn9JXuQ0L
    //SecretKey: FFpCLErFPK0VpwnQpzua6NPDpDMlw2FT;
}
