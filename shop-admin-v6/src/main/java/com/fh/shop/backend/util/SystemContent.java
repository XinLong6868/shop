package com.fh.shop.backend.util;

import java.util.UUID;

public class SystemContent {

    public static final int STATUS_SUCCESS = 1;

    public static final int STATUS_ERROR = 0;

    public static final int EXECUTE_TIME_ERROR = -1;

    public static final int USER_ERROR_COUNT = 3;

    public static final String PRODUCT_IMAGES_PATH = "/product/Images/";

    public static final String SESSION_IMGCODE = "scode";

    public static final String SESSION_USER = "user";

    public static final String SALT_UUID = UUID.randomUUID().toString();

}
