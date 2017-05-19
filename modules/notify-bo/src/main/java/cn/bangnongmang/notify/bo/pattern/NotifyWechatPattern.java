package cn.bangnongmang.notify.bo.pattern;

import java.util.List;
import java.util.Map;

public class NotifyWechatPattern {

	private String templateId;
	private String url;
	private List<NotifyWechatPatternDataItem> data;

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

	public List<NotifyWechatPatternDataItem> getData() {
		return data;
	}

	public void setData(List<NotifyWechatPatternDataItem> data) {
		this.data = data;
	}

}
