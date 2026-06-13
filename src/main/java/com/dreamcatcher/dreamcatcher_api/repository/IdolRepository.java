package com.dreamcatcher.dreamcatcher_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dreamcatcher.dreamcatcher_api.model.Idol;

@Repository
public interface IdolRepository extends JpaRepository<Idol, Long> {

    @EntityGraph(attributePaths = { "group" })
    List<Idol> findAll();

    @EntityGraph(attributePaths = { "group" })
    List<Idol> findByGroupGroupId(Long groupId);

    @EntityGraph(attributePaths = { "group" })
    List<Idol> findByStageNameContainingIgnoreCase(String stageName);
}
