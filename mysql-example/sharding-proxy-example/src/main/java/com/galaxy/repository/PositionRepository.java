package com.galaxy.repository;

import com.galaxy.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author lane
 * @date 2021年07月20日 下午7:36
 */
public interface PositionRepository extends JpaRepository<Position,Long> {


}
