package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.entity.Wallet;
import com.klef.soa.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController
{
	@Autowired
	private WalletService service;

	@GetMapping("/")
	public String demo()
	{
		return " Wallet Project";
	}

	// Add Wallet
	@PostMapping("/add")
	public ResponseEntity<Wallet> addWallet(@RequestBody Wallet w)
	{
		Wallet wallet = service.addWallet(w);
		return ResponseEntity.status(201).body(wallet);
	}

	// Display All Wallets
	@GetMapping("/displayall")
	public ResponseEntity<List<Wallet>> displayAllWallets()
	{
		List<Wallet> wallets = service.displayAllWallets();
		return ResponseEntity.status(200).body(wallets);
	}

	// Display Wallet By ID
	@GetMapping("/display")
	public ResponseEntity<?> displayWalletById(@RequestParam Long id)
	{
		Wallet wallet = service.displayWalletById(id);

		if (wallet != null)
		{
			return ResponseEntity.status(200).body(wallet);
		}
		else
		{
			return ResponseEntity.status(404).body("Wallet ID Not Found");
		}
	}

	// Update Wallet
	@PutMapping("/update")
	public ResponseEntity<?> updateWallet(@RequestBody Wallet wallet)
	{
		Wallet w = service.updateWallet(wallet);

		if (w != null)
		{
			return ResponseEntity.ok(w);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wallet ID Not Found");
		}
	}

	// Delete Wallet By ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteWalletById(@PathVariable Long id)
	{
		String message = service.deleteWalletById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// Display Wallets By Name
	@GetMapping("/displaybyname/{name}")
	public ResponseEntity<List<Wallet>> displayWalletsByName(@PathVariable String name)
	{
		List<Wallet> wallets = service.displayWalletsByName(name);
		return ResponseEntity.status(200).body(wallets);
	}

	// Display Wallets By Type
	@GetMapping("/displaybytype/{type}")
	public ResponseEntity<List<Wallet>> displayWalletsByType(@PathVariable String type)
	{
		List<Wallet> wallets = service.displayWalletsByType(type);
		return ResponseEntity.status(200).body(wallets);
	}
	@GetMapping("/count")
	public ResponseEntity<String> count(){
		Long c=service.walletCount();
		
		String msg="total wallets="+c;
		
		return ResponseEntity.ok(msg);
	}
}