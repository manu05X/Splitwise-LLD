package com.manish.splitwise.repositories;

import com.manish.splitwise.models.Expense;
import com.manish.splitwise.models.Group;
import com.manish.splitwise.models.User;
import com.manish.splitwise.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense, Long> {
    List<UserExpense> findAllByUser(User user);

    List<UserExpense> findAllByExpenseIn(List<Expense> expenses);
}
