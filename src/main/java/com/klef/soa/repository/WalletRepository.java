package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.soa.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>
{
	List<Wallet> findByName(String name);

	List<Wallet> findByType(String type);
}