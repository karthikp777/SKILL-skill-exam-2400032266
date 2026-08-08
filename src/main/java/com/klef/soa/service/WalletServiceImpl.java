package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Wallet;
import com.klef.soa.repository.WalletRepository;

@Service
public class WalletServiceImpl implements WalletService
{
	@Autowired
	private WalletRepository repo;

	@Override
	public Wallet addWallet(Wallet w)
	{
		return repo.save(w);
	}

	@Override
	public Wallet updateWallet(Wallet w)
	{
		Optional<Wallet> optional = repo.findById(w.getWalletId());

		if(optional.isPresent())
		{
			Wallet wallet = optional.get();

			wallet.setName(w.getName());
			wallet.setType(w.getType());
			wallet.setStatus(w.getStatus());
			wallet.setLocation(w.getLocation());

			return repo.save(wallet);
		}

		return null;
	}

	@Override
	public List<Wallet> displayAllWallets()
	{
		return repo.findAll();
	}

	@Override
	public Wallet displayWalletById(Long id)
	{
		return repo.findById(id).orElse(null);
	}

	@Override
	public String deleteWalletById(Long id)
	{
		Optional<Wallet> optional = repo.findById(id);

		if(optional.isPresent())
		{
			repo.deleteById(id);
			return "Wallet Deleted Successfully";
		}

		return "Wallet ID Not Found";
	}

	@Override
	public List<Wallet> displayWalletsByName(String name)
	{
		return repo.findByName(name);
	}

	@Override
	public List<Wallet> displayWalletsByType(String type)
	{
		return repo.findByType(type);
	}

	@Override
	public Long walletCount() {
		return repo.count();
	}
}