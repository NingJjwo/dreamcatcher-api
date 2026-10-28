package com.dreamcatcher.dreamcatcher_api.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class AssetUrlTest {

    @Test
    void resolvesLeadingSlashPathAgainstBaseUrl() {
        assertEquals(
                "https://api.example.com/images/idol.png",
                AssetUrl.resolve("https://api.example.com", "/images/idol.png"));
    }

    @Test
    void resolvesRelativePathAgainstBaseUrlRoot() {
        assertEquals(
                "https://api.example.com/images/idol.png",
                AssetUrl.resolve("https://api.example.com", "images/idol.png"));
    }

    @Test
    void keepsAlreadyAbsoluteUrl() {
        assertEquals(
                "https://cdn.example.com/idol.png",
                AssetUrl.resolve("https://api.example.com", "https://cdn.example.com/idol.png"));
    }

    @Test
    void returnsNullWhenPathIsNull() {
        assertNull(AssetUrl.resolve("https://api.example.com", null));
    }

    @Test
    void returnsBlankPathUnchanged() {
        assertEquals(" ", AssetUrl.resolve("https://api.example.com", " "));
    }

    @Test
    void returnsPathWhenBaseUrlIsBlank() {
        assertEquals(
                "/images/idol.png",
                AssetUrl.resolve(" ", "/images/idol.png"));
    }
}
