package com.fh.shop.api.member;

import com.fh.shop.api.util.CheckSumBuilder;
import com.fh.shop.api.util.HttpClientUtil;
import com.fh.shop.api.util.SMSUtil;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
/**
 * @author DELL
 * @title: TestSMS
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/1922:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-common.xml"})
public class TestSMS extends AbstractJUnit4SpringContextTests {

    @Resource(name = "smsUtil")
    private SMSUtil smsUtil;
    @Test
    public void testSendSMS(){
        String result = smsUtil.sendSMS("15552302330");
        System.out.println(result);
    }
}
