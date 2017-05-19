package cn.bangnongmang.notify.server.service.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpClientUtil {

	private OkHttpClient client;

	public HttpClientUtil() {
		client = new OkHttpClient();
	}

	public String post(String url) {
		Request.Builder rBuilder = new Request.Builder();
		RequestBody requestBody = new FormBody.Builder().build();
		Request request = rBuilder.url(url).post(requestBody).build();
		Response response = null;
		try {
			response = client.newCall(request).execute();

			if (response.isSuccessful()) {
				String data = response.body().string();

				return data;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public String postJson(String url, String postData) {
		Request.Builder rBuilder = new Request.Builder();
		RequestBody requestBody = RequestBody.create(MediaType.parse("JSON"), postData);
		Request request = rBuilder.url(url).post(requestBody).build();
		Response response = null;
		try {
			response = client.newCall(request).execute();

			if (response.isSuccessful()) {
				String data = response.body().string();

				return data;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public String httpUrl;
	
	public String executePost(Object obj,String httpUrl) throws Exception{
	    this.httpUrl=httpUrl;
		String result = "";
		Class cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();
		List params = new ArrayList();

		String fieldName = null;
		String fieldNameUpper = null;
		Method getMethod = null;
		String value = null;
		for (int i = 0; i < fields.length; i++)   {
			fieldName = fields[i].getName();
			fieldNameUpper = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
			getMethod = cls.getMethod("get" + fieldNameUpper);
			value = (String) getMethod.invoke(obj);
			if(value != null) {
				params.add(new BasicNameValuePair(fieldName, value)); 
			}
		}
		HttpPost httppost = new HttpPost(httpUrl);
		
		httppost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8)); // 设置参数的编码
	
		HttpClient httpclient = new DefaultHttpClient();
		
		HttpEntity entity = httpclient.execute(httppost).getEntity();
		
		if(entity != null && entity.getContentLength() != -1) {
			result=EntityUtils.toString(entity);
		}
		httpclient.getConnectionManager().shutdown();
		return result;
		
	}
	
}
