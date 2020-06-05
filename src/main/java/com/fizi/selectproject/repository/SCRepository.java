package com.fizi.selectproject.repository;


import com.fizi.selectproject.entity.SC;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SCRepository extends BaseRepository<SC,Integer>{
    @Query("select sc.score from SC sc where sc.courseName=:name AND sc.student.id=:sid")
   Double findScoreByCourseName(@Param("name") String name, @Param("sid") int sid);
}
