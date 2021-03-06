package com.example.webservice.domains.firebase.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.example.webservice.domains.firebase.models.dto.PushNotification;
import com.example.webservice.exceptions.invalid.InvalidException;
import com.example.webservice.exceptions.notfound.NotFoundException;
import com.example.webservice.exceptions.unknown.UnknownException;

public interface NotificationService {
    void sendNotification(Long userId, PushNotification notification) throws InvalidException, NotFoundException, JsonProcessingException, UnknownException;

    void sendNotification(PushNotification notification) throws InvalidException, JsonProcessingException, UnknownException;

}
