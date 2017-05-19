package cn.bangnongmang.notify.server.outerservice;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.bangnongmang.notify.server.service.util.HttpClientUtil;

public class WechatMessageSender {

	private String preSharedKey;

	private String getSaltStringUrl;
	private String getAccessTokenUrl;

	private HttpClientUtil httpClientUtil;


	public WechatMessageSender(String preSharedKey, String getSaltStringUrl, String getAccessTokenUrl) {

		this.preSharedKey = preSharedKey;
		this.getSaltStringUrl = getSaltStringUrl;
		this.getAccessTokenUrl = getAccessTokenUrl;

		httpClientUtil = new HttpClientUtil();

	}

	private String getHostToken(String salt, String time) {
		String mdString = DigestUtils.md5Hex(DigestUtils.md5Hex(preSharedKey + time) + salt);

		return mdString;
	}

	private String getRemoteThings(String burl, String keyWord) {

		String salt = httpClientUtil.post(getSaltStringUrl);

		JSONObject sJsonObject = JSON.parseObject(salt);

		if (sJsonObject.getLong("message") == null) {

			return null;
		}

		String saltString = String.valueOf(sJsonObject.getLong("message"));

		String url = burl + "?token=" + getHostToken(saltString, saltString) + "&time=" + saltString;

		String accessTokenReponse = httpClientUtil.post(url);

		JSONObject aJsonObject = JSONObject.parseObject(accessTokenReponse);

		return aJsonObject.getString(keyWord);
	}

	private String getAccessToken() {
		return getRemoteThings(getAccessTokenUrl, "access_token");
	}

	public boolean sendModalMessage(String openid, String templateId, String userurl, JSONObject data) {

		String accessToken = getAccessToken();

		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + accessToken;

		JSONObject tmp = new JSONObject();
		tmp.put("touser", openid);
		tmp.put("template_id", templateId);
		tmp.put("url", userurl);
		tmp.put("data", data);

		String result = httpClientUtil.postJson(url, tmp.toJSONString());

		JSONObject re = JSON.parseObject(result);

		if (re.getInteger("errcode") == 0) {
			return true;
		}

		return false;
	}

	public boolean sendModalMessage(String openid, WechatModalMessage wechatModalMessage) {

		return sendModalMessage(openid, wechatModalMessage.getTemplateId(), wechatModalMessage.getUrl(),
				wechatModalMessage.getData());
	}



}
