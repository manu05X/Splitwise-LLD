package com.manish.splitwise.repositories;

import com.manish.splitwise.models.Expense;
import com.manish.splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findAllByGroups(Group group);
}
