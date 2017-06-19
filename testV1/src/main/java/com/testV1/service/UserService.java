package com.testV1.service;

import java.util.List;

import com.testV1.entity.User;
import com.testV1.pojo.Result;
import com.testV1.pojo.SaveUserPojo;

public interface UserService {
	/**
	 * 查询用户
	 * @param searchStr
	 * @param startIndex
	 * @param limitCount
	 * @return
	 */
	List<User> QueryUser(String searchStr,int startIndex,int limitCount);
	
	/**
	 * 根据Id获取用户
	 * @param openUid
	 * @return
	 */
	User QueryUserById(String openUid);
	
	/**
	 * 删除用户
	 * @param openUid
	 * @return
	 */
	Result<Integer> deleteUser(String openUid);
	
	
	/**
	 * 保存用户
	 * @param userInfo
	 * @return
	 */
	Result<Integer> saveUser(SaveUserPojo userInfo);
}