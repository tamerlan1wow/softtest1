package assignment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void constructor_validBalance_initializesCorrectly() {
        BankAccount account = new BankAccount("1", "John", 100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void constructor_negativeBalance_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount("1", "John", -10));
    }

    @Test
    void deposit_validAmount_increasesBalance() {
        BankAccount account = new BankAccount("1", "John", 100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void deposit_zero_throwsException() {
        BankAccount account = new BankAccount("1", "John", 100);
        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(0));
    }

    @Test
    void withdraw_validAmount_reducesBalance() {
        BankAccount account = new BankAccount("1", "John", 100);
        account.withdraw(40);
        assertEquals(60, account.getBalance());
    }

    @Test
    void withdraw_equalBalance_succeeds() {
        BankAccount account = new BankAccount("1", "John", 100);
        account.withdraw(100);
        assertEquals(0, account.getBalance());
    }

    @Test
    void withdraw_exceedingBalance_throwsException() {
        BankAccount account = new BankAccount("1", "John", 100);
        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(200));
    }
}