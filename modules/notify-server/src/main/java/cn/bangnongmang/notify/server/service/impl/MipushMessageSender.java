package cn.bangnongmang.notify.server.service.impl;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.simple.parser.ParseException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.xiaomi.xmpush.server.Constants;
import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.Result;
import com.xiaomi.xmpush.server.Sender;

import cn.bangnongmang.notify.bo.NotifyBusinessMessage;
import cn.bangnongmang.notify.bo.pattern.NotifyAppPushPattern;
import cn.bangnongmang.notify.bo.pattern.NotifyTextMessagePattern;
import cn.bangnongmang.notify.server.channel.NotifyBusinessBrocaster;
import cn.bangnongmang.notify.server.service.NotifySender;
import cn.bangnongmang.notify.server.service.util.HttpClientUtil;
import cn.bangnongmang.notify.server.service.util.NotifyPatternUtil;

public class MipushMessageSender implements NotifySender {
	public static final String SENDER_NAME = "app";
	private String appSecretKey, appPackageName;
	private HttpClientUtil httpClientUtil;
	private ExecutorService executorService;
	private Integer fixedThredPoolSize = 10;
	private Sender sender;

	public MipushMessageSender(NotifyBusinessBrocaster brocaster, String appSecretKey, String appPackageName) {
		brocaster.registerNotifySender(SENDER_NAME, this);
		executorService = Executors.newFixedThreadPool(fixedThredPoolSize);
		this.appSecretKey = appSecretKey;
		this.appPackageName = appPackageName;
		this.httpClientUtil = new HttpClientUtil();
		Constants.useOfficial();
		this.sender = new Sender(appSecretKey);
	}

	@Override
	public void send(NotifyBusinessMessage notifyBusinessMessage, String pattern, String constraint) {
		if (notifyBusinessMessage == null) {
			return;
		}
		if (pattern == null || "".equals(pattern)) {
			return;
		}
		try {
			Map<String, Object> params = notifyBusinessMessage.getParams();
			NotifyAppPushPattern notifyAppPushPattern = JSON.parseObject( NotifyPatternUtil.parsePatternToValue(pattern,params), NotifyAppPushPattern
					.class);
			String title = notifyAppPushPattern.getTitle();
			String description = notifyAppPushPattern.getDescription();
			Message message = new Message.Builder().title(title).description(description)
					.payload(JSON.toJSONString(notifyAppPushPattern.getPayload())).restrictedPackageName(appPackageName)
					.passThrough(notifyAppPushPattern.getPassThrough()) // 消息使用透传方式
					.notifyType(notifyAppPushPattern.getNotifyType()) // 使用默认提示音提示
					.notifyId(Integer.valueOf((int)((System.currentTimeMillis()/1000)%1000000*1000+new Random().nextInt(1000))))
					.build();

			executorService.execute(new Runnable() {
				@Override
				public void run() {

					try {
						Result result;
						result = sender.sendToAlias(message, notifyBusinessMessage.getPhoneNumber(), 3);
						System.out.println("Server response: " + "MessageId: " + result.getMessageId() + " ErrorCode: "
								+ result.getErrorCode().toString() + " Reason: " + result.getReason());
					} catch (IOException | ParseException e) {
						e.printStackTrace();
					}

				}
			});

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
