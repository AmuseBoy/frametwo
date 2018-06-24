package com.amuse.frametwo.service;

import com.amuse.frametwo.common.model.primary.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/6/6 14:08
 * @Version 1.0
 */

public interface UserService {

    User getUser(String id);

    User findUser(String id);
}
