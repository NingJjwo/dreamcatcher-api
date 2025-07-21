package com.dreamcatcher.dreamcatcherapi.repositories;

import com.dreamcatcher.dreamcatcherapi.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MemberRepository extends MongoRepository<Member, String> {
    Optional<Member> findByStageName(String stageName);
}
