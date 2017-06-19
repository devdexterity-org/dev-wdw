package com.testV1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.testV1.entity.User;
import com.testV1.pojo.SaveUserPojo;

public interface UserDao {
	/**
	 * 获取用户列表
	 * @param searchStr
	 * @return
	 */
	List<User> QueryUser(@Param("searchStr")String searchStr, @Param("startIndex")int startIndex, @Param("limitCount")int limitCount);

	/**
	 * 更新用户信息
	 * @param userName
	 * @param userTel
	 * @return
	 */
	int UpdateUser(@Param("userName")String userName, @Param("userTel")String userTel,@Param("openUid")String openUid);
 
	/**
	 * 删除用户
	 * @param openUid
	 * @return
	 */
	int deleteByPrimaryKey(String openUid);
	
	/**
	 * 添加用户
	 * @param record
	 * @return
	 */
    int insert(SaveUserPojo record);

    int insertSelective(User record);

    /**
	 * 根据id获取用户信息
	 * @param openUid
	 * @return
	 */
    User selectByPrimaryKey(String openUid);

    int updateByPrimaryKeySelective(User record);
    
    /**
     * 编辑用户
     * @param record
     * @return
     */
    int updateByPrimaryKey(SaveUserPojo record);
}
