package com.fh.shop.backend.httpCtient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.FileWriter;
import java.io.IOException;

public class HttpText {
    public static void main(String[] args) {
        /*//打开浏览器
        CloseableHttpClient build = HttpClientBuilder.create().build();
        //输入网址
        HttpGet httpGet = new HttpGet("https://www.baidu.com");
        //发送请求
        CloseableHttpResponse response = null;
        try {
            response = build.execute(httpGet);
            //获取响应的内容
            HttpEntity responseEntity = response.getEntity();
            //将响应的内容转换
            String s = EntityUtils.toString(responseEntity, "utf-8");
            //将转换的内容输出到控制台
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭请求的网址
            if (response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //刷新浏览器
            if(httpGet !=null){
                httpGet.releaseConnection();
            }
            //关闭浏览器
            if (build !=null){
                try {
                    build.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
        //打开浏览器
        CloseableHttpClient build = HttpClientBuilder.create().build();
        //创建网址
        HttpGet httpGet = new HttpGet("https://www.qqmusic.com");
        //通过浏览器根据网址发送到
        CloseableHttpResponse response = null;
        try {
            response = build.execute(httpGet);
        //通过网址获得网址中的内容
            HttpEntity entity = response.getEntity();
            //将内容转化
            String s = EntityUtils.toString(entity, "utf-8");
            //将转换后的内容输出到控制台或者指定文件中
            FileWriter writer = new FileWriter("D:1808.html");
            writer.write(s);
            writer.flush();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭请求
            if (response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭网址
            if (httpGet != null){
                httpGet.releaseConnection();
            }
            //关浏览器
            if (build != null){
                try {
                    build.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
