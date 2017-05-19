package cn.bangnongmang.notify.client;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.alibaba.fastjson.JSON;

import cn.bangnongmang.notify.bo.NotifyBusinessMessage;
import cn.bangnongmang.notify.bo.NotifyCommand;
import cn.bangnongmang.notify.bo.NotifyRegisterCommand;
import cn.bangnongmang.notify.bo.name.NotifyQueueName;
import cn.bangnongmang.notify.server.data.domain.NotifyHook;

@Configuration
public class DefaultNotifyClient implements NotifyClient, NotifyQueueName {

	private JmsTemplate jmsTemplate;

	private String queuePrefix;

	public DefaultNotifyClient(ConnectionFactory connectionFactory, String queuePrefix) {
		jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory);
		this.queuePrefix = queuePrefix;
	}

	
	@Override
	public void registerHook(NotifyHook notifyHook) {

		NotifyRegisterCommand notifyRegisterCommand = new NotifyRegisterCommand();
		notifyRegisterCommand.setCommand(NotifyCommand.REGISTER_HOOK);
		notifyRegisterCommand.setNotifyHook(notifyHook);

		sendCommand(notifyRegisterCommand);
	}

	@Override
	public void deleteHook(String notifyHookName) {

		NotifyHook notifyHook = new NotifyHook();
		notifyHook.setHook_name(notifyHookName);

		NotifyRegisterCommand notifyRegisterCommand = new NotifyRegisterCommand();
		notifyRegisterCommand.setCommand(NotifyCommand.UNREGISTER_HOOK);
		notifyRegisterCommand.setNotifyHook(notifyHook);

		sendCommand(notifyRegisterCommand);
	}

	@Override
	public void sendBusinessMessage(NotifyBusinessMessage notifyBusinessMessage) {

		sendBusiness(notifyBusinessMessage);
	}

	private void sendCommand(NotifyCommand command) {
		jmsTemplate.send(queuePrefix + QUEUE_NAME_COMMAND, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(JSON.toJSONString(command));
			}
		});
	}

	private void sendBusiness(NotifyBusinessMessage message) {

		jmsTemplate.send(queuePrefix + QUEUE_NAME_BUSINESS, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(JSON.toJSONString(message));
			}
		});
	}
}
