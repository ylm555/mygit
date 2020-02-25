package com.icss.ssm.face;

import java.util.ArrayList;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;

//主要用于人脸登录比对
//人脸识别-单例模式
public class FaceClient {
	private static volatile FaceClient faceClient;
	private AipFace client = null;
 
	//私有的构造方法，只能由本类调用
	private FaceClient(String APP_ID, String API_KEY, String SECRET_KEY) {
		client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
	}
 
	//公有的静态方法
	public static FaceClient getInstance() {
		if (faceClient == null) {
			synchronized (FaceClient.class) {
				if (faceClient == null) {
					faceClient = new FaceClient("17639679", "yV9UUaATeZjkjEXKnqDlx3BD", "NxFPvTGY1QEU2DIS11IUPdjxpmq7EVR7");
				}
			}
		}
		return faceClient;
	}

	public boolean faceContrast(String image1, String image2) {
		MatchRequest req1 = new MatchRequest(image1, "BASE64");
		MatchRequest req2 = new MatchRequest(image2, "BASE64");
		ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
		requests.add(req1);
		requests.add(req2);
		JSONObject res = client.match(requests);
		System.out.println(res.toString());
		Object object = res.get("result");
		System.out.println("res.get(\"result\")==" + object);
		if (object == null || object.toString().equals("null")) {
			return false;
		} else {
			res = (JSONObject) object;
			double result = res.getDouble("score");
			//相似度大于90 登入成功  
			if (result > 90) {
				return true;
			} else {
				return false;
			}
		}
	}
}