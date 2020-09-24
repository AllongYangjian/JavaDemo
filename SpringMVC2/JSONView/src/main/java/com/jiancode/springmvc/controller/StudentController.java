package com.jiancode.springmvc.controller;

import com.jiancode.springmvc.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description：TODO
 * author：yj
 * email：yj@allong.net
 * date：2019-06-26 11:31
 * version：1.0
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping(value = "{name}/{score}")
    @ResponseBody
    public List<Student> getStudent(@PathVariable("name") String name, @PathVariable("score") int score) {
        List<Student> studentList = new ArrayList<Student>();
        for(int x = 0;x<score;x++){
            Student student = new Student();
            student.setName(name);
            student.setScore(score);
            student.setId(new Random().nextInt(100) + 1);
            studentList.add(student);
        }
        return studentList;
    }
}
