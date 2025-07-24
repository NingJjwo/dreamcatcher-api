package com.dreamcatcher.dreamcatcherapi.controller;

import com.dreamcatcher.dreamcatcherapi.exception.DreamcatcherException;
import com.dreamcatcher.dreamcatcherapi.model.Member;
import com.dreamcatcher.dreamcatcherapi.repositories.MemberRepository;
import com.dreamcatcher.dreamcatcherapi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberRepository memberRepository, MemberService memberService) {
        this.memberRepository = memberRepository;
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        members.forEach(memberService::generateImageUrl);
        return members.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(members);
    }

    @GetMapping("/stageName")
    public ResponseEntity<Member> getMemberByStageName(@RequestParam(required = false) String stageName) {
        memberService.validateStageName(stageName);
        Optional<Member> member = memberRepository.findByStageName(stageName);
        return member.map(m -> {
            memberService.generateImageUrl(m);
            return ResponseEntity.ok(m);
        }).orElseThrow(() -> new DreamcatcherException(404, "Member with stage name " + stageName + " not found"));
    }
}