package com.jcloud.cms.dao;

import com.jcloud.cms.domain.User;

/**
 * Created by BurNing on 17/10/3.
 */
public interface UserMapper {

    User insert(User user);

    void update(User user);

    void delete(String userName);

    User findByName(String userName);
}
