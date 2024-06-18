package com.lepton.surveybasic.id.snowflake.impl;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.lepton.surveybasic.id.snowflake.SnowFlakeGenerator;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.stream.IntStream;

@Service
public class SnowFlakeGeneratorImpl implements SnowFlakeGenerator {

    Snowflake snowflake = IdUtil.getSnowflake(1, 1);

    public Mono<Long> getSnowflakeId() {
        return Mono.just(snowflake.nextId());
    }


    public Flux<Long> generateBatchIds(int batchSize) {
        return Flux.defer(() -> Flux.fromStream(IntStream.range(0, batchSize).boxed())
                .flatMap(index -> Mono.fromCallable(snowflake::nextId).subscribeOn(Schedulers.parallel())));
    }
}
