package com.example.coach.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coach.entity.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
}