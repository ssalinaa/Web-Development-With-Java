package com.inventory.repository;

import com.inventory.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.Optional;

@Repository
public class TransactionRepository {
    private static Map<Integer, Transaction> transactionTable = new HashMap<>();

    public void addTransaction(Transaction transaction) {
        transactionTable.put(transaction.getId(), transaction);
    }

    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactionTable.values());
    }

    public Optional<Transaction> getTransactionById(Integer id) {
        return Optional.ofNullable(transactionTable.get(id));
    }

    public List<Transaction> getOverdueTransactions() {
        return transactionTable.values().stream()
                .filter(transaction -> !transaction.isReturned() && transaction.getDueDate().isBefore(LocalDateTime.now()))
                .collect(Collectors.toList());
    }
}