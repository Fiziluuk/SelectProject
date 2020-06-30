package com.fizi.selectproject.controller;

import com.fizi.selectproject.component.RequestComponent;
import com.fizi.selectproject.entity.Direction;
import com.fizi.selectproject.entity.Student;
import com.fizi.selectproject.entity.Teacher;
import com.fizi.selectproject.service.StudentService;
import com.fizi.selectproject.service.TeacherService;
import com.fizi.selectproject.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;


@RestController
@RequestMapping("/api/student/")
public class StudentController {
    @Autowired
    private UserService us;
    @Autowired
    private TeacherService ts;
    @Autowired
    private StudentService ss;
    @Autowired
    private RequestComponent requestComponent;

    @GetMapping("listTeacher")
    public Map listTeachers() {
        return Map.of("teacherList",ss.teacherList()) ;
    }
    @GetMapping("teachers/{tid}/directions")
    public Map ListTeacherDirections(@PathVariable int tid) {
        return Map.of("teacherDirections", ts.getTeacher(tid).getDirections());
    }

    @PostMapping("addDirection")
    public Map selectDirection(@RequestBody Direction direction) {

        Student student = ss.getStudent(requestComponent.getUid());
        if(student.getDirection() == null)
            student.setDirection(direction.getName());
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"方向已选");

        ss.saveStudent(student);
        return Map.of("direction",direction);
    }
    @PostMapping("addTeacher")
    public Map selectTeacher(@RequestBody Teacher teacher) {
        Student s;

        if(teacher.getStuNum() < teacher.getStuCap()) {
            s = ss.getStudent(requestComponent.getUid());
            s.setTeacher(teacher);
        }else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"人数已满");
        if (s.getDirection() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"请先选择方向");

        ss.saveStudent(s);
        return Map.of("teacher",teacher);
    }
}
