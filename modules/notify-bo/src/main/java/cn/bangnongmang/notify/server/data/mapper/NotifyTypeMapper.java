package cn.bangnongmang.notify.server.data.mapper;

import cn.bangnongmang.notify.server.data.domain.NotifyType;
import cn.bangnongmang.notify.server.data.domain.NotifyTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotifyTypeMapper {
    int countByExample(NotifyTypeCriteria example);

    int deleteByExample(NotifyTypeCriteria example);

    int deleteByPrimaryKey(String type_name);

    int insert(NotifyType record);

    int insertSelective(NotifyType record);

    List<NotifyType> selectByExample(NotifyTypeCriteria example);

    NotifyType selectByPrimaryKey(String type_name);

    int updateByExampleSelective(@Param("record") NotifyType record, @Param("example") NotifyTypeCriteria example);

    int updateByExample(@Param("record") NotifyType record, @Param("example") NotifyTypeCriteria example);

    int updateByPrimaryKeySelective(NotifyType record);

    int updateByPrimaryKey(NotifyType record);
}