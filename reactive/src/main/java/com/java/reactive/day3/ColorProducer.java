package com.java.reactive.day3;

import com.java.reactive.utils.Singleton;
import reactor.core.publisher.FluxSink;

import java.time.LocalDateTime;
import java.util.function.Consumer;

public class ColorProducer implements Consumer<FluxSink<String>> {
    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    @Override
    public Consumer<FluxSink<String>> andThen(Consumer<? super FluxSink<String>> after) {
        return Consumer.super.andThen(after);
    }

    public void product () {
        String thread = Thread.currentThread().getName();

        this.fluxSink.next(thread+": "+ LocalDateTime.now()+": "+Singleton.faker().color().name());
    }
}
