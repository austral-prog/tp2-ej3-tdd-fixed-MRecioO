package com.template;

import java.util.LinkedHashMap;
import java.util.Map;

public class App {

    public static Map<String, Integer> accounts = new LinkedHashMap<>();

    public static Map<String, Integer> add(String account) {
        accounts.put(account, 0);
        return accounts;
    }

    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {
        if (accounts.containsKey(account) && amount > 0) {
            int currentBalance = accounts.get(account);
            accounts.put(account, currentBalance + amount);
        }return accounts;
    }

    public static Map<String, Integer> withdraw(Map<String, Integer> accounts, String account, int amount) {
        if (accounts.containsKey(account) && amount > 0) {
            int currentBalance = accounts.get(account);
            if (currentBalance >= amount) {
                accounts.put(account, currentBalance - amount);
            }
        }return accounts;
    }

    public static Map<String, Integer> transfer(Map<String, Integer> accounts, String fromAccount, String toAccount, int amount) {
        if (accounts.containsKey(fromAccount) && accounts.containsKey(toAccount) && !fromAccount.equals(toAccount) && amount > 0) {
            int fromBalance = accounts.get(fromAccount);
            if (fromBalance >= amount) {
                int toBalance = accounts.get(toAccount);
                accounts.put(fromAccount, fromBalance - amount);
                accounts.put(toAccount, toBalance + amount);
            }
        }return accounts;
    }
}
