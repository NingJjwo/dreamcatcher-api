package com.dreamcatcher.dreamcatcherapi.controller;

import com.dreamcatcher.dreamcatcherapi.model.Group;
import com.dreamcatcher.dreamcatcherapi.repositories.GroupRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/groupData")
public class GroupController {

    private final GroupRepository groupRepository;


    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping
    public List<Group> getGroupInfo() {
        return groupRepository.findAll();
    }

    @GetMapping("/dreamcatcherInfo")
    public Optional<Group> getDreamcatcherData() {
       return groupRepository.findByName("Dreamcatcher");
    }
    @GetMapping("/minxInfo")
    public Optional<Group> getMinxData() {
        return groupRepository.findByName("Minx");
    }


}
