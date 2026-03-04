Feature: ATM Cash Withdrawal
  As a bank customer
  I want to withdraw cash from the ATM
  So that I can have physical money

  Scenario: Successful withdrawal from an account with sufficient balance
    Given the account balance is $100
    When the user withdraws $20
    Then the ATM should dispense $20
    And the new account balance should be $80

#  Scenario: Failed withdrawal due to low balance
#    Given the account balance is $10
#    When the user withdraws $50
#    Then the ATM should show an error "Insufficient balance"
#    And the account balance should still be $10
