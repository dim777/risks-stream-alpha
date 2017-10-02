package ru.techlab.risks.messaging.streaming;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import reactor.core.publisher.Flux;
import ru.techlab.risks.react.model.Account;

import java.time.Duration;

/**
 * Created by rb052775 on 29.08.2017.
 */
@EnableBinding(Processor.class)
public class ReactiveProcessor {
    @StreamListener
    @Output(Processor.OUTPUT)
    public Flux<String> toUpperCase(@Input(Processor.INPUT) Flux<Account> inbound) {
        return inbound.
                log()
                .window(Duration.ofSeconds(10), Duration.ofSeconds(5))
                .flatMap(w -> w.reduce("", (s1,s2)->s1+s2))
                .log();
    }
}
