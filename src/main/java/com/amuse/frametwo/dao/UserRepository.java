package com.amuse.frametwo.dao;

import com.amuse.frametwo.common.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/6/6 14:05
 * @Version 1.0
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User,String> {


}
