package com.amuse.frametwo.dao.primary;

import com.amuse.frametwo.common.model.primary.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/6/8 11:13
 * @Version 1.0
 */
@Repository
public class UserDao {

    @Resource(name = "primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;



    public User findUser(String id){
        String sql = "select * from users where id = '"+id+"'";
        //第一种方式
        List<User> userList = jdbcTemplate.query(sql,new Object[]{},new BeanPropertyRowMapper<User>(User.class));
        return userList.get(0);
        //第二种方式
//        Query query = entityManager.createNativeQuery(sql,User.class);
//        User user = (User) query.getSingleResult();
//        return user;
    }
}
