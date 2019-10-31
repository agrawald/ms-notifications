package com.aus.asx.service;

import java.util.ArrayList;
import java.util.List;

import com.aus.asx.model.Notification;
import com.aus.asx.model.Template;
import com.aus.asx.model.Template.Nav;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class NavBarSvc {

    private final static List<Template> TEMPLATES = new ArrayList<Template>() {
        private static final long serialVersionUID = 6196276536960028640L;
        {
            add(new Template(new ArrayList<Nav>() {
                private static final long serialVersionUID = -1627890641814288146L;
                {
                    add(new Nav("Tasks", "tasks", "/tasks"));
                    add(new Nav("Notifications", "notifications", "/notifications"));
                }
            }));
            add(new Template(new ArrayList<Nav>() {
                private static final long serialVersionUID = 4229174786471085549L;

                {
                    add(new Nav("Tasks", "tasks", "/tasks"));
                }
            }));
        }
    };

    public Template findForScope(final String scope) {
        log.info("Getting template for scope: {}", scope);
        return "admin".equalsIgnoreCase(scope) ? TEMPLATES.get(0) : TEMPLATES.get(1);
    }
}