package com.wsloan.redpacket.dao.mysql;

import com.wsloan.redpacket.entity.TUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserMapper {
    int deleteByPrimaryKey(String openId);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(String openId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    int updateByPrimaryKeySome(TUser record);
}