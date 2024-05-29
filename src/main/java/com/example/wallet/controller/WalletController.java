package com.example.wallet.controller;

import com.example.wallet.converter.ChangeWalletAccountConverter;
import com.example.wallet.converter.WalletConverter;
import com.example.wallet.dto.ChangeWalletAccountDTO;
import com.example.wallet.dto.WalletDTO;
import com.example.wallet.entity.Wallet;
import com.example.wallet.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class WalletController {

    private final WalletService walletService;
    private final WalletConverter walletConverter;
    private final ChangeWalletAccountConverter changeWalletAccountConverter;

    @PostMapping("/api/v1/wallets")
    public UUID addWallet(@RequestBody WalletDTO walletDTO) {
      Wallet wallet = walletConverter.convertFromDTO(walletDTO);
      return walletService.creatWallet(wallet);
    }


    @GetMapping("/api/v1/wallets/{wallet_id}")
    public WalletDTO getWallets(@PathVariable("wallet_id") UUID walletId) {
     Wallet wallet = walletService.getWallet(walletId);
     return walletConverter.convertToDTO(wallet);
    }

    @PostMapping("/api/v1/wallet")
    public WalletDTO changeWallet(@RequestBody ChangeWalletAccountDTO changeWalletAccountDTO) throws InterruptedException {
        return walletConverter.convertToDTO(
                walletService.changeWallet(
                        changeWalletAccountConverter.convertFromDTO(changeWalletAccountDTO)
                )
        );
    }


}
