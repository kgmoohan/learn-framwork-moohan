package com.moohan.business.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moohan.business.demo.service.StudentService;
import com.moohan.data.entity.demo.Student;
import com.moohan.data.mapper.demo.dao.StudentDao;
import org.springframework.stereotype.Service;

/**
 * 学生表(Student)表服务实现类
 *
 * @author makejava
 * @since 2022-01-19 14:40:03
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

}

