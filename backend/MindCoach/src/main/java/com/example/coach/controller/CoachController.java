package com.example.coach.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.coach.entity.Coach;
import com.example.coach.entity.pendingCoach;
import com.example.coach.repo.CoachRepository;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/coaches")
public class CoachController {

    @Autowired
    private com.example.coach.repo.pendingCoachRepository pendingCoachRepository;
    
    @Autowired
    private com.example.coach.service.emailService emailService; 
    @Autowired
    private CoachRepository coachRepository;
    // Endpoint for submitting a coach request
    @PostMapping("/request")
    public ResponseEntity<String> requestJoin(@RequestBody pendingCoach coachRequest) {
        pendingCoachRepository.save(coachRequest);
        return ResponseEntity.ok("Coach request submitted.");
    }
    // Endpoint for listing all coachs
    @GetMapping("/all")
    public ResponseEntity<List<Coach>> getAllCoaches() {
        List<Coach> coaches = coachRepository.findAll(); // Fetches all coaches
        return ResponseEntity.ok(coaches); // Returns the list of coaches
    }
    // Endpoint for listing coach by Id
    @GetMapping("/{id}")
public ResponseEntity<pendingCoach> getCoachById(@PathVariable Long id) {
    pendingCoach coach = pendingCoachRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Coach not found with ID: " + id));
    return ResponseEntity.ok(coach);
}


    // Endpoint for listing pending requests
    @GetMapping("/pending")
    public List<pendingCoach> getPendingCoaches() {
        return pendingCoachRepository.findByProcessed(false);
    }
    @GetMapping("/pending/{id}")
public ResponseEntity<pendingCoach> getPendingCoachById(@PathVariable Long id) {
    pendingCoach coach = pendingCoachRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Coach not found"));
    return ResponseEntity.ok(coach);
}

   // Endpoint for handling admin decisions
   @PostMapping("/decision/{id}")
public ResponseEntity<String> processDecision(
    @PathVariable Long id, // Get ID from the URL path
    @RequestBody Map<String, Object> decisionData // Decision in the body
) {
    String decision = decisionData.get("decision").toString();

    pendingCoach coach = pendingCoachRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Coach not found"));

    if ("accept".equalsIgnoreCase(decision)) {
        // Mark as processed when accepted
        coach.setProcessed(true);
        pendingCoachRepository.save(coach);

        emailService.sendEmail(
            coach.getEmail(),
            "Coach Application Accepted",
            "Congratulations! We are thrilled to welcome you as part of the MindCoach community. Your application has been approved, and we can't wait to see the positive impact you'll make!"
        );
        return ResponseEntity.ok("Coach accepted and email sent.");
    } else {
        // Do not mark as processed when rejected
        emailService.sendEmail(
            coach.getEmail(),
            "Coach Application Rejected",
            "Thank you for your interest in joining MindCoach. After careful consideration, we regret to inform you that your application was not approved at this time. We encourage you to reapply in the future and wish you all the best in your journey."
        );
        return ResponseEntity.ok("Coach rejected and email sent.");
    }
}

@RequestMapping(value="/update/{id}",method = RequestMethod.PUT)

public ResponseEntity<Coach> updateCoach(@PathVariable Long id, @RequestBody Coach updatedCoach) {
    Coach coach = coachRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Coach not found with ID: " + id));

    // Update fields
    coach.setUsername(updatedCoach.getUsername());
    coach.setEmail(updatedCoach.getEmail());
    coach.setnbTel(updatedCoach.getnbTel());
    coach.setExpertise(updatedCoach.getExpertise());
    coach.setStatus(updatedCoach.getStatus());

    // Save updated coach to the repository
    Coach savedCoach = coachRepository.save(coach);
    return ResponseEntity.ok(savedCoach);
}

}

