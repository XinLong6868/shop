package com.fh.shop.api.student.biz;

import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.student.mapper.StudentMapper;
import com.fh.shop.api.student.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DELL
 * @title: StudentServiceImpl
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/2114:36
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService{

    /**
     *
     */
    @Autowired
    private StudentMapper studentMapper;


    public ServerResponse addStudent(Student student) {
        studentMapper.addStudent(student);
        return ServerResponse.success();
    }

    public ServerResponse deleteStudent(Integer id) {
        studentMapper.deleteStudent(id);
        return ServerResponse.success();
    }

    public ServerResponse findStudent(Integer id) {
        Student s = studentMapper.findStudent(id);
        return ServerResponse.success(s);
    }

    public ServerResponse updateStudent(Student student) {
        studentMapper.updateStudent(student);
        return ServerResponse.success();
    }
}
