package com.dreamcatcher.dreamcatcher_api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.assets")
public record AssetProperties(String baseUrl) {
}
