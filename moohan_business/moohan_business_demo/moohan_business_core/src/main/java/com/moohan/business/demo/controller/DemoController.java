package com.moohan.business.demo.controller;

import com.moohan.business.demo.service.StudentService;
import com.moohan.business.protocol.input.StudentInput;
import com.moohan.common.core.result.R;
import com.moohan.common.core.utils.RUtils;
import com.moohan.data.entity.demo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class DemoController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/insertStudent")
	public R insertStudent(@Valid StudentInput input) {
		log.info("[Insert-stu] - 学生信息：{}", input);
		Student student = new Student();
		BeanUtils.copyProperties(input, student);
		boolean ret = studentService.save(student);
		log.info("[Insert-stu] - 保存学生信息结果：{}", ret);
		if (!ret) {
			return RUtils.createFail(100, "保存失败");
		}
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
