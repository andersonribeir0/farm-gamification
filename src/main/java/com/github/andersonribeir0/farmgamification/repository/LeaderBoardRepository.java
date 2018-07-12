package com.github.andersonribeir0.farmgamification.repository;

import com.github.andersonribeir0.farmgamification.domain.LeaderBoardRow;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LeaderBoardRepository extends ReactiveMongoRepository<LeaderBoardRow, String> {
}
