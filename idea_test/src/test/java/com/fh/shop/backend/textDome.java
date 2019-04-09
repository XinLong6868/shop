package com.fh.shop.backend;

import org.junit.*;

public class textDome {
    @Test
    public void textAddShop(){
        System.out.println("<<<<========textAddShop=========>>>>>");
    }
    @Test
    public void textUpdateShop(){
        System.out.println("<<<<========textUpdateShop=======>>>>>");
    }
    @After
    public void afterAddShop(){
        System.out.println("========afterAddShop=========");
    }
    @AfterClass
    public static void afterAddShopCla(){
        System.out.println("========afterAddShopCla=========");
    }
    @BeforeClass
    public static void beforeAddShopCla(){
        System.out.println("========beforeAddShopCla=========");
    }
    @Before
    public void beforeInsertShop(){
        System.out.println("========beforeInsertShop=========");
    }
}
