package com.fh.shop.backend.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

public class COSUtil {

    /**
     * 删除上传到腾讯云的文件
     */
    public static void deleteFile(String path){
        COSClient cosClient = null;
        try {
            //创建客户端
            cosClient = buildCosClient();
            //指定文件所在的存储桶
            String backetName = SystemConstants.COS_BUCKETNAME;
            cosClient.deleteObject(backetName,path.replace(SystemConstants.COS_URL,""));
        } finally {
            if(cosClient!=null){
                cosClient.shutdown();
            }
        }

    }

    public static String fileInputUpload(InputStream is,String fileName){
        COSClient cosClient = null;
        String key = "";
        try {
            //创建客户端
            cosClient = buildCosClient();
            //当前时间年月日为string类型
            String folder = DateUtil.date2Str(new Date(), DateUtil.Y_M_D);
            //结合生成随机数生成唯一的文件名
            key = folder+"/"+ UUID.randomUUID().toString()+getSuffix(fileName);

            //System.out.println(SystemConstants.COS_URL+key);
            //设置文件内容的长度
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(is.available());
            //构建上传请求对象
            // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
            PutObjectRequest putObjectRequest = new PutObjectRequest(SystemConstants.COS_BUCKETNAME, key, is,objectMetadata);
             //上传
            cosClient.putObject(putObjectRequest);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭客户端
            if(cosClient==null){
                cosClient.shutdown();
            }
        }
        return SystemConstants.COS_URL+key;
    }

    //创建客户端
    private static COSClient buildCosClient() {
        // 1 初始化用户身份信息（secretId, secretKey）。
        COSCredentials cred = new BasicCOSCredentials(SystemConstants.COS_ACCESSKEY, SystemConstants.COS_SECRETKEY);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者接口文档 FAQ 中说明。
        ClientConfig clientConfig = new ClientConfig(new Region(SystemConstants.COS_AREA));
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }

    private static String getSuffix(String fileName) {
        int index = fileName.lastIndexOf(".");
        String suffix = fileName.substring(index);
        return suffix;
    }



}
