import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class CashMachine {
    public static void main(String[] args) throws NoFundsException, NotAllowedTransactionException {

        Person person1 = new Person("jan", "kowalski", "1234");
        Person person2 = new Person("adam", "nowak", "5678");

        BankAccount[] accounts = new BankAccount[2];

        try {
            accounts[0] = new BankAccount(person1, 1000);
            accounts[1] = new BankAccount(person2, 500);
            System.out.println(accounts[0].printInfo());
            System.out.println(accounts[1].printInfo());
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }

        Scanner scan = new Scanner(System.in);
        int accountNumber;
        int input;
        System.out.print("Wybierz rachunek (1 do " + accounts.length + "): ");
        accountNumber = scan.nextInt();

        try {

            do {
                System.out.print("Wybierz opcję: wpłata (1), wypłata (2), koniec (3): ");
                input = scan.nextInt();
                switch (input) {
                    case 1:
                        System.out.print("Podaj kwotę wpłaty: ");
                        double amount = scan.nextDouble();
                        accounts[accountNumber - 1].deposit(amount);
                        break;
                    case 2:
                        System.out.print("Podaj kwotę wypłaty: ");
                        amount = scan.nextDouble();
                        accounts[accountNumber - 1].withdraw(amount);
                        break;
                    default:
                        break;
                }
            } while (input != 3);
        } catch (NoFundsException e) {
            System.err.println(e.getMessage());

        } catch (NotAllowedTransactionException e) {
            System.err.println(e.getMessage());

        }
    }
}
