package cn.bangnongmang.notify.client;

import javax.jms.JMSException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bangnongmang.notify.bo.NotifyBusinessMessage;
import cn.bangnongmang.notify.server.data.domain.NotifyHook;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/test/java/test-context.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DefaultNotifyClientTest {

	@Autowired
	private DefaultNotifyClient defaultNotifyClient;

	@Test
	public void tt() throws JMSException {
		// defaultNotifyClient.sendMessage("123", null);
		// defaultNotifyClient.receiveMessage();
//		NotifyHook notifyHook = new NotifyHook();
//		notifyHook.setDescription("ttt");
//		notifyHook.setHook_name("111122");
//		notifyHook.setParameters("111");
//		defaultNotifyClient.registerHook(notifyHook);
	}

	@Test
	public void send() {
		NotifyBusinessMessage notifyBusinessMessage = new NotifyBusinessMessage();
		notifyBusinessMessage.setHookName("test");
		notifyBusinessMessage.setOpenid("oHLNYv83dLCfvQsh0QKLK6sLc6FE");
		notifyBusinessMessage.setPhoneNumber("18801902298");
		notifyBusinessMessage.setParams(null);
		for (int i = 0; i < 2; i++) {
			defaultNotifyClient.sendBusinessMessage(notifyBusinessMessage);
		}

	}

}
