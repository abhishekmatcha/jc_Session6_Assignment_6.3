import java.util.logging.Level;
import java.util.logging.Logger;

public class Function extends Thread implements Runnable {

private Person person;

public Function(Person p) {
    this.person = p;
}

public static void main(String[] args) {

    Function ts1 = new Function(new Person("aakash"));
    ts1.start();
    Function ts2 = new Function(new Person("lok"));
    ts2.start();
    Function ts3 = new Function(new Person("Nath"));
    ts3.start();

}

@Override
public void run() {
    for (int i = 0; i < 3; i++) {
        try {
            Bank_ acc = Bank_.getAccount(person);
            acc.withdraw(100);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Function.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (Bank_.getBal() < 0) {
                System.out.println("account is overdrawn!");
            }
            acc.deposit(200);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    System.out.println("Final Acc balance is Rs." + Bank_.getBal());
}}