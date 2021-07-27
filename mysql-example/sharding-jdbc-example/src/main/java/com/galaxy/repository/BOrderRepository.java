package com.galaxy.repository;

import com.galaxy.entity.BOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lane
 * @date 2021年07月21日 下午12:12
 */
public interface BOrderRepository extends JpaRepository<BOrder,Long> {
}
