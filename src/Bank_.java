


	public class Bank_ {
		public static Bank_ account;
		private static int balance = 1000;
		private static Person person;

		private Bank_() {
		}

		public static Bank_ getAccount(Person p) {
		    if (account == null) {
		        account = new Bank_();
		    }
		    Bank_.person = p;
		    return account;
		}

		public static int getBal() {
		    return balance;
		}

		public synchronized void withdraw(int bal) {
		    try {

		        if (balance >= bal) {
		            System.out.println(person.getName() + " " + "is tring to withdraw");
		            try {
		                Thread.sleep(100);
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		            balance = balance - bal;
		            System.out.println(person.getName() + " " + " completes the withdraw procedure");
		        } else {
		            System.out.println(person.getName() + " " + "doesn't have enough money for withdraw ");
		        }
		        System.out.println(person.getName() + " " + " withdraw Rs." + balance);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

		public synchronized void deposit(int bal) {
		    try {
		        if (bal > 0) {
		            System.out.println(person.getName() + " " + " is trying to deposit");
		            try {
		                Thread.sleep(100);
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		            balance = balance + bal;
		            System.out.println(person.getName() + " " + "has deposited the money");
		        } else {
		            System.out.println(person.getName() + " " + "doesn't have enough money for deposit");
		        }
		        System.out.println(person.getName() + " " + " deposit Rs." + balance);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}}