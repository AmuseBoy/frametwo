package com.amuse.frametwo.service.impl;

import com.amuse.frametwo.dao.primary.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @ClassName MyUserDetailsService
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/6/8 20:33
 * @Version 1.0
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("查找用户:{}",username);
        com.amuse.frametwo.common.model.primary.User user = userRepository.findOne(username);
        if(null == user){
            logger.info("用户名不存在"+username);
            throw new UsernameNotFoundException("用户名不存在"+username);
        }
        return new User(username,user.getPassWord(), this.getAuthorities(user));
    }

    /**
     * 权限设置
     * @param user
     * @return
     */
    public Collection<? extends GrantedAuthority> getAuthorities(com.amuse.frametwo.common.model.primary.User user){
        if(user.getId().equals("admin")){
            return AuthorityUtils.createAuthorityList("ROLE_ADMIN");
        }
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }
}
