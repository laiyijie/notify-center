package cn.bangnongmang.notify.server.outerservice;

import com.alibaba.fastjson.JSONObject;

public class WechatModalMessage {

	private JSONObject data;

	private String templateId;
	private String url;
	
	
	public static final String DEFAULT_COLOR = "#173177";
	public static final String COLOR_BLACK = "#000000";
	public static final String DEFAULT_REMARK = "如有问题，请致电客服：021-33683956，帮农忙将第一时间为您服务！";

	private static final String DEFAULT_URL_PREFIX = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxcc7f55d093059336&redirect_uri=http%3A%2F%2Fbnm.agribiotech.cn%2Fserver%2Fwx%2Faccount%2Fwechatenter&response_type=code&scope=snsapi_userinfo&state=";
	
	public WechatModalMessage(String templateId){
		data = new JSONObject();
		this.templateId = templateId;
		this.url = DEFAULT_URL_PREFIX + "index%2Fprofile#wechat_redirect";
	}
	public WechatModalMessage(String templateId,String pageFirst,String pageSecond){
		data = new JSONObject();
		this.templateId = templateId;
		this.url = DEFAULT_URL_PREFIX + pageFirst + "%2F"+pageSecond+"#wechat_redirect";
	}
	public WechatModalMessage(String templateId,String url){
		data = new JSONObject();
		this.templateId = templateId;
		this.url = url;
	}
	
	public WechatModalMessage addData(String key, String value, String color) {

		JSONObject v = new JSONObject();

		v.put("data", value);
		v.put("value", value);
		v.put("color", color);
		data.put(key, v);
		return this;
	}

	public WechatModalMessage addData(String key, String value) {

		return addData(key, value, DEFAULT_COLOR);
	}

	public WechatModalMessage addFirst(String value, String color) {

		value = "\n" + value + "\n";

		return addData("first", value, color);
	}

	public WechatModalMessage addFirst(String value) {

		return addFirst(value,DEFAULT_COLOR);
	}
	
	public WechatModalMessage addRemark(String value,String color){
		
		return addData("remark", value,color);
	}
	public WechatModalMessage addRemark(String value){
		
		return addRemark(value,DEFAULT_COLOR);
	}
	public WechatModalMessage addRemark(){
		
		return addRemark(DEFAULT_REMARK);
	}
	
	public JSONObject getData() {
		return data;
	}
	public void setData(JSONObject data) {
		this.data = data;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
