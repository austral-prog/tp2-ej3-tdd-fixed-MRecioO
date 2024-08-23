package com.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.template.App.*;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void addAccountTest() {
        Map<String, Integer> accounts = add("Mati");
        assertEquals(0, accounts.get("Mati"));
    }

    @Test
    void depositValidAmountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Mati", 10);
        Map<String, Integer> updatedAccounts = deposit(accounts, "Mati", 5);
        assertEquals(15, updatedAccounts.get("Mati"));
    }

    @Test
    void depositNegativeAmountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Mati", 10);
        Map<String, Integer> updatedAccounts = deposit(accounts, "Mati", -5);
        assertEquals(10, updatedAccounts.get("Mati"));
    }

    @Test
    void depositToNonExistingAccountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        Map<String, Integer> updatedAccounts = deposit(accounts, "Mati", 10);
        assertNull(updatedAccounts.get("Mati"));
    }

    @Test
    void withdrawValidAmountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Mati", 10);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "Mati", 5);
        assertEquals(5, updatedAccounts.get("Mati"));
    }

    @Test
    void withdrawNegativeAmountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Mati", 10);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "Mati", -5);
        assertEquals(10, updatedAccounts.get("Mati"));
    }

    @Test
    void withdrawMoreThanBalanceTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Mati", 10);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "Mati", 15);
        assertEquals(10, updatedAccounts.get("Mati"));
    }

    @Test
    void withdrawFromNonExistingAccountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        Map<String, Integer> updatedAccounts = withdraw(accounts, "Mati", 5);
        assertNull(updatedAccounts.get("Mati"));
    }

    @Test
    void transferValidAmountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Mati", 10);
        accounts.put("Mase", 5);
        Map<String, Integer> updatedAccounts = transfer(accounts, "Mati", "Mase", 5);
        assertEquals(5, updatedAccounts.get("Mati"));
        assertEquals(10, updatedAccounts.get("Mase"));
    }

    @Test
    void transferNegativeAmountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Mati", 10);
        accounts.put("Mase", 5);
        Map<String, Integer> updatedAccounts = transfer(accounts, "Mati", "Mase", -5);
        assertEquals(10, updatedAccounts.get("Mati"));
        assertEquals(5, updatedAccounts.get("Mase"));
    }

    @Test
    void transferMoreThanBalanceTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Mati", 10);
        accounts.put("Mase", 5);
        Map<String, Integer> updatedAccounts = transfer(accounts, "Mati", "Mase", 15);
        assertEquals(10, updatedAccounts.get("Mati"));
        assertEquals(5, updatedAccounts.get("Mase"));
    }

    @Test
    void transferToSameAccountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Mati", 10);
        Map<String, Integer> updatedAccounts = transfer(accounts, "Mati", "Mati", 5);
        assertEquals(10, updatedAccounts.get("Mati"));
    }

    @Test
    void transferFromNonExistingAccountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Mase", 5);
        Map<String, Integer> updatedAccounts = transfer(accounts, "Mati", "Mase", 5);
        assertEquals(5, updatedAccounts.get("Mase"));
        assertNull(updatedAccounts.get("Mati"));
    }

    @Test
    void transferToNonExistingAccountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Mati", 10);
        Map<String, Integer> updatedAccounts = transfer(accounts, "Mati", "Mase", 5);
        assertEquals(10, updatedAccounts.get("Mati"));
        assertNull(updatedAccounts.get("Mase"));
    }

    @Test
    void transferBetweenNonExistingAccountsTest() {
        Map<String, Integer> accounts = new HashMap<>();
        Map<String, Integer> updatedAccounts = transfer(accounts, "Mati", "Mase", 5);
        assertNull(updatedAccounts.get("Mati"));
        assertNull(updatedAccounts.get("Mase"));
    }
}
