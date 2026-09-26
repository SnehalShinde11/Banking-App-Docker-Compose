package com.banking.transaction;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @GetMapping
    public List<Transaction> getTransactions() {

        return Arrays.asList(
            new Transaction(1, 101, 5000, "CREDIT"),
            new Transaction(2, 101, 1500, "DEBIT"),
            new Transaction(3, 102, 10000, "CREDIT")
        );
    }

    @GetMapping("/health")
    public String health() {
        return "Transaction Service is healthy";
    }

    static class Transaction {

        private int id;
        private int accountId;
        private double amount;
        private String type;

        public Transaction(
                int id,
                int accountId,
                double amount,
                String type) {

            this.id = id;
            this.accountId = accountId;
            this.amount = amount;
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public int getAccountId() {
            return accountId;
        }

        public double getAmount() {
            return amount;
        }

        public String getType() {
            return type;
        }
    }
}
