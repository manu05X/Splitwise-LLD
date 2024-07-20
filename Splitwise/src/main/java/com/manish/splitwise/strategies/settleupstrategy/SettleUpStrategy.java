package com.manish.splitwise.strategies.settleupstrategy;

import com.manish.splitwise.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Transaction> settle(List<Expense> expenses);
}
