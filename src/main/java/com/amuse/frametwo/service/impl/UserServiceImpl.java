package com.amuse.frametwo.service.impl;

import com.amuse.frametwo.common.model.primary.User;
import com.amuse.frametwo.dao.primary.UserDao;
import com.amuse.frametwo.dao.primary.UserRepository;
import com.amuse.frametwo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/6/6 14:10
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    /**
     * 获取user
     * @param id
     * @return
     */
    public User getUser(String id){
        return userRepository.findOne(id);
    }

    public User findUser(String id){
        return userDao.findUser(id);
    }
}
