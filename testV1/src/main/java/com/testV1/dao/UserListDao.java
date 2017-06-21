package com.testV1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.testV1.entity.User;
import com.testV1.entity.UserList;

public interface UserListDao {
	/**
	 * 获取用户列表
	 * @param searchStr
	 * @return
	 */
	List<UserList> QueryUser(@Param("searchStr")String searchStr, @Param("startIndex")int startIndex, @Param("limitCount")int limitCount);
	
    int deleteByPrimaryKey(Integer openUid);

    int insert(UserList record);

    int insertSelective(UserList record);

    UserList selectByPrimaryKey(Integer openUid);

    int updateByPrimaryKeySelective(UserList record);

    int updateByPrimaryKey(UserList record);
}