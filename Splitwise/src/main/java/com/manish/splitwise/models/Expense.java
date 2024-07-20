package com.manish.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // for data to be saved in DB to denote that its a class
public class Expense extends BaseModel {
    private int amount;
    private String description;
    //enum is denoted bt Enumerated and ORDINAL make listing of value in enum as 1,2,3,.....
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @ManyToOne
    private User createdBy;
    @ManyToOne
    private Group groups;

}
