package service;

import model.ClubMember;
import model.InventoryItem;
import model.Transaction;

import repository.TransactionRepository;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void borrowItem(ClubMember member, InventoryItem item, int days) {
        Transaction transaction = new Transaction(member, item, days);
        transactionRepository.addTransaction(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.getAllTransactions();
    }

    public boolean returnItem(Integer transactionId) {
        Optional<Transaction> transactionOpt = transactionRepository.getTransactionById(transactionId);
        if(transactionOpt.isPresent()) {
            Transaction transaction = transactionOpt.get();
            if(!transaction.isReturned()) {
                transaction.setReturned(true);
                InventoryItem item = transaction.getItem();
                item.setQuantity(item.getQuantity() + 1);

                return true;
            }
        }
        return false;
    }

    public List<Transaction> getOverDueTransactions() {
        return transactionRepository.getOverdueTransactions();
    }
}
