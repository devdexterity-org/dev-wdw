package com.testV1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.testV1.entity.User;

public interface UserListDao {
	/**
	 * 获取用户列表
	 * @param searchStr
	 * @return
	 */
	List<User> QueryUser(@Param("searchStr")String searchStr, @Param("startIndex")int startIndex, @Param("limitCount")int limitCount);

}
