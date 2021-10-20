# Dollars Bank

Application Type: Console App
User Interface: Menu based with multicolor

An MVC banking application with a user login system.
Users are allowed to join the bank and login with their own credentials.

Guest users can:
- Create an account
- Login to an account

After logging in, users can:
- Deposit money into their account
- Withdraw money from their account
- Transfer money to another user's account
- View their 5 most recent transactions
- View their own information

## Future Implementations
Some features or changes that can be done in order to make the application better:
- ~~Saving the customers and their accounts to a file to keep the data~~ (Merged: 10/20/2021)
    - Alternatively, can use JDBC and DAOs to connect to a database which will store the information
- Allow users to have another account (savings account) that they can perform the same operations on
    - Customers can decide which account they would like to deposit/transfer to or withdraw from
- Update user information
    - Allow to change email, phone number, username, password, etc.
- Masking the password