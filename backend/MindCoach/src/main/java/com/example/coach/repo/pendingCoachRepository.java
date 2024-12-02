package com.example.coach.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coach.entity.pendingCoach;

import java.util.List;

@Repository
public interface pendingCoachRepository extends JpaRepository<pendingCoach, Long> {
    List<pendingCoach> findByProcessed(boolean processed);  
}
