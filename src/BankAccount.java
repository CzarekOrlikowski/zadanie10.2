public class BankAccount {
    private Person person;
    private double balance;

    public BankAccount(Person person, double balance) {
        if (person == null) {
            throw new NullPointerException("Konto musi posiadać właściciela!");
        } else {
            this.person = person;
            this.balance = balance;
        }
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Zbyt duża kwota. Dostępne środki to: " + balance);
        } else {
            this.balance -= amount;
        }
    }

    public String printInfo() {
        return "Dane rachunku" + "\n" +
                "właścciel:" + person.getFirstName() + ", " + person.getLastName() + ", " + person.getPesel() + "\n" +
                "stan środków: " + balance + "\n";
    }
}
