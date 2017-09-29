package ru.techlab.risks.messaging.services.messaging.ticks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.xegex.quikload.model.tick.futures.BaseFuturesTick;

import java.util.Collections;

/**
 * Created by Dmitry.Erohin dim777@ya.ru on 27.05.2017.
 * Copyright (C) 2017 - present by <a href="https://www.ineb.ru/">Ineb Inc</a>.
 * Please see distribution for license.
 */
@Service
public class TicksMessageServiceImpl implements TicksMessageService {
    private static final Logger log = LoggerFactory.getLogger(TicksMessageService.class);

    @Autowired
    @Qualifier("sourceChannel")
    private MessageChannel localChannel;

    @Override
    public void send(BaseFuturesTick tick) {
        localChannel.send(MessageBuilder.createMessage(tick,
                new MessageHeaders(Collections.singletonMap(MessageHeaders.CONTENT_TYPE, "application/json"))));
    }
}
