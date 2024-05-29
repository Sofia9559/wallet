package com.example.wallet.converter;

import com.example.wallet.dto.WalletDTO;
import com.example.wallet.entity.Wallet;
import org.springframework.stereotype.Component;

@Component
public class WalletConverter {
    public Wallet convertFromDTO(WalletDTO dto) {
        return new Wallet(dto.getWalletId(), dto.getAccount());
    }

    public WalletDTO convertToDTO(Wallet wallet) {
        return new WalletDTO(wallet.getWalletId(), wallet.getAccount());
    }
}
