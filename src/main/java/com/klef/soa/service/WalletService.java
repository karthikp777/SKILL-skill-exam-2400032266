package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Wallet;

public interface WalletService
{
    Wallet addWallet(Wallet w);

    Wallet updateWallet(Wallet w);

    List<Wallet> displayAllWallets();

    Wallet displayWalletById(Long id);

    String deleteWalletById(Long id);

    List<Wallet> displayWalletsByName(String name);

    List<Wallet> displayWalletsByType(String type);
    
    Long walletCount();
}