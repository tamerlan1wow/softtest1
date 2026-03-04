package assignment1;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class BankParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "50.0,150.0",
            "100.0,200.0",
            "0.01,100.01"
    })
    void deposit_validAmounts(double amount, double expected) {
        BankAccount account = new BankAccount("1", "John", 100);
        account.deposit(amount);
        assertEquals(expected, account.getBalance());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.0, -100.5})
    void deposit_invalidAmounts(double amount) {
        BankAccount account = new BankAccount("1", "John", 100);
        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(amount));
    }
}