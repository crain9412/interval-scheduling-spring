package com.jwcrain.intervalschedulingspring.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jon Crain
 */
@Repository
public interface EventRepository extends JpaRepository<EventEntity, Integer> {

    @Query("SELECT e FROM EventEntity e ORDER BY e.endTime ASC")
    public List<EventEntity> findAllOrderByEndTime();
}