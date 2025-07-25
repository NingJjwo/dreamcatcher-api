package com.dreamcatcher.dreamcatcherapi.service;

import com.dreamcatcher.dreamcatcherapi.exception.DreamcatcherException;
import com.dreamcatcher.dreamcatcherapi.model.Member;
import com.dreamcatcher.dreamcatcherapi.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void generateImageUrl(Member member) {
        if (member != null) {
            member.generateImageUrl();
            if (member.getImage() == null) {
                throw new DreamcatcherException(400, "Failed to generate image URL for member");
            }
        }
    }

    public void validateStageName(String stageName) {
        if (stageName == null || stageName.trim().isEmpty()) {
            throw new DreamcatcherException(400, "Please provide a valid stage name");
        }
    }

    public List<Member> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        members.forEach(this::generateImageUrl);
        return members;
    }

    public Member getMemberByStageName(String stageName) {
        Member member = memberRepository.findByStageName(stageName)
                .orElseThrow(() -> new DreamcatcherException(404, "Member with stage name " + stageName + " not found"));
        generateImageUrl(member);
        return member;
    }
}
