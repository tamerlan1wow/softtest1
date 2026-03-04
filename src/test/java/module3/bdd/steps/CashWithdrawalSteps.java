package module3.bdd.steps;

import module3.bdd.Account;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CashWithdrawalSteps {
    private Account account = new Account();
    private double dispensedAmount;
    private final double DELTA = 0.001; // Tolerance for floating point math
    private String errorMessage;

    @Given("the account balance is ${double}")
    public void the_account_balance_is(Double initialBalance) {
        account.setBalance(initialBalance);
    }

    @When("the user withdraws ${double}")
    public void the_user_withdraws(Double amount) {
        account.withdraw(amount);
        this.dispensedAmount = amount;
    }

    /*@When("the user withdraws ${double}")
    public void the_user_withdraws(Double amount) {
        try {
            // This might succeed or throw an exception
            account.withdraw(amount);
            this.dispensedAmount = amount;
            this.errorMessage = null; // Reset error message if it succeeds
        } catch (IllegalArgumentException e) {
            // Store the error message to check in the "Then" step later
            this.errorMessage = e.getMessage();
            this.dispensedAmount = 0; // Nothing was dispensed
        }
    }*/

    @Then("the ATM should dispense ${double}")
    public void the_atm_should_dispense(Double expectedDispensed) {
        assertEquals(expectedDispensed, dispensedAmount, DELTA);
    }

    @Then("the new account balance should be ${double}")
    public void the_new_account_balance_should_be(Double expectedBalance) {
        assertEquals(expectedBalance, account.getBalance(), DELTA);
    }



   /* @Then("the ATM should show an error {string}")
    public void the_atm_should_show_an_error(String expectedError) {
        assertNotNull(errorMessage, "An error was expected but none occurred.");
        assertEquals(expectedError, errorMessage);
    }

    @Then("the account balance should still be ${double}")
    public void the_account_balance_should_still_be(Double expectedBalance) {
        assertEquals(expectedBalance, account.getBalance(), DELTA);
    }
*/
}

