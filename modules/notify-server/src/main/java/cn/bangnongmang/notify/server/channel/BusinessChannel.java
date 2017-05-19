package cn.bangnongmang.notify.server.channel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import com.alibaba.fastjson.JSON;

import cn.bangnongmang.notify.bo.NotifyBusinessMessage;
import cn.bangnongmang.notify.server.NotifyServer;
import cn.bangnongmang.notify.server.data.domain.NotifySendPattern;
import cn.bangnongmang.notify.server.data.domain.NotifySendPatternCriteria;
import cn.bangnongmang.notify.server.data.domain.NotifyType;
import cn.bangnongmang.notify.server.data.mapper.NotifySendPatternMapper;
import cn.bangnongmang.notify.server.data.mapper.NotifyTypeMapper;
import cn.bangnongmang.notify.server.service.NotifySender;

public class BusinessChannel extends NotifyBaseChannel implements NotifyBusinessBrocaster {

	public static final String NOTIFY_PATTERN_STATE_AVAILABLE = "AVAILABLE";

	private boolean livemode = false;

	public BusinessChannel(DataSource dataSource, ConnectionFactory connectionFactory, String queuePrefix,
			NotifyServer notifyServer) {
		super(dataSource, connectionFactory, queuePrefix, notifyServer);
	}

	private Map<String, NotifySender> senders = new HashMap<>();

	@Override
	public void doMessage(Message message) {

		TextMessage textMessage = (TextMessage) message;
		if (textMessage == null) {
			return;
		}

		try {
			NotifyBusinessMessage notifyBusinessMessage = JSON.parseObject(textMessage.getText(),
					NotifyBusinessMessage.class);

			if (notifyBusinessMessage == null) {
				return;
			}
			if (!isLivemode()) {
				return;
			}

			List<NotifySendPattern> sendPatterns = getNotifySendPatterByTypeNameAndState(
					notifyBusinessMessage.getHookName(), NOTIFY_PATTERN_STATE_AVAILABLE);
			if (sendPatterns == null) {
				return;
			}

			for (NotifySendPattern notifySendPattern : sendPatterns) {
				if (this.senders.containsKey(notifySendPattern.getType_name())) {
					NotifyType notifyType = getNotifyTypeByName(notifySendPattern.getType_name());
					if (notifyType == null) {
						continue;
					}

					this.senders.get(notifySendPattern.getType_name()).send(notifyBusinessMessage,
							notifySendPattern.getPattern(), notifyType.getPatternConstraint());
				}
			}
		} catch (JMSException e) {

			e.printStackTrace();
		}
	}

	@Override
	public String getQueueName() {

		return QUEUE_NAME_BUSINESS;
	}

	private NotifyType getNotifyTypeByName(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			NotifyTypeMapper notifyTypeMapper = sqlSession.getMapper(NotifyTypeMapper.class);
			return notifyTypeMapper.selectByPrimaryKey(name);
		} finally {
			sqlSession.close();
		}
	}

	private List<NotifySendPattern> getNotifySendPatterByTypeNameAndState(String name, String state) {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			NotifySendPatternMapper notifySendPatternMapper = sqlSession.getMapper(NotifySendPatternMapper.class);

			NotifySendPatternCriteria notifySendPatternCriteria = new NotifySendPatternCriteria();
			notifySendPatternCriteria.or().andHook_nameEqualTo(name).andStateEqualTo(state);

			return notifySendPatternMapper.selectByExample(notifySendPatternCriteria);
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public void registerNotifySender(String senderName, NotifySender notifyBaseSender) {

		this.senders.put(senderName, notifyBaseSender);
	}

	public boolean isLivemode() {
		return livemode;
	}

	public void setLivemode(boolean livemode) {
		this.livemode = livemode;
	}
}
