package com.example.coach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.coach.entity.Session;
import com.example.coach.service.SessionService;

import java.util.List;


@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    // Get all sessions
    @GetMapping
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    // Create a new session
    @PostMapping
    public Session createSession(@RequestBody Session session) {
        return sessionService.createSession(session);
    }

    // Delete a session by ID
    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
    }

    // Update a session by ID
    @PutMapping("/{id}")
    public Session updateSession(@PathVariable Long id, @RequestBody Session session) {
        return sessionService.updateSession(id, session);
    }
}