package com.moohan.business.demo.controller;

import com.moohan.business.protocol.input.StudentInput;
import com.moohan.common.core.result.R;
import com.moohan.common.core.utils.RUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class DemoController {

    @Value("${com.name}")
    private String name;

    @PostMapping("/insertStudent")
    public R insertStudent(@Valid StudentInput input) {
        log.info("[Insert-stu] - 学生信息：{}", input);
        return RUtils.createSucc(input);
    }

    @GetMapping("/test")
    public R<String> test() {
        log.info("[My-Test] - test Restful API 接收数据");
        String user = null;
        Assert.notNull(user, "user用户信息不能null");
        return RUtils.createSucc("msg");
    }
}
