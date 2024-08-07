package com.manish.splitwise.dtos;

import com.manish.splitwise.strategies.settleupstrategy.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    private String message;
    private String status;
    private List<Transaction> transactions;
}
