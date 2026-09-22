package com.expensetracker.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.expensetracker.dto.request.TransactionRequest;
import com.expensetracker.dto.response.TransactionResponse;
import com.expensetracker.entity.Transaction;
import com.expensetracker.entity.User;

public interface TransactionService {
    TransactionResponse createTransaction(TransactionRequest request, User user);
    TransactionResponse updateTransaction(Long id, TransactionRequest request, User user);
    void deleteTransaction(Long id, User user);
    Page<TransactionResponse> getTransactions(User user, Pageable pageable);
    TransactionResponse getTransaction(Long id, User user);
    List<Transaction> getAnalysisData(User user, String period);
}
