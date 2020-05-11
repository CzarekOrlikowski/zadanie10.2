public class CashMachine {
    public static void main(String[] args) {

        Person person1 = new Person("jan", "kowalski", "1234");
        Person person2 = new Person("adam", "nowak", "5678");

        try {
            BankAccount account1 = new BankAccount(person1, 1000);
            BankAccount account2 = new BankAccount(person2, 500);
            System.out.println(account1.printInfo());
            System.out.println(account2.printInfo());

            account1.deposit(100);
            account2.deposit(100);
            System.out.println(account1.printInfo());
            System.out.println(account2.printInfo());

            account1.withdraw(500);
            account2.withdraw(1000);
            System.out.println(account1.printInfo());
            System.out.println(account2.printInfo());

        } catch (NullPointerException e) {
            System.err.println(e.getMessage());

        } catch (NoFundsException e){
            System.err.println(e.getMessage());

        } catch (NotAllowedTransactionException e) {
            System.err.println(e.getMessage());

        }
    }
}
