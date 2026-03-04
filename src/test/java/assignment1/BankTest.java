package assignment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void addAccount_shouldIncreaseTotalAssets() {
        Bank bank = new Bank();

        BankAccount acc1 = new BankAccount("1", "John", 100);
        BankAccount acc2 = new BankAccount("2", "Anna", 200);

        bank.addAccount(acc1);
        bank.addAccount(acc2);

        assertEquals(300, bank.getTotalAssets());
    }

    @Test
    void transfer_validAmount_shouldMoveMoney() {
        Bank bank = new Bank();

        BankAccount from = new BankAccount("1", "John", 500);
        BankAccount to = new BankAccount("2", "Anna", 0);

        bank.addAccount(from);
        bank.addAccount(to);

        bank.transfer(from, to, 100);

        assertEquals(400, from.getBalance());
        assertEquals(100, to.getBalance());
    }

    @Test
    void transfer_insufficientBalance_shouldThrowException() {
        Bank bank = new Bank();

        BankAccount from = new BankAccount("1", "John", 100);
        BankAccount to = new BankAccount("2", "Anna", 0);

        bank.addAccount(from);
        bank.addAccount(to);

        assertThrows(IllegalArgumentException.class,
                () -> bank.transfer(from, to, 200));
    }
}