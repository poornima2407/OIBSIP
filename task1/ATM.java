import java.util.Scanner;
public class ATM {

    public static void main(String args[]) {
        int balance = 40000, withdraw, deposit;
        Scanner sc = new Scanner(System.in);
        int pin = 1234;
        System.out.println("Please enter your pin number: ");
        int password = sc.nextInt();
        int i = 1;
        if (password != pin) {
            while (true) {
                i++;
                System.out.println("Wrong pin Number!! ");
                System.out.println("Please Re-enter your pin (Max. Attempts :- 3) : ");
                password = sc.nextInt();
                if (password == pin) {
                    break;
                }
                if (i == 3) {
                    // user will get only 3 max attempts to re-enter the pin number
                    System.out.println("You have exceeded your trials !!! Retry After some time !");
                    System.exit(0);
                }
            }
        }
        if (password == pin) {
            System.out.println("<*------Welcome to the ATM services------*>");
            while (true) {
                System.out.println("Enter 1 -> to Check your Balance amount");
                System.out.println("Enter 2 -> to Withdraw money");
                System.out.println("Enter 3 -> to Deposit money");
                System.out.println("Enter 4 -> to Transfer money");
                System.out.println("Enter 5 -> to QUIT");
                System.out.print("Choose one of the option: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Your Balance is : " + balance);
                        System.out.println("");
                        break;
                    case 2:
                        System.out.println("Enter the amount you want to Withdraw : ");
                        withdraw = sc.nextInt();
                        // checking if balance is less than withdrawal amount or is it zero!
                        if (withdraw > balance || balance == 0) {
                            System.out.printf("You have insufficient balance!!\n");
                            break;
                        }
                        System.out.println("Hope you collected your amount!");
                        balance = balance - withdraw;
                        System.out.println("");
                        break;
                    case 3:
                        System.out.print("Enter money to be deposited: ");
                        deposit = sc.nextInt();
                        balance = balance + deposit;
                        System.out.println("Your Money has been successfully deposited");
                        System.out.println(" ");
                        break;
                    case 4:
                        System.out.println("Enter the account number");
                        long account = sc.nextLong();
                        System.out.println("enter the amount to be transfer");
                        int amount = sc.nextInt();
                        System.out.println("Enter 1-> To confirm\nEnter 2-> To Stop");
                        int select=sc.nextInt();
                        if(select==1)
                        {

                            balance -= amount;
                            System.out.println("\"Amount Transferred Successfully \"");
                        }
                        else if(select==2)
                        {
                            System.out.println("transaction cancelled");
                        }

                        break;

                    case 5:
                        System.out.println("Thank you for using our ATM!");
                        System.exit(0);
                }
            }
        }
        sc.close();
    }

}
