package com.fh.shop.api.student.biz;


import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.student.po.Student;


/**
 * @author DELL
 * @title: StudentService
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/2114:32
 */
public interface StudentService {

    public ServerResponse addStudent(Student student);

    ServerResponse deleteStudent(Integer id);

    ServerResponse findStudent(Integer id);

    ServerResponse updateStudent(Student student);
}
