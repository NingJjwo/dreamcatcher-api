package com.dreamcatcher.dreamcatcherapi.controller;

import com.dreamcatcher.dreamcatcherapi.model.Member;
import com.dreamcatcher.dreamcatcherapi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return members.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(members);
    }

    @GetMapping("/stageName")
    public ResponseEntity<Member> getMemberByStageName(@RequestParam(required = false) String stageName) {
        Member member = memberService.getMemberByStageName(stageName);
        return ResponseEntity.ok(member);
    }
}