package com.galaxy.repository;

import com.galaxy.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lane
 * @date 2021年07月27日 下午7:14
 */
public interface OrderRepository extends JpaRepository<Order,Long> {
}
