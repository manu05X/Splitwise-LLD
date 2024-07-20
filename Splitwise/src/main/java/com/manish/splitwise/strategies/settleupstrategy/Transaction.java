package com.manish.splitwise.strategies.settleupstrategy;

import com.manish.splitwise.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private User from;
    private User to;
    private Integer amount;
}
