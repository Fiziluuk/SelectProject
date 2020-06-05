package com.fizi.selectproject.repository;


import com.fizi.selectproject.entity.Direction;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionRepository extends BaseRepository<Direction,Integer> {
     Direction findByName(String name);
}
