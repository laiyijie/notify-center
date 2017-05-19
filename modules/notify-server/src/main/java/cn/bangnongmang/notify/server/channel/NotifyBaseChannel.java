package cn.bangnongmang.notify.server.channel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.jms.core.JmsTemplate;

import cn.bangnongmang.notify.bo.name.NotifyQueueName;
import cn.bangnongmang.notify.server.NotifyServer;

public abstract class NotifyBaseChannel implements Runnable, NotifyQueueName {

	protected SqlSessionFactory sqlSessionFactory;
	// protected JmsTemplate jmsTemplate;
	protected String queuePrefix;
	private volatile boolean isStop = false;
	private ExecutorService executorService;

	final static Long DEFAULT_TIME_OUT = 1000L;
	private MessageConsumer messageConsumer;

	public NotifyBaseChannel(DataSource dataSource, ConnectionFactory connectionFactory, String queuePrefix,
			NotifyServer notifyServer) {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("notify", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);

		configuration.addMappers("cn.bangnongmang.notify.server.data.mapper");

		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

		this.queuePrefix = queuePrefix;
		this.executorService = Executors.newFixedThreadPool(10);

		notifyServer.registerChannel(this);

		try {
			Connection conn = connectionFactory.createConnection();
			conn.start();

			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = session.createQueue(queuePrefix + getQueueName());

			messageConsumer = session.createConsumer(destination);

		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public abstract void doMessage(Message message);

	public abstract String getQueueName();

	public void stop() {
		this.isStop = true;
	}

	@Override
	public void run() {

		try {
			messageConsumer.setMessageListener(new MessageListener() {

				@Override
				public void onMessage(Message message) {
					if (message == null) {
						return;
					}

					executorService.execute(new Runnable() {
						@Override
						public void run() {
							doMessage(message);
						}
					});

				}
			});
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
}
