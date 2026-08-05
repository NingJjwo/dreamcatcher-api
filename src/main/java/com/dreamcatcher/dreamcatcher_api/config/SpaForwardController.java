package com.dreamcatcher.dreamcatcher_api.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpaForwardController {

    @GetMapping(value = "/{path:[^\\.]*}")
    public String forwardToIndex() {
        return "forward:/index.html";
    }
}
