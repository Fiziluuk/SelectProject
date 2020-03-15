package com.fizi.selectproject.repository;


import com.fizi.selectproject.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends BaseRepository<Student,String> {
}
