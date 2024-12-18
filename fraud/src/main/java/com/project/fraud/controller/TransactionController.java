package com.project.fraud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fraud.model.Transaction;
import com.project.fraud.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;

	@GetMapping
	public List<Transaction> getAllTransaction() {
		return transactionService.getAllTransactions();
	}
	
	@PostMapping
	public String loadTransactions(@RequestBody List<Transaction> transactions) {
		transactionService.addTransactions(transactions);
		return "Transactions loaded successfully!";
	}
	
	@GetMapping("/filter/amount/{minAmount}")
	public List<Transaction> getTransactionsByAmount(@PathVariable double minAmount) {
		return transactionService.filterByAmount(minAmount);
	}
	
	@GetMapping("/filter/country/{country}")
	public List<Transaction> getTransactionsByCountry(@PathVariable("country") String Country) {
		return transactionService.filterByCountry(Country);
	}
	
}
