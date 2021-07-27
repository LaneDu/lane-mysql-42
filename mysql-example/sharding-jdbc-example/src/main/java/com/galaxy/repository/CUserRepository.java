package com.galaxy.repository;

import com.galaxy.entity.CUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author lane
 * @date 2021年07月21日 下午6:35
 */
public interface CUserRepository extends JpaRepository<CUser,Long> {

    List<CUser> findByPwd(String pwd);
}
