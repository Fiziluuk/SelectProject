package com.fizi.selectproject.service;


import com.fizi.selectproject.entity.Direction;
import com.fizi.selectproject.entity.Student;
import com.fizi.selectproject.repository.DirectionRepository;
import com.fizi.selectproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {
    @Autowired
    StudentRepository sr;
    @Autowired
    TeacherService ts;
    @Autowired
    DirectionRepository dr;

    public Student getStudent(int sid) {
        return sr.find(sid);
    }
    public Direction getDirection(int did) {
        return dr.findById(did).orElse(null);
    }


}
