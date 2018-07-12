package com.github.andersonribeir0.farmgamification.event;

import lombok.Data;

import java.util.Date;

@Data
public class MilkProductionCreatedEvent {
    private final String caddleId;
    private final Date date;
    private final float quantity;
}
