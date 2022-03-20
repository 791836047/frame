package com.study.frame.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liaowenhui
 * @date 2022/3/20 11:53
 */
@Service
public class UserService {
    @Autowired
    //@Qualifier("userJdbcImps")
    private UserRepository userRepository;

    public void save(){
        userRepository.save();
    }
}
