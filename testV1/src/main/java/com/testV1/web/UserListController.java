package com.testV1.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.testV1.entity.User;
import com.testV1.entity.UserList;
import com.testV1.service.UserListService;

@Controller
@RequestMapping("/userList")// url:/模块/资源/{id}/细分 /seckill/list
public class UserListController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private UserListService userListService;
    
    /**
	 * 用户管理页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/UserList", method = RequestMethod.GET)
    private String list(HttpServletRequest request,Model model) {
		logger.debug("test");
        List<UserList> list = userListService.QueryUser("", 0, 10);
        model.addAttribute("list", list);
        return "UserList";// WEB-INF/jsp/UserManage.jsp
    }
}
