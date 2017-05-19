package cn.bangnongmang.notify.server.channel;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.alibaba.fastjson.JSON;

import cn.bangnongmang.notify.bo.NotifyCommand;
import cn.bangnongmang.notify.bo.NotifyRegisterCommand;
import cn.bangnongmang.notify.server.NotifyServer;
import cn.bangnongmang.notify.server.data.domain.NotifyHook;
import cn.bangnongmang.notify.server.data.mapper.NotifyHookMapper;

public class ControlChannel extends NotifyBaseChannel {

	public ControlChannel(DataSource dataSource, ConnectionFactory connectionFactory, String queuePrefix,
			NotifyServer notifyServer) {
		super(dataSource, connectionFactory, queuePrefix, notifyServer);
	}

	@Override
	public void doMessage(Message message) {
		if (message == null) {
			return;
		}

		try {
			String text = ((TextMessage) message).getText();

			NotifyCommand notifyCommand = JSON.parseObject(text, NotifyCommand.class);

			if (NotifyCommand.REGISTER_HOOK.equals(notifyCommand.getCommand())) {
				NotifyRegisterCommand notifyRegisterCommand = JSON.parseObject(text, NotifyRegisterCommand.class);
				registerHook(notifyRegisterCommand.getNotifyHook());

			} else if (NotifyCommand.UNREGISTER_HOOK.equals(notifyCommand.getCommand())) {
				NotifyRegisterCommand notifyRegisterCommand = JSON.parseObject(text, NotifyRegisterCommand.class);
				deleteHook(notifyRegisterCommand.getNotifyHook().getHook_name());
			}

		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void registerHook(NotifyHook notifyHook) {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			NotifyHookMapper notifyHookMapper = sqlSession.getMapper(NotifyHookMapper.class);

			notifyHookMapper.deleteByPrimaryKey(notifyHook.getHook_name());

			notifyHookMapper.insert(notifyHook);

			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	private void deleteHook(String hookName) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			NotifyHookMapper notifyHookMapper = sqlSession.getMapper(NotifyHookMapper.class);
			notifyHookMapper.deleteByPrimaryKey(hookName);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public String getQueueName() {
		// TODO Auto-generated method stub
		return QUEUE_NAME_COMMAND;
	}

}
