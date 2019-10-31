package com.aus.asx.controller;

import java.util.List;

import com.aus.asx.model.Notification;
import com.aus.asx.model.Template;
import com.aus.asx.service.NavBarSvc;
import com.aus.asx.service.NotificationSvc;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationSvc notificationSvc;
    private final NavBarSvc navBarSvc;

    @GetMapping(value = "/notifications", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Notification> getAllNotifications() {
        log.info("Fetching stream of notifications");
        return notificationSvc.findAll();
    }

    @GetMapping(value = "/template", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Template getNavBarTemplate(@RequestParam("scope") String scope) {
        log.info("Fetching navbar template for scope: {}", scope);
        return navBarSvc.findForScope(scope);
    }
}