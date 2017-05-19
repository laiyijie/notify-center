package cn.bangnongmang.notify.server.data.mapper;

import cn.bangnongmang.notify.server.data.domain.NotifySendPattern;
import cn.bangnongmang.notify.server.data.domain.NotifySendPatternCriteria;
import cn.bangnongmang.notify.server.data.domain.NotifySendPatternKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotifySendPatternMapper {
    int countByExample(NotifySendPatternCriteria example);

    int deleteByExample(NotifySendPatternCriteria example);

    int deleteByPrimaryKey(NotifySendPatternKey key);

    int insert(NotifySendPattern record);

    int insertSelective(NotifySendPattern record);

    List<NotifySendPattern> selectByExample(NotifySendPatternCriteria example);

    NotifySendPattern selectByPrimaryKey(NotifySendPatternKey key);

    int updateByExampleSelective(@Param("record") NotifySendPattern record, @Param("example") NotifySendPatternCriteria example);

    int updateByExample(@Param("record") NotifySendPattern record, @Param("example") NotifySendPatternCriteria example);

    int updateByPrimaryKeySelective(NotifySendPattern record);

    int updateByPrimaryKey(NotifySendPattern record);
}