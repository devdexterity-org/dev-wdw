package com.testV1.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testV1.dao.UserListDao;
import com.testV1.entity.UserList;
import com.testV1.service.UserListService;

@Service
public class UserListServiceImpl implements UserListService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private UserListDao userListDao;
	
	/**
     * 查询用户列表
     */
    public List<UserList> QueryUser(String searchStr,int startIndex,int limitCount) {
        return userListDao.QueryUser(searchStr,startIndex,limitCount);
    }
}
