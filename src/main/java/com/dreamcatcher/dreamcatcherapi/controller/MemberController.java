package com.dreamcatcher.dreamcatcherapi.controller;

import com.dreamcatcher.dreamcatcherapi.exception.DreamcatcherException;
import com.dreamcatcher.dreamcatcherapi.model.Member;
import com.dreamcatcher.dreamcatcherapi.repositories.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")

public class MemberController {
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @GetMapping("/stageName")
    public ResponseEntity<Member> getMemberByStageName(@RequestParam(required = false) String stageName) {
        if (stageName == null || stageName.trim().isEmpty()) {
            throw new DreamcatcherException(400, "Please provide a stage name");
        }
        Optional<Member> member = memberRepository.findByStageName(stageName);
        return member.map(ResponseEntity::ok)
                .orElseThrow(() -> new DreamcatcherException(404, "Member with stage name " + stageName + " not found"));
    }
}