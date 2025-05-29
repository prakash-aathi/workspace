package com.examly.springappfeedback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examly.springappfeedback.model.Feedback;
import com.examly.springappfeedback.model.User;
import com.examly.springappfeedback.model.WiFiSchema;
import com.examly.springappfeedback.repository.FeedbackRepo;
import com.examly.springappfeedback.repository.UserRepo;
import com.examly.springappfeedback.repository.WiFiSchemaRepo;

@Service
public class FeedbackService {

    private final FeedbackRepo feedbackRepo;
    private final UserRepo userRepo;
    private final WiFiSchemaRepo wifiSchemaRepo;

    public FeedbackService(FeedbackRepo feedbackRepo, UserRepo userRepo, WiFiSchemaRepo wifiSchemaRepo) {
        this.feedbackRepo = feedbackRepo;
        this.userRepo = userRepo;
        this.wifiSchemaRepo = wifiSchemaRepo;
    }

    public Feedback createFeedback(Feedback feedback) {
        // get user by ID or else create a new user
        Optional<User> user = userRepo.findById(feedback.getUser().getUserId());
        if (user.isPresent()) {
            feedback.setUser(user.get());
        } else {
            feedback.setUser(userRepo.save(feedback.getUser()));
        }

        // get WiFi schema by ID or else create a new WiFi schema
        Optional<WiFiSchema> wifiSchema = wifiSchemaRepo.findById(feedback.getWifiSchema().getWifiSchemeId());
        if (wifiSchema.isPresent()) {
            feedback.setWifiSchema(wifiSchema.get());
        } else {
            feedback.setWifiSchema(wifiSchemaRepo.save(feedback.getWifiSchema()));
        }

        // save the feedback
        return feedbackRepo.save(feedback);

    }

    public List<Feedback> getAllFeedback() {
        return feedbackRepo.findAll();
    }

    public List<Feedback> getFeedbackByUserId(Long userId) {

        return feedbackRepo.findByUser_UserId(userId);

    }

}
