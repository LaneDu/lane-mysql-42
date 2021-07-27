package com.galaxy.repository;

import com.galaxy.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author lane
 * @date 2021年07月20日 下午7:36
 */
public interface PositionRepository  extends JpaRepository<Position,Long> {

    @Query(nativeQuery = true,value = "" +
            "select p.id,p.name,p.salary,p.city,pd.description from position p join position_detail pd on(p.id=pd.pid) where p.id=:id")
    public Object findPositionsById(@Param("id") long id);

}
