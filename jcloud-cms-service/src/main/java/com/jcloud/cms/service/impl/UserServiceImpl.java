package com.jcloud.cms.service.impl;

import com.jcloud.cms.dao.UserMapper;
import com.jcloud.cms.domain.User;
import com.jcloud.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by BurNing on 17/10/3.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByName(String name) {
        return null;//userMapper.findByName(name);
    }

    @Override
    public void addUser(User user) {

        //userMapper.insert(user);
    }
}
