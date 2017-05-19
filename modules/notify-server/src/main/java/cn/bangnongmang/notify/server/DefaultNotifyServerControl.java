package cn.bangnongmang.notify.server;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import cn.bangnongmang.notify.server.data.domain.NotifySendPattern;
import cn.bangnongmang.notify.server.data.domain.NotifySendPatternKey;
import cn.bangnongmang.notify.server.data.domain.NotifyType;
import cn.bangnongmang.notify.server.data.mapper.NotifySendPatternMapper;
import cn.bangnongmang.notify.server.data.mapper.NotifyTypeMapper;

public class DefaultNotifyServerControl implements NotifyServerControl {

	private SqlSessionFactory sqlSessionFactory;

	public DefaultNotifyServerControl(DataSource dataSource) {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("notify", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);

		configuration.addMappers("cn.bangnongmang.notify.server.data.mapper");
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
	}

	@Override
	public boolean createType(String name, String description, String patternConstraint) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			NotifyTypeMapper notifyTypeMapper = sqlSession.getMapper(NotifyTypeMapper.class);

			NotifyType notifyType = new NotifyType();
			notifyType.setDescription(description);
			notifyType.setPatternConstraint(patternConstraint);
			notifyType.setType_name(name);

			NotifyType notifyType2 = notifyTypeMapper.selectByPrimaryKey(name);
			if (notifyType2 == null) {
				notifyTypeMapper.insert(notifyType);
				sqlSession.commit();
				return true;
			} else {
				return false;
			}

		} finally {

			sqlSession.close();
		}
	}

	@Override
	public boolean deleteType(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			NotifyTypeMapper notifyTypeMapper = sqlSession.getMapper(NotifyTypeMapper.class);

			notifyTypeMapper.deleteByPrimaryKey(name);
			sqlSession.commit();
			return true;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public boolean addHookTypeModel(String hookName, String typeName, String model) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		NotifySendPatternKey notifySendPatternKey = new NotifySendPatternKey();
		notifySendPatternKey.setHook_name(hookName);
		notifySendPatternKey.setType_name(typeName);
		try {
			NotifySendPatternMapper notifySendPatternMapper = sqlSession.getMapper(NotifySendPatternMapper.class);

			NotifySendPattern notifySendPattern = new NotifySendPattern();
			notifySendPattern.setHook_name(hookName);
			notifySendPattern.setPattern(model);
			notifySendPattern.setType_name(typeName);

			NotifySendPattern pattern = notifySendPatternMapper.selectByPrimaryKey(notifySendPatternKey);

			if (pattern == null) {
				notifySendPatternMapper.insert(notifySendPattern);
				sqlSession.commit();
				return true;
			} else {

				return false;
			}

		} finally {
			sqlSession.close();
		}
	}

	@Override
	public boolean modifyHookTypeModel(String hookName, String typeName, String model) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		NotifySendPatternKey notifySendPatternKey = new NotifySendPatternKey();
		notifySendPatternKey.setHook_name(hookName);
		notifySendPatternKey.setType_name(typeName);
		try {
			NotifySendPatternMapper notifySendPatternMapper = sqlSession.getMapper(NotifySendPatternMapper.class);

			NotifySendPattern pattern = notifySendPatternMapper.selectByPrimaryKey(notifySendPatternKey);

			if (pattern == null) {
				return false;
			} else {

				pattern.setPattern(model);
				notifySendPatternMapper.updateByPrimaryKey(pattern);
				sqlSession.commit();
				return true;
			}

		} finally {
			sqlSession.close();
		}
	}

	@Override
	public boolean deleteHookTypeModel(String hookName, String typeName) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		NotifySendPatternKey notifySendPatternKey = new NotifySendPatternKey();
		notifySendPatternKey.setHook_name(hookName);
		notifySendPatternKey.setType_name(typeName);
		try {
			NotifySendPatternMapper notifySendPatternMapper = sqlSession.getMapper(NotifySendPatternMapper.class);

			notifySendPatternMapper.deleteByPrimaryKey(notifySendPatternKey);
			sqlSession.commit();
			return true;
		} finally {
			sqlSession.close();
		}
	}

}
