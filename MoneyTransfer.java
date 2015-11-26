import java.util.Scanner;

public class MoneyTransfer 
{
	public static void main(String[] args)
	{	
		Scanner keyboard = new Scanner(System.in);
		Account alex = new Account();
		Account rachael = new Account();
		double totalTransfer;

		System.out.print("How many riyals are in Alex's QNB account? ");
		alex.setbalance(keyboard.nextDouble());
		
		System.out.print("How many riyals would you like to leave in Alex's account? ");
		alex.setkeep(keyboard.nextDouble());
		
		System.out.print("How many riyals are in Rachael's QNB account? ");
		rachael.setbalance(keyboard.nextDouble());
		
		System.out.print("How many riyals would you like to leave in Rachael's account? ");
		rachael.setkeep(keyboard.nextDouble());
		
		System.out.println("\nWe'll transfer " + Math.round(alex.gettransfer()) + " QR from Alex's account and " + Math.round(rachael.gettransfer()) + " QR from Rachael's account.\n");
		System.out.println("TASKS:\n");
		System.out.println("Transfer " + Math.round(rachael.gettransfer()) + " QR from Rachael's account to Alex's account.");
		
		totalTransfer = rachael.gettransfer() + alex.gettransfer();
		
		System.out.println("Transfer " + Math.round(totalTransfer) + " QR (" + Math.round(alex.riyalsToDollars(totalTransfer)) + " USD) from Alex's account to the United States.\n");
	}
}

class Account
{
	// Instance variables

	private double balance; // requires setter
	private double keep; // requires setter
	private double transfer; // requires getter

	// Setters
	
	public void setbalance(double b)
	{
		balance = b;
	}
	
	public void setkeep(double k)
	{
		if (k < balance)
		{
			keep = k;
		}
		else
		{
			throw new IllegalArgumentException("There isn't that much money in the account.");
		}
	}
	
	// Getters

	public double gettransfer()
	{
		transfer = balance - keep;
		return transfer;
	}

	// General methods
	
	public double dollarsToRiyals(double d)
	{
		double riyals;
		
		riyals = d * 3.6409;
		
		return riyals;
	}
	
	public double riyalsToDollars(double r)
	{
		double dollars;
		
		dollars = r * 0.2747;
		
		return dollars;
	}
}