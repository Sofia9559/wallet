package com.example.wallet.service;

import com.example.wallet.entity.ChangeWalletAccount;
import com.example.wallet.entity.Wallet;
import com.example.wallet.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
@AllArgsConstructor
public class WalletService {
    private WalletRepository walletRepository;

    public Wallet getWallet(@PathVariable UUID walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException(String.format("Кошелек с id = %s не найден", walletId)));
    }

    public UUID creatWallet(Wallet wallet) {
        return walletRepository.save(wallet).getWalletId();
    }

    public Wallet changeWallet(ChangeWalletAccount changeWalletAccount) {
        Wallet wallet = getWallet(changeWalletAccount.getWalletID());

        switch (changeWalletAccount.getOperationType()) {
            case DEPOSIT -> wallet.setAccount(wallet.getAccount()+changeWalletAccount.getAmount());
            case WITHDRAW -> {
                if(wallet.getAccount()>=changeWalletAccount.getAmount()) {
                    wallet.setAccount(wallet.getAccount()-changeWalletAccount.getAmount());
                }
                else {
                    throw new RuntimeException("Недостаточно средств для выполнения данной операции");
                }
            }
        }
        return walletRepository.save(wallet);
    }
}
