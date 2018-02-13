package com.lanu.user_front_online_banking.service;

import com.lanu.user_front_online_banking.domain.PrimaryAccount;
import com.lanu.user_front_online_banking.domain.PrimaryTransaction;
import com.lanu.user_front_online_banking.domain.SavingsAccount;
import com.lanu.user_front_online_banking.domain.SavingsTransaction;

import java.util.List;

public interface TransactionService {
    List<PrimaryTransaction> findPrimaryTransactionList(String username);

    List<SavingsTransaction> findSavingsTransactionList(String username);

    void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction);

    void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction);

    void savePrimaryWithdrawTransaction(PrimaryTransaction primaryTransaction);

    void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction);

    void betweenAccountsTransfer(String transferFrom, String transferTo, String amount, PrimaryAccount primaryAccount, SavingsAccount savingsAccount) throws Exception;

}
