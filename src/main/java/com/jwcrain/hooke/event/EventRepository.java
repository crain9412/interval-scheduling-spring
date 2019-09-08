package com.jwcrain.hooke.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Jon Crain
 */
@Repository
public interface EventRepository extends JpaRepository<EventEntity, Integer> {

}