package com.galaxy.repository;

import com.galaxy.entity.City;
import com.galaxy.entity.PositionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lane
 * @date 2021年07月21日 上午11:13
 */
public interface CityRepository extends JpaRepository<City,Long> {
}
