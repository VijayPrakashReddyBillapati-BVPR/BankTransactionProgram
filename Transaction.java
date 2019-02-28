package bank;

public class Transaction {
	CustomerDetails bank=new CustomerDetails();
	
	public  void withDraw(float bal)
	{
		System.out.println("current Balance= "+bank.getBalance());
		float bankBalance=bank.getBalance();
		System.out.println("withdraw balance= " +bal);
		if(bankBalance<bal)
		{
			System.out.println("Transaction can't be done");
		}
		else {
			bankBalance-=bal;
			bank.setBalance(bankBalance);
			System.out.println(bank.getBalance());
		}
	}
	
	public void deposit(float bal)
	{
		float bankBalance=bank.getBalance();
		bankBalance+=bal;
		bank.setBalance(bankBalance);
		System.out.println("current Balance= "+bank.getBalance());
		
		
	}
	
	  

}
