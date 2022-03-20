package com.study.frame.springtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liaowenhui
 * @date 2022/3/20 11:59
 */
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserService userService;

    /**
     * 测试@Autowired先按照类型，再按照名称
     * 这时在启动容器后，在容器中有两个UserRepository类型的实例，一个名称为userRepository，另一个为userJdbcImps。
     * 这里由于查询到有两个该类型的实例，那么采用名称匹配方式，在容器中查找名称为userRepository的实例，并自动装配给该参数。
     */
    @Test
    void test1() {
        userService.save();
    }
}