package com.example.wallet.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Table(name = "wallet")
@Entity
@NoArgsConstructor
public class Wallet {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    UUID walletId;
    long account;

    Long version;


}
