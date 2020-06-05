package com.fizi.selectproject.repository;


import com.fizi.selectproject.entity.Course;

public interface CourseRepository extends BaseRepository<Course,Integer> {
   Course findByName(String name);
}
