package com.lepton.surveybasic.id.snowflake;


import com.lepton.surveycommon.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/basic")
public class IdController {

    private final SnowFlakeGenerator snowFlakeGenerator;

    public IdController(SnowFlakeGenerator snowFlakeGenerator) {
        this.snowFlakeGenerator = snowFlakeGenerator;
    }


    @GetMapping("/snow-id")
    public Mono<Result<Long>> getSnowFlakeId(){
        return snowFlakeGenerator.getSnowflakeId()
                .map(id -> new Result<Long>().ok(id));
    }

    @GetMapping("/generate-batch-ids")
    public Flux<Long> generateIds(@RequestParam int batchSize) {
        return snowFlakeGenerator.generateBatchIds(batchSize);
    }


}
