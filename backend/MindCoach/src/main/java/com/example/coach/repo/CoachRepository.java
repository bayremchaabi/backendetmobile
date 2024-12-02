package com.example.coach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.coach.entity.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {
    


}