package com.manish.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
// this is a mapping class to representing relation so relation between a mapping class and the class
//involved in mapping is always  @ManyToOne
public class UserExpense extends BaseModel {
    @ManyToOne
    private User user;
    @ManyToOne
    private Expense expense;

    @Enumerated(EnumType.ORDINAL)
    private UserExpenseType userExpenseType;
    private int amount;
}
