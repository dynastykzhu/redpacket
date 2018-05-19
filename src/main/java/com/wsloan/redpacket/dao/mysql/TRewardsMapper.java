package com.wsloan.redpacket.dao.mysql;

import com.wsloan.redpacket.entity.TRewards;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TRewardsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TRewards record);

    int insertSelective(TRewards record);

    TRewards selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRewards record);

    int updateByPrimaryKey(TRewards record);

    List<Map> selectByOpenIdAccept(String openIdAccept);

    int selectByOpenIdAcceptAndopenIdSend(
            @Param("openIdAccept") String openIdAccept,
            @Param("openIdSend") String openIdSend
    );

    int selectNumByOpenIdAcceptOneDay(@Param("openIdAccept") String openIdAccept);
}