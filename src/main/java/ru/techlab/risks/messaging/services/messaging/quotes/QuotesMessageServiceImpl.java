package ru.techlab.risks.messaging.services.messaging.quotes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.xegex.quikload.model.quotes.futures.BaseFutureQuote;

import java.util.Collections;

/**
 * Created by Dmitry.Erohin dim777@ya.ru on 27.05.2017.
 * Copyright (C) 2017 - present by <a href="https://www.ineb.ru/">Ineb Inc</a>.
 * Please see distribution for license.
 */
@Service
public class QuotesMessageServiceImpl implements QuotesMessageService {
    private static final Logger log = LoggerFactory.getLogger(QuotesMessageServiceImpl.class);

    @Autowired
    @Qualifier("sourceChannel")
    private MessageChannel localChannel;

    @Override
    public void send(BaseFutureQuote quote) {
        localChannel.send(MessageBuilder.createMessage(quote,
                new MessageHeaders(Collections.singletonMap(MessageHeaders.CONTENT_TYPE, "application/json"))));
    }
}
