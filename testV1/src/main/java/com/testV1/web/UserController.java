package com.testV1.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.testV1.entity.User;
import com.testV1.pojo.Result;
import com.testV1.pojo.SaveUserPojo;
import com.testV1.service.UserService;

@Controller
@RequestMapping("/user")// url:/模块/资源/{id}/细分 /seckill/list
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private UserService userService;
	
	/**
	 * 用户管理页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/UserManage", method = RequestMethod.GET)
    private String list(HttpServletRequest request,Model model) {
		logger.debug("test");
        List<User> list = userService.QueryUser("", 0, 10);
        model.addAttribute("list", list);
        return "UserManage";// WEB-INF/jsp/UserManage.jsp
    }
	
	/**
	 * 删除用户
	 * @param openUid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/DeleteUser", method = RequestMethod.POST)
	private Result<Integer> deleteUser(@RequestBody String openUid){
		logger.debug("test delete user");
		logger.debug("openId:" + openUid);
		return userService.deleteUser(openUid);
	}
	
	/**
	 * 用户修改
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/UserEdit", method = RequestMethod.GET)
	private String detail(HttpServletRequest request,Model model){
		logger.debug("testdetail");
		String openUid = request.getParameter("openUid");
		logger.debug("openUid->" + openUid);
		model.addAttribute("type","edit");
		User user = userService.QueryUserById(openUid);
        logger.debug("nickName:" + user.getNickName());
        model.addAttribute("user", user);
        return "UserDetail";
	}
	
	/**
	 * 用户添加
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/UserAdd", method = RequestMethod.GET)
	private String add(HttpServletRequest request,Model model){
		model.addAttribute("type","add");
		model.addAttribute("user", new User());
		return "UserDetail";
	}
	
	/**
	 * 保存用户
	 * @param userInfo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/SaveUser", method = RequestMethod.POST)
	private Result<Integer> saveUser(@RequestBody SaveUserPojo userInfo){
		return userService.saveUser(userInfo);
	}
}
