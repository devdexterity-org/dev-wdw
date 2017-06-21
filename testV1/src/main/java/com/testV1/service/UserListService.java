package com.testV1.service;

import java.util.List;

import com.testV1.entity.UserList;

public interface UserListService {
	/**
	 * 查询用户
	 * @param searchStr
	 * @param startIndex
	 * @param limitCount
	 * @return
	 */
	List<UserList> QueryUser(String searchStr,int startIndex,int limitCount);
}
