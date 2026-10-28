package com.dreamcatcher.dreamcatcher_api.util;

import java.net.URI;

public final class AssetUrl {

    private AssetUrl() {
    }

    public static String resolve(String baseUrl, String path) {
        if (path == null || path.isBlank()) {
            return path;
        }
        if (baseUrl == null || baseUrl.isBlank()) {
            return path;
        }
        return URI.create(baseUrl).resolve(path).toString();
    }
}
