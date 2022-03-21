package com.study.frame.aopTest;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liaowenhui
 * @date 2022/3/20 21:22
 */
@RestController
@Slf4j
@RequestMapping("/study")
public class TestAopController {

    @Annotation1
    //@Annotation2
    @GetMapping("/testAop")
    public Boolean testAop(@RequestParam("user_id") Long userId) throws Exception {
        log.info("开始执行testAop()");
        //throw new Exception("异常");
        return true;
    }

}
