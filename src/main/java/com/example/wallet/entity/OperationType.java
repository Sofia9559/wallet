package com.example.wallet.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
public enum OperationType {
    DEPOSIT,
    WITHDRAW

}
