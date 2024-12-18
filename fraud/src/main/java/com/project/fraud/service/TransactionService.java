package com.project.fraud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.fraud.model.Transaction;

@Service
public class TransactionService {
	
	private final List<Transaction> transactions = new ArrayList<>();
	
	public List<Transaction> getAllTransactions() {
		return transactions;
	}
	
	public void addTransactions(List<Transaction> newTransactions) {
		transactions.addAll(newTransactions);
	}

	public List<Transaction> filterByCountry(String country) {
		return transactions.stream()
				.filter(tx -> tx.getLocation().getCountry().equalsIgnoreCase(country)).toList();
	}
	
	public List<Transaction> filterByAmount(double minAmount) {
		return transactions.stream()
				.filter(tx -> tx.getAmount() > minAmount).toList();
	}
}
