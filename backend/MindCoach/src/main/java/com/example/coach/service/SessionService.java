package com.example.coach.service;

import java.util.List;

import com.example.coach.entity.Session;

import java.util.List;
import java.util.Optional;

public interface SessionService {
    List<Session> getAllSessions();
    Session createSession(Session session);
    void deleteSession(Long id);
    Session updateSession(Long id, Session session);
}