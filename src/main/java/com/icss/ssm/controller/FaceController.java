package com.icss.ssm.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icss.ssm.entity.User;
import com.icss.ssm.face.FaceClient;
import com.icss.ssm.service.UserService;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
@Controller
public class FaceController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/goFaceRegist.do")
	public String goFacePage() {
		return "forward:face/face.jsp";
	}
	
	
	
	//人脸注册
	@RequestMapping("/faceRegist.do")
	public void faceRegist(String base, HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
				boolean message = false;
				User user = (User)session.getAttribute("user");
				//从session中把用户姓名取出
				String username = user.getUsername();
				String path = "D:/headPhoto/";
		        //存储头像的路径
				String urlPath=path+username+".jpg";//D:/headPhoto//lucy.jpg
		        
				//创建一个file对象
		        File uploadDir = new File(path);
		        if (!uploadDir.exists() && !uploadDir.isDirectory()) {// 检查目录
					uploadDir.mkdirs();  //创建目录
				}
		        path+=username+".jpg";//D:/headPhoto/lucy.jpg
				OutputStream out = null; //输出流对象
		        InputStream is = null;  //输入流对象
				try {
					byte[] imgByte  = new BASE64Decoder().decodeBuffer(base); 
					for (int i = 0; i < imgByte.length; ++i) {
						if (imgByte[i] < 0) {// 调整异常数据
						imgByte[i] += 256;
						}
					}
					out = new FileOutputStream(path);
					is = new ByteArrayInputStream(imgByte);
					byte[] buff = new byte[1024];
			        int len = 0;
			        //一个字符一个字符的读
			        while((len=is.read(buff))!=-1){
			            out.write(buff, 0, len);  //写入 
			        }
			        
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(is!=null){
						try {
							is.close();  //关闭流对象
					       
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if(out!=null){
						try {
							out.close();//关闭流对象
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					}
				
				userService.updateFaceUrlById(user.getId(), urlPath,path);
				message = true;
				response.getWriter().print(message);//响应数据
	}
		
		
		//人脸登录
		@RequestMapping("/faceLogin.do")
		public void faceLogin(String base, HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
			List<User> list = userService.findAllUserList();
			boolean message = false;
			for (int i = 0; i < list.size(); i++) {
				User user = list.get(i);
				if (user.getFaceurl() != null && !user.getFaceurl().trim().equals("")) {
					String base1 = this.getImageStr(user.getFaceurl());
					FaceClient faceClient = FaceClient.getInstance();
					boolean loginBool = faceClient.faceContrast(base, base1);
					if (loginBool) {
						message=true;
						session.setAttribute("user",user);
						break;
					}}}
			response.getWriter().print(message);
		}
		//将图片文件转化为字节数组字符串，并对其进行Base64编码处理 
		public  String getImageStr(String imgFile){ 
	        InputStream in = null;  
	        byte[] data = null;  
	        //读取图片字节数组  
	        try   
	        {  
	            in = new FileInputStream(imgFile);          
	            data = new byte[in.available()];  
	            in.read(data);  
	            in.close();  
	        }   
	        catch (IOException e)   
	        {  
	            e.printStackTrace();  
	        }  
	        //对字节数组Base64编码  
	        BASE64Encoder encoder = new BASE64Encoder();  
	        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
	    } 
}
