
package com.fh.shop.backend.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * 
 * <pre>项目名称：shop-admin-v2    
 * 类名称：BaseController    
 * 类描述：    
 * 创建人：辛龙       2427776882@qq.com    
 * 创建时间：2018年12月26日 下午10:37:26    
 * 修改人：辛龙       2427776882@qq.com     
 * 修改时间：2018年12月26日 下午10:37:26    
 * 修改备注：       
 * @version </pre>
 */
public class BaseController {
	
	
	public void outJson(String json, HttpServletResponse response) {
		PrintWriter writer = null;
		try {
			//通过response获得writer
			 writer = response.getWriter();
			 //通过writer向客户端发出相应字符串
			 writer.write(json);
			 //清空
			 writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭资源
			if (null != writer) {
				writer.close();
				//重置
				writer = null;
			}
		}
	}

}
