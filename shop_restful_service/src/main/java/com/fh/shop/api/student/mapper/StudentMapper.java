package com.fh.shop.api.student.mapper;

import com.fh.shop.api.student.po.Student;

/**
 * @author DELL
 * @title: StudentMapper
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/2116:30
 */

public interface StudentMapper {
    void addStudent(Student student);

    void deleteStudent(Integer id);

    Student findStudent(Integer id);

    void updateStudent(Student student);
}
