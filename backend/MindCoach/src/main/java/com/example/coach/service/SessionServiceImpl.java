package com.example.coach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coach.entity.Session;
import com.example.coach.repo.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    @Override
    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }

    @Override
    public Session updateSession(Long id, Session session) {
        Optional<Session> existingSession = sessionRepository.findById(id);
        if (existingSession.isPresent()) {
            Session updatedSession = existingSession.get();
            updatedSession.setTitle(session.getTitle());
            updatedSession.setDate(session.getDate());
            updatedSession.setDescription(session.getDescription());
            updatedSession.setClientName(session.getClientName());
            updatedSession.setStatus(session.getStatus());
            updatedSession.setNotes(session.getNotes());
            return sessionRepository.save(updatedSession);
        }
        return null;  // return null if session doesn't exist
    }
}