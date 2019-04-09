package com.fh.shop.backend.util;

import java.util.HashMap;
import java.util.Map;

public final class SystemContent {

    public static final int STATUS_SUCCESS=1;

    public static final int STATUS_ERROR=0;

    public static final int EXCUTE_TIME_ERROR=-1;

    public static final String PRODUCT_IMAGES_PATH ="/product/Images/";

    public static final String IMGCODE="imgcode";

    public static final int USER_STATUS = 1;
    /*白名单：将要放行的请求放入*/
    public static final String WHITE_LIST = "/user/addUserInfo.action,/user/login.action,/api/product/findList.action";

    public static final Map FIELD_MAPPING = new HashMap();
    /*静态块,加载类的时候使用*/
    static {
        FIELD_MAPPING.put("productprivace", "productprivace");
        FIELD_MAPPING.put("createTimeStr", "createTime");
        FIELD_MAPPING.put("updateTimeStr", "updateTime");
    }
    public static final String ORDER_COLUMN = "order[0][column]";

    public static final String ORRDER_DIR = "order[0][dir]";
}
