package com.fh.shop.api.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * @author DELL
 * @title: HttpClientUtil
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/1918:56
 */
public class HttpClientUtil {

    public static String sendPost(String url, Map<String,String> headers,Map<String,String> params){
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        if (headers != null && headers.size() > 0){
            //迭代循环
            Iterator<Map.Entry<String, String>> iterator = headers.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> next = iterator.next();
                String key = next.getKey();
                String value = next.getValue();
                httpPost.addHeader(key,value);
            }
        }
        if (params != null && params.size() > 0){
            ArrayList<NameValuePair> paramList = new ArrayList();
            Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> next = iterator.next();
                String key = next.getKey();
                String value = next.getValue();
                paramList.add(new BasicNameValuePair(key,value));
            }
            UrlEncodedFormEntity urlEncodedFormEntity = null;
            try {
                urlEncodedFormEntity = new UrlEncodedFormEntity(paramList, "utf-8");
                httpPost.setEntity(urlEncodedFormEntity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        CloseableHttpResponse response = null;
        String result = "";
        try {
            response = client.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != response){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpPost){
                httpPost.releaseConnection();
            }
            if (client != null){
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }



}
