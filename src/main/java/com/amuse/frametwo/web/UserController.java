package com.amuse.frametwo.web;

import com.amuse.frametwo.common.model.User;
import com.amuse.frametwo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/6/6 14:08
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 获取user
     * @param id
     * @return
     */
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @Transactional
    public User getUser(@RequestParam String id){
        User user = userService.getUser(id);
        user.setEmail("持久态的对象会自动更新到数据库中@163.com");
        return user;
    }




}
