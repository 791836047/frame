package com.study.frame.springtest;

import org.springframework.stereotype.Repository;

/**
 * @author liaowenhui
 * @date 2022/3/20 17:07
 */
@Repository
public class UserJdbcImps implements UserRepository  {
    @Override
    public void save() {
        System.out.println("UserJdbcImps save");
    }
}
