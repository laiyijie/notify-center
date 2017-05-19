package cn.bangnongmang.notify.bo;

import java.util.Map;

public class NotifyBusinessMessage {

	private String hookName;
	private Map<String, Object> params;
	private String phoneNumber;
	private String openid;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getHookName() {
		return hookName;
	}

	public void setHookName(String hookName) {
		this.hookName = hookName;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
