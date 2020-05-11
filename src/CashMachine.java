public class CashMachine {
    public static void main(String[] args) {

        Person person1 = new Person("jan", "kowalski", "1234");
        Person person2 = new Person("adam", "nowak", "5678");

        try {
            BankAccount account1 = new BankAccount(person1, 1000);
            BankAccount account2 = new BankAccount(person2, 2000);

            account1.withdraw(500);
            account2.withdraw(3000);

        } catch (NullPointerException e) {
            System.err.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
