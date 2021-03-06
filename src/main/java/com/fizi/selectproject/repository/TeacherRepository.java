package com.fizi.selectproject.repository;

import com.fizi.selectproject.entity.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends BaseRepository<Teacher,Integer> {


    @Query("from Teacher t where t.id=:tid")
    Teacher find(@Param("tid") int tid);
}
