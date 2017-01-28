package com.master.template.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.session.HttpSessionCreatedEvent;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Component
public class SessionCreatedListenerService implements ApplicationListener<ApplicationEvent> {

    private static final Logger logger = LoggerFactory
            .getLogger(SessionCreatedListenerService.class);

    @Inject
    HttpSession httpSession;


    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        if (applicationEvent instanceof HttpSessionCreatedEvent) {
            logger.debug(" Session CreatedEvent:");

        } else if (applicationEvent instanceof HttpSessionDestroyedEvent) {

            //logger.debug("" + (Long) httpSession.getAttribute("userId"));

            logger.debug(" Session is DestroyedEvent:");

        } else if (applicationEvent instanceof AuthenticationSuccessEvent) {
            logger.debug("  athentication is sSuccessEvent:");
        } else {
            logger.debug(" unknown event occur  : ");

        }
    }
}