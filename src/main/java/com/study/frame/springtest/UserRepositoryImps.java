package com.study.frame.springtest;

import org.springframework.stereotype.Repository;

/**
 * @author liaowenhui
 * @date 2022/3/20 11:50
 */
@Repository("userRepository")
public class UserRepositoryImps implements UserRepository {
    @Override
    public void save() {
        System.out.println("UserRepositoryImps save");

    }
}
