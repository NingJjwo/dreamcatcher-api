package com.dreamcatcher.dreamcatcher_api.config;

import jakarta.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatasourceDebugLogger {

    private static final Logger log = LoggerFactory.getLogger(DatasourceDebugLogger.class);

    @Value("${DB_URL:}")
    private String dbUrl;

    @PostConstruct
    public void logResolvedUrl() {
        String masked = dbUrl.replaceAll("(://[^:/@]+):[^@/]+@", "$1:***@");
        log.info("RESOLVED DB_URL={}", masked);
    }
}
