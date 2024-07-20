package com.manish.splitwise.strategies.settleupstrategy;

import com.manish.splitwise.models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("bruteForceSettleUpStrategy")
public class BruteForceSettleUpStrategy implements SettleUpStrategy {

    @Override
    public List<Transaction> settle(List<Expense> expenses) {
        return null;
    }
}
