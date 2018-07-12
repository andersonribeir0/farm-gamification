package com.github.andersonribeir0.farmgamification.domain;

import lombok.Data;

import java.util.Date;

@Data
public class LeaderBoardRow {
    private final String id;
    private final Float totalQuantity;
    private final Date registrationDate;

    public LeaderBoardRow() {
        this(null, 0F, null);
    }

    public LeaderBoardRow(String id, Float totalQuantity, Date registrationDate) {
        this.id = id;
        this.totalQuantity = totalQuantity;
        this.registrationDate = registrationDate;
    }

}
