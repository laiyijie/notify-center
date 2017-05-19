package cn.bangnongmang.notify.server.service.impl;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import cn.bangnongmang.notify.bo.NotifyBusinessMessage;
import cn.bangnongmang.notify.bo.pattern.NotifyWechatPattern;
import cn.bangnongmang.notify.bo.pattern.NotifyWechatPatternDataItem;
import cn.bangnongmang.notify.server.channel.NotifyBusinessBrocaster;
import cn.bangnongmang.notify.server.outerservice.WechatMessageSender;
import cn.bangnongmang.notify.server.outerservice.WechatModalMessage;
import cn.bangnongmang.notify.server.service.NotifySender;
import cn.bangnongmang.notify.server.service.util.NotifyPatternUtil;

public class NotifyWechatSender extends WechatMessageSender implements NotifySender {

	public static final String SENDER_NAME = "wechat";

	private ExecutorService executorService;

	private Integer fixedThredPoolSize = 10;

	public NotifyWechatSender(String preSharedKey, String getSaltStringUrl, String getAccessTokenUrl,
			NotifyBusinessBrocaster brocaster) {
		super(preSharedKey, getSaltStringUrl, getAccessTokenUrl);

		brocaster.registerNotifySender(SENDER_NAME, this);
		executorService = Executors.newFixedThreadPool(getFixedThredPoolSize());
	}

	@Override
	public void send(NotifyBusinessMessage notifyBusinessMessage, String pattern, String constrait) {

		if (notifyBusinessMessage == null) {
			return;
		}

		if (pattern == null || "".equals(pattern)) {
			return;
		}
		try {
			NotifyWechatPattern notifyWechatPattern = JSON.parseObject(pattern, NotifyWechatPattern.class);

			Map<String, Object> params = notifyBusinessMessage.getParams();

			WechatModalMessage wechatModalMessage = new WechatModalMessage(notifyWechatPattern.getTemplateId(),
					notifyWechatPattern.getUrl());
			for (NotifyWechatPatternDataItem item : notifyWechatPattern.getData()) {
				String s = NotifyPatternUtil.parsePatternToValue(item.getValue(), params);
				if (item.getColor() == null) {
					wechatModalMessage.addData(item.getData(), s);
				} else {
					wechatModalMessage.addData(item.getData(), s, item.getColor());
				}
			}

			if (notifyBusinessMessage.getOpenid() == null) {
				return;
			}
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					sendModalMessage(notifyBusinessMessage.getOpenid(), wechatModalMessage);
				}
			});

		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	public Integer getFixedThredPoolSize() {
		return fixedThredPoolSize;
	}

	public void setFixedThredPoolSize(Integer fixedThredPoolSize) {
		this.fixedThredPoolSize = fixedThredPoolSize;
	}

}
