package com.example.demo.servise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDAO;
import com.example.demo.entity.Account;

@Service
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public List<Account> getAllAccounts() {
        return accountDAO.findAll();
    }

    public void addAccount(Account account) {
        accountDAO.save(account);
    }

    public Account getAccountById(Long id) {
        return accountDAO.findById(id).orElseThrow(() -> new RuntimeException("Account ID is invalid"));
    }

    public void deleteAccountById(Long id) {
        Account account = accountDAO.findById(id).orElse(null);
        if (account != null) {
            accountDAO.deleteById(id);
        } else {
            throw new RuntimeException("Account ID is invalid");
        }
    }

    public Double getBalanceById(Long id) {
        return accountDAO.getBalanceById(id);
    }

    public void depositToAccountById(Long id, Double amount) {
        accountDAO.depositToAccountById(id, amount);
    }

    public void withdrawFromAccountById(Long id, Double amount) {
        accountDAO.withdrawFromAccountById(id, amount);
    }

}
