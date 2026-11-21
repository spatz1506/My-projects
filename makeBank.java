import java.util.Scanner;

public class makeBank {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // info about user's account
        Account userAccount = new Account("user", "777777", "0070", 7200000.0);

        System.out.println("=== Welcome to the P&P Investment Bank ===");
        
        System.out.print("Please enter your Name: ");
        String name = input.nextLine();

        // check the user's name
        if (name.equalsIgnoreCase(userAccount.getName())) {
            System.out.println("\nHello, " + name + ".");
            
            System.out.print("Enter your account number: ");
            String accountNumber = input.nextLine();

            System.out.print("Enter your PIN: ");
            String pin = input.nextLine();

            // check credentials
            if (accountNumber.equals(userAccount.getAccountNumber()) && pin.equals(userAccount.getPin())) {
                System.out.println("\n[Success] Account Login Successful. Welcome " + userAccount.getName() + "!");
                System.out.println("\n==============================");
                System.out.println("CENTURION level VIP confirmed.");
                System.out.println("We are honored to do business with you.");

                // ------------------ [추가된 반복문 구역] ------------------
                boolean running = true; // 루프를 제어할 플래그 변수

                while (running) {
                    System.out.println("\n------------------------------");
                    System.out.println("Please Select Menu:");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Transfer");
                    System.out.println("4. Exit"); // 종료 옵션 추가
                    System.out.print("Choice: ");
                    
                    int choice = input.nextInt();

                    switch (choice) {
                        case 1:
                            // 잔액 조회
                            System.out.println("\n-> Current Balance: $" + userAccount.getBalance());
                            break;

                        case 2:
                            // 입금
                            System.out.print("\nEnter amount to deposit: $");
                            double depositAmount = input.nextDouble();
                            userAccount.deposit(depositAmount);
                            System.out.println("-> Updated Balance: $" + userAccount.getBalance());
                            break;

                        case 3:
                            // 송금
                            input.nextLine(); // 버퍼 비우기 (nextInt 이후 nextLine 사용 시 필요)
                            System.out.print("\nEnter recipient's account number: ");
                            String targetAccount = input.nextLine();

                            System.out.print("Enter amount to transfer: $");
                            double transferAmount = input.nextDouble();

                            userAccount.transfer(targetAccount, transferAmount);
                            System.out.println("-> Remaining Balance: $" + userAccount.getBalance());
                            break;

                        case 4:
                            // 프로그램 종료 선택 시
                            System.out.println("\nThank you for using P&P Investment Bank. Goodbye!");
                            running = false; // while 문을 탈출하도록 설정
                            break;

                        default:
                            System.out.println("\n[Error] Invalid option selected. Please try again.");
                            break;
                    }
                }
                // --------------------------------------------------------

            } else {
                System.out.println("\n[Error] Wrong Account Number or PIN!");
            }

        } else {
            System.out.println("\n[Error] User not found.");
        }

        input.close();
    }
}

class Account {
    private String name;
    private String accountNumber;
    private String pin;
    private double balance;

    public Account(String name, String accountNumber, String pin, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\n[Deposit] $" + amount + " has been added to your account.");
        } else {
            System.out.println("\n[Error] Deposit amount must be positive.");
        }
    }

    public void transfer(String targetAccount, double amount) {
        if (amount <= 0) {
            System.out.println("\n[Error] Transfer amount must be positive.");
        } else if (amount > balance) {
            System.out.println("\n[Error] Insufficient funds! Current balance: $" + balance);
        } else {
            balance -= amount;
            System.out.println("\n[Transfer] Successfully sent $" + amount + " to Account [" + targetAccount + "].");
        }
    }
}