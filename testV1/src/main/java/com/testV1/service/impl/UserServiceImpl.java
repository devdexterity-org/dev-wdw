package com.testV1.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testV1.dao.UserDao;
import com.testV1.entity.User;
import com.testV1.pojo.Result;
import com.testV1.pojo.SaveUserPojo;
import com.testV1.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 注入Service依赖
    @Autowired
    private UserDao userDao;
    
    /**
     * 查询用户列表
     */
    @Override
    public List<User> QueryUser(String searchStr,int startIndex,int limitCount) {
        return userDao.QueryUser(searchStr,startIndex,limitCount);
    }
    
    /**
     * 查询单个用户
     */
    @Override
    public User QueryUserById(String openUid){
    	return userDao.selectByPrimaryKey(openUid);
    }
     
     /**
	 * 删除用户
	 * @param openUid
	 * @return
	 */
    public Result<Integer> deleteUser(String openUid){
    	int count =  userDao.deleteByPrimaryKey(openUid);
    	if(count>0){
    		return new Result<Integer>(true, count);
    	}
    	else{
    		return new Result<Integer>(false, "操作失败");
    	}
    	
    }
    
    /**
	 * 保存用户
	 * @param userInfo
	 * @return
	 */
	public Result<Integer> saveUser(SaveUserPojo userInfo){
		int count;
		// 新增
		if(userInfo.getOpenUid()==0){
			count = userDao.insert(userInfo);
		}
		// 修改
		else{
			count = userDao.updateByPrimaryKey(userInfo);
		}
		logger.debug("count:"+Integer.toString(count));
		if(count>0){
    		return new Result<Integer>(true, count);
    	}
    	else{
    		return new Result<Integer>(false, "操作失败");
    	}
	}
}
