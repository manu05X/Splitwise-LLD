package com.manish.splitwise.controllers;

import com.manish.splitwise.dtos.SettleUpGroupRequestDto;
import com.manish.splitwise.dtos.SettleUpGroupResponseDto;
import com.manish.splitwise.dtos.SettleUpUserRequestDto;
import com.manish.splitwise.dtos.SettleUpUserResponseDto;
import com.manish.splitwise.services.ExpenseService;
import com.manish.splitwise.strategies.settleupstrategy.Transaction;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ExpenseController {
    private ExpenseService expenseService;


    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto request) {
        List<Transaction> transactions = expenseService
                .settleUpUser(request.getUserId());


        SettleUpUserResponseDto response = new SettleUpUserResponseDto();
        response.setStatus("SUCCESS");
        response.setTransactions(transactions);

        return response;
    }

    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto request) {
        return null;
    }
}
