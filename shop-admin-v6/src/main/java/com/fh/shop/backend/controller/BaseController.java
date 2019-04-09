package com.fh.shop.backend.controller;

import com.fh.shop.backend.common.FileInfo;
import com.fh.shop.backend.util.SystemContent;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BaseController {


	protected String getRootPath(HttpServletRequest request) {
		return request.getServletContext().getRealPath("/");
	}
	protected String getRealPath(HttpServletRequest request) {
		return request.getServletContext().getRealPath(SystemContent.PRODUCT_IMAGES_PATH);
	}

	protected FileInfo addFile(MultipartFile[] photo, MultipartFile productImg) throws IOException {
		FileInfo fileInfo=new FileInfo();
		fileInfo.setIs(productImg.getInputStream());
		fileInfo.setFileName(productImg.getOriginalFilename());
		fileInfo.setSize(productImg.getSize());
		fileInfo.setMultipartFile(photo);
		return fileInfo;
	}

	protected FileInfo converFileInfo(@RequestParam("photo") MultipartFile[] photo, @RequestParam MultipartFile productImg) throws IOException {
		FileInfo fileInfo=new FileInfo();
		fileInfo.setIs(productImg.getInputStream());
		fileInfo.setFileName(productImg.getOriginalFilename());
		fileInfo.setSize(productImg.getSize());
		fileInfo.setMultipartFile(photo);
		return fileInfo;
	}
	
	public void outJson(String json, HttpServletResponse response) {
		PrintWriter writer = null;
		try {
			response.setContentType("appliaction/json;charset=utf-8");
			//通过response获取writer
			 writer = response.getWriter();
			 //通过writer讲字符串响应给客户端【浏览器】
			 writer.write(json);   
			 //清空
			 writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//关流
			if (null != writer) {
				writer.close();
				writer = null;
			}
		}
	}

}
