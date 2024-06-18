package com.lepton.surveybasic.id.snowflake;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SnowFlakeGenerator {

    Mono<Long> getSnowflakeId();

    Flux<Long> generateBatchIds(int batchSize);

}
