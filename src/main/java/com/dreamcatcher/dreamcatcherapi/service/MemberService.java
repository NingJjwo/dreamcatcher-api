package com.dreamcatcher.dreamcatcherapi.service;

import com.dreamcatcher.dreamcatcherapi.model.Member;
import com.dreamcatcher.dreamcatcherapi.exception.DreamcatcherException;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public void generateImageUrl(Member member) {
        if (member != null && member.getImage() == null) {
            String stageName = member.getStageName() != null ? member.getStageName().toLowerCase() : "default";
            member.setImage("https://dreamcatcherapi.onrender.com/images/members/" + stageName + ".png");
        }
    }

    public void validateStageName(String stageName) {
        if (stageName == null || stageName.trim().isEmpty()) {
            throw new DreamcatcherException(400, "Please provide a stage name");
        }
    }
}
