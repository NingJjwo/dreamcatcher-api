package com.dreamcatcher.dreamcatcher_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dreamcatcher.dreamcatcher_api.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @EntityGraph(attributePaths = { "idols", "idols.positions" })
    Optional<Group> findWithMembersByGroupId(Long groupId);
}
