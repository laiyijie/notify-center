package cn.bangnongmang.notify.server.data.mapper;

import cn.bangnongmang.notify.server.data.domain.NotifyHook;
import cn.bangnongmang.notify.server.data.domain.NotifyHookCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotifyHookMapper {
    int countByExample(NotifyHookCriteria example);

    int deleteByExample(NotifyHookCriteria example);

    int deleteByPrimaryKey(String hook_name);

    int insert(NotifyHook record);

    int insertSelective(NotifyHook record);

    List<NotifyHook> selectByExample(NotifyHookCriteria example);

    NotifyHook selectByPrimaryKey(String hook_name);

    int updateByExampleSelective(@Param("record") NotifyHook record, @Param("example") NotifyHookCriteria example);

    int updateByExample(@Param("record") NotifyHook record, @Param("example") NotifyHookCriteria example);

    int updateByPrimaryKeySelective(NotifyHook record);

    int updateByPrimaryKey(NotifyHook record);
}