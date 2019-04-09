package com.fh.shop.api.student.controller;

import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.student.biz.StudentService;
import com.fh.shop.api.student.po.Student;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author DELL
 * @title: StudentController
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/2114:22
 */
@RestController
@RequestMapping("/api")
public class StudentController {


    @Resource(name = "studentService")
    private StudentService studentService;

    /**
     * restful 增加接口
     * @param student
     * @return
     */
    @RequestMapping(value = "/students",method = RequestMethod.POST)
    public ServerResponse addStudent(Student student){
        return studentService.addStudent(student);
    }

    /**
     * restful 单个删除接口
     *      当前台传过来的id与后台id不匹配
     *      @RequestMapping(value = "/students/{id}",method = RequestMethod.DELETE)
     *      public ServerResponse deleteStudent(@PathVariable("id") Integer stuId){
     *         return studentService.deleteStudent(stuId);
     *     }
     * @param id
     * @return
     */
    @RequestMapping(value = "/students/{id}",method = RequestMethod.DELETE)
    public ServerResponse deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }

    /**
     * restful 查询接口根据id
     * @param id
     * @return
     */
    @RequestMapping(value = "/students/{id}",method = RequestMethod.GET)
    public ServerResponse findStudent(@PathVariable Integer id){
        return studentService.findStudent(id);
    }

    /**
     * restful 修改接口
     * @param student
     * @return
     */
    @RequestMapping(value = "/students",method = RequestMethod.PUT)
    public ServerResponse updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

}
