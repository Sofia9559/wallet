package com.example.wallet.dto;

import com.example.wallet.entity.OperationType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ChangeWalletAccountDTO {
    UUID walletID;
    long amount;
    OperationType operationType;
}
