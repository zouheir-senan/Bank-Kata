# Bank Kata Solution

## Overview
This is a simple bank account program that allows users to:
- Make deposits
- Make withdrawals
- Print account statements

## Project Structure
```
src/
├── main/
│   └── java/
│       └── bank/
│           └── service/
│               ├── Account.java         (Main account implementation)
│               ├── AccountService.java  (Interface defining account operations)
│               ├── Statement.java       (Handles statement formatting)
│               └── Transaction.java     (Data model for transactions)
└── test/
    └── java/
        └── bank/
            └── service/
                └── AccountTest.java     (Test cases)
```

## How to Use

### 1. Create an Account
```java
Statement statement = new Statement();
Account account = new Account(statement);
```

### 2. Make Transactions
```java
// Deposit money
account.deposit(1000);    // Adds 1000 to balance

// Withdraw money
account.withdraw(500);    // Removes 500 from balance
```

### 3. Print Statement
```java
account.printStatement();
```

Statement output format:
```
Date       || Amount || Balance
14/01/2012 || -500   || 2500
13/01/2012 || 2000   || 3000
10/01/2012 || 1000   || 1000
```

## Features
- Tracks all deposits and withdrawals with dates
- Prevents negative deposits and withdrawals
- Prevents withdrawals larger than current balance
- Prints statement in reverse chronological order

## Error Handling
The system will throw `IllegalArgumentException` when:
- Trying to deposit zero or negative amounts
- Trying to withdraw zero or negative amounts
- Trying to withdraw more than the current balance

## Testing
Run `AccountTest` in the test directory to verify the system works correctly. The test demonstrates the acceptance criteria with a full transaction sequence.