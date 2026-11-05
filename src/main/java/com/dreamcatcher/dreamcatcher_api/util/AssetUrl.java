package com.dreamcatcher.dreamcatcher_api.util;

import java.net.URI;

import org.springframework.stereotype.Component;

import com.dreamcatcher.dreamcatcher_api.config.AssetProperties;

@Component
public class AssetUrl {

    private final String baseUrl;

    public AssetUrl(AssetProperties properties) {
        this.baseUrl = properties.baseUrl();
    }

    public String resolve(String path) {
        if (path == null || path.isBlank()) {
            return path;
        }
        if (baseUrl == null || baseUrl.isBlank()) {
            return path;
        }

        try {
            return URI.create(baseUrl).resolve(path).toString();
        } catch (IllegalArgumentException ex) {
            // stored values may hold characters URI rejects, one bad row must not fail a response
            return path;
        }
    }
}
