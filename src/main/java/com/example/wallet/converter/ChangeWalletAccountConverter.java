package com.example.wallet.converter;

import com.example.wallet.dto.ChangeWalletAccountDTO;
import com.example.wallet.entity.ChangeWalletAccount;
import org.springframework.stereotype.Component;

@Component
public class ChangeWalletAccountConverter {
    public ChangeWalletAccount convertFromDTO(ChangeWalletAccountDTO dto) {
        return new ChangeWalletAccount(dto.getWalletID(), dto.getAmount(), dto.getOperationType());
    }

}
