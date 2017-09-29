package ru.techlab.risks.messaging.services.messaging.ticks;

import ru.xegex.quikload.model.tick.futures.BaseFuturesTick;

/**
 * Created by Dmitry.Erohin dim777@ya.ru on 27.05.2017.
 * Copyright (C) 2017 - present by <a href="https://www.ineb.ru/">Ineb Inc</a>.
 * Please see distribution for license.
 */
public interface TicksMessageService {
    void send(BaseFuturesTick tick);
}
