package com.fizi.selectproject.service;


import com.fizi.selectproject.entity.Direction;
import com.fizi.selectproject.entity.Student;
import com.fizi.selectproject.entity.Teacher;
import com.fizi.selectproject.repository.DirectionRepository;
import com.fizi.selectproject.repository.StudentRepository;
import com.fizi.selectproject.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    StudentRepository sr;
    @Autowired
    TeacherService ts;
    @Autowired
    DirectionRepository dr;
    @Autowired
    TeacherRepository tr;

    public Student getStudent(int sid) {
        return sr.find(sid);
    }
    public Direction getDirection(int did) {
        return dr.findById(did).orElse(null);
    }

    public List<Teacher> teacherList() {
        return  tr.findAll();
    }
    public Student saveStudent(Student student) {
        return  sr.save(student);
    }


}