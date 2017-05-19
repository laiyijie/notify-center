package cn.bangnongmang.notify.server;

import java.util.HashMap;
import java.util.Map;

import org.apache.activemq.broker.BrokerBroadcaster;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.bangnongmang.notify.bo.NotifyBusinessMessage;
import cn.bangnongmang.notify.bo.pattern.NotifyTextMessagePattern;
import cn.bangnongmang.notify.bo.pattern.NotifyAppPushPattern;
import cn.bangnongmang.notify.bo.pattern.NotifyWechatPattern;
import cn.bangnongmang.notify.server.channel.NotifyBusinessBrocaster;
import cn.bangnongmang.notify.server.data.domain.NotifySendPattern;
import cn.bangnongmang.notify.server.service.impl.MipushMessageSender;
import cn.bangnongmang.notify.server.service.impl.TextMessageSender;
import cn.bangnongmang.notify.server.service.util.NotifyPatternUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/test/java/test-context.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotifyServerTest {
	
	@Autowired
	private NotifyServer notifyServer;
	@Autowired
	private NotifyBusinessBrocaster b;
	
	@Test
	public void tt() throws InterruptedException{
//		notifyServer.start();
//		Thread.currentThread().sleep(10000);


	}
	
	@Test
	public void patterntt(){
		String string = "啊啊${name}就是这么吊，怎么来啊m${xx}ss";
		Map<String, Object> map = new HashMap<>();
		map.put("name", 111);
		map.put("xx", "qunimade");
		System.out.println(NotifyPatternUtil.parsePatternToValue(string, map));
	}
	
	
	@Test
	public void test_text_message_send() throws InterruptedException{
//		NotifyTextMessagePattern notifyTextMessagePattern=new NotifyTextMessagePattern();
//		notifyTextMessagePattern.setData("${name} 短信2");
//		TextMessageSender textMessageSender=new TextMessageSender( b,"J25613", "852852");
//		NotifyBusinessMessage notifyBusinessMessage=new NotifyBusinessMessage();
//		notifyBusinessMessage.setPhoneNumber("18321783963");
//		Map<String, Object> params=new HashMap<>();
//		params.put("name", "测试");
//		notifyBusinessMessage.setParams(params);
//		textMessageSender.send(notifyBusinessMessage, JSON.toJSONString(notifyTextMessagePattern), "");
//		Thread.sleep(10000);
	}
	
	@Test
	public void test_mi_push_send() throws InterruptedException{
		NotifyAppPushPattern notifyAppPushPattern=new NotifyAppPushPattern();
		notifyAppPushPattern.setTitle("测试title1");
		notifyAppPushPattern.setDescription("测试description ${name}");
		notifyAppPushPattern.setPassThrough(0);
		notifyAppPushPattern.setNotifyType(1);
		MipushMessageSender mipushMessageSender=new MipushMessageSender( b,"i9Va38nSX0DMP7fPahw+Sg==", "cn.bangnongmang.driverapp");
		NotifyBusinessMessage notifyBusinessMessage=new NotifyBusinessMessage();
		notifyBusinessMessage.setPhoneNumber("18321783963");
		Map<String, Object> params=new HashMap<>();
		params.put("name", "黄鑫河");
		notifyBusinessMessage.setParams(params);
		mipushMessageSender.send(notifyBusinessMessage, JSON.toJSONString(notifyAppPushPattern), "");
		Thread.sleep(10000);
	}
}
