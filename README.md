# Instapay System

Instapay System is a Java-based application that simulates a payment system. It allows users to register, login, inquire about their balance, pay bills, and transfer money between different types of accounts such as bank accounts and wallets. The application follows a microservices architecture, where each service is responsible for a specific functionality and can operate independently.

## Microservices Architecture

The application is divided into several services, each responsible for a specific functionality. These services include:
- Registration Service: Handles user registration.
- Login Service: Handles user login.
- Payment Services: Handles bill payments.
- Transaction Service: Handles transfers between accounts.
  
Each service is encapsulated in its own package and exposes an interface for other services or controllers to use. This design allows for high cohesion and low coupling, making the application easier to maintain and scale.

## Classes

### Main Classes

- `Main`: The entry point of the application. It creates an instance of `InstapayApplication` and starts the application.
- `InstapayApplication`: Controls the flow of the application. It handles user registration, login, and redirects to the main menu.
- `MainMenuController`: Handles the main menu display and user choices.

### User and Account Classes

- `User`: Represents a user in the system with properties such as username, password, and associated account.
- `Account`: An abstract class that represents a user's account. It has two subclasses, `BankAccount` and `WalletAccount`.
- `BankAccount`: Represents a bank account in the system.
- `WalletAccount`: Represents a wallet account in the system.

### Registration Service Classes
- `AccountRegistration`: interface class that handles user registration.
  - `BankRegistration`: A class that inherits from `AccountRegistration` interface and provides implementation for registering a bank account.
  - `WalletRegistration`: A class that inherits from `AccountRegistration` interface and provides implementation for registering a wallet account.
- It uses the `RegistrationFactory`  to create a registration instance based on the user's choice (Bank or Wallet)

### Login Service Classes
- `AccountAuthentication`: interface class that handles user authentication.
  - `BankAuthentication`: A class that inherits from `AccountAuthentication` interface and provides implementation for authenticating a bank account.
  - `WalletAuthentication`: A class that inherits from `AccountAuthentication` interface and provides implementation for authenticating a wallet account.
- It uses the `AuthenticationFactory` to create an authentication instance based on the user's choice (Bank or Wallet).

### Payment Service Classes
- `AccountPayment`: interface class that handles user payments.
  - `BankPayment`: A class that inherits from `AccountPayment` interface and provides implementation for processing payments from a bank account.
  - `WalletPayment`: A class that inherits from `AccountPayment` interface and provides implementation for processing payments from a wallet account.
- It uses the `PaymentFactory` to create a payment instance based on the user's choice (Bank or Wallet).

### Transaction Service Classes
- `AccountTransaction`: interface class that handles user transactions.
  - `BankTransaction`: A class that inherits from `AccountTransaction` interface and provides implementation for processing transactions from a bank account.
  - `WalletTransaction`: A class that inherits from `AccountTransaction` interface and provides implementation for processing transactions from a wallet account.
- It uses the `TransactionFactory` to create a transaction instance based on the user's choice (Bank or Wallet).

### Provider Classes

- `IProvider`: An interface for account providers. It has two subclasses, `BankProvider` and `WalletProvider`.
- `BankProvider`: An abstract class that represents a bank provider. It has two concrete classes, `CIBProvider` and `QNBProvider`.
- `WalletProvider`: An abstract class that represents a wallet provider. It has two concrete classes, `VodafoneProvider` and `FawryProvider`.

### Utility Classes

- `InstapayUtilites`: Contains utility methods used across the application.

### Database Classes

- `DataManager`: Handles data storage and retrieval.

## How to Run

1. Clone the repository to your local machine using `git clone https://github.com/AbdelrhmanReda17/Instapay-System/`.
2. Navigate to the project directory using `cd Instapay-System`.
3. Run the application by executing the `Main` class. The application will guide you through the registration or login process, and then you will be able to access the main menu to perform various operations.

## License

This project is licensed under the MIT License.
