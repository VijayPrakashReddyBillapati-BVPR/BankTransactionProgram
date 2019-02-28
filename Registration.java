package bank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Registration {
	static ArrayList<CustomerDetails> arraylist=new ArrayList<CustomerDetails>();
	static ArrayList<CustomerDetails> arraylist1=new ArrayList<CustomerDetails>();
	static long num;
	static  boolean flag=true;
	CustomerDetails bank=new CustomerDetails();
	static Scanner scan=new Scanner(System.in);
	public void registration() throws ClassNotFoundException, IOException
	{
		
		long adhar=bank.getAadharNumber();
		//boolean verify=deSerialize(adhar);
		
		Random random=new Random();
		long accountNo=random.nextLong();
		bank.setAccountNo(accountNo);
		System.out.println("ENTER FIRSTNAME");
		bank.setFirstName(scan.next());
		System.out.println("ENTER LASTNAME");
		bank.setLastName(scan.next());
		System.out.println("set password");
		bank.setPassword(scan.next()); 
		System.out.println("enter phone number");
		bank.setPhoneNumber(scan.nextLong());
		System.out.println("enter aadhar number");
		bank.setAadharNumber(scan.nextLong());
		System.out.println("enter address");
		bank.setAddress(scan.next());
		//if(verify) {
		arraylist.add(bank);
		serialization();
		System.out.println(bank.getAccountNo());
		login();
		//}
		//else {
			
		//	login();
		//}
		
		
	}
	public  void serialization() throws IOException
	{
		FileOutputStream fileoutput=new FileOutputStream("/home/vijayprakash/eclipse-workspace/BankingTransactions/registratiion.txt");
		ObjectOutputStream objectoutput = new ObjectOutputStream(fileoutput);
		objectoutput.writeObject(arraylist);
	}
	
/*	public  boolean  deSerialize(long number) throws IOException, ClassNotFoundException
	{
		num=number;
		
		FileInputStream fileinput=new FileInputStream("/home/vijayprakash/eclipse-workspace/BankingTransactions/registratiion.txt");
		ObjectInputStream objectinput = new ObjectInputStream(fileinput);
		arraylist1=(ArrayList<CustomerDetails>)objectinput.readObject();
		
		
		for(CustomerDetails obj:arraylist1)
		{
			long aadhar =obj.getAadharNumber();
			if(num==aadhar)
				flag=false;
				
		}
		 fileinput.close();
		 objectinput.close();
		 return flag;
		
		 
	} */
	
	public   void  deSerialize(String userEnteredPassword ,long UserEnteredAadhar) throws IOException, ClassNotFoundException
	{
		FileInputStream fileinput=new FileInputStream("/home/vijayprakash/eclipse-workspace/BankingTransactions/registratiion.txt");
		ObjectInputStream objectinput = new ObjectInputStream(fileinput);
		arraylist1=(ArrayList<CustomerDetails>)objectinput.readObject();
		
		
		for(CustomerDetails obj:arraylist1)
		{
			System.out.println(obj.getAadharNumber()+" "+obj.getPassword()+" "+userEnteredPassword+" "+UserEnteredAadhar);
			if(userEnteredPassword.equalsIgnoreCase(obj.getPassword())||UserEnteredAadhar==obj.getAadharNumber())
			{
				transaction();
		}
			else {
				System.out.println("wrong details");
			}
			
		 fileinput.close();
		 objectinput.close();
		}
		
		 
	}
	
	public void transaction() {
		
		Transaction transaction= new Transaction();
		System.out.println(" 1: withDraw()"+"\n" +"2: deposit()"+"\n" + " 3: exit");
		Integer option=scan.nextInt();
		switch(option) {
		case 1: float withdraw =scan.nextFloat();
				transaction.withDraw(withdraw);
				transaction();
				break;
		case 2: float deposit =scan.nextFloat();
				transaction.deposit(deposit);
				transaction();
				break;
		case 3: System.exit(0);
		break;
	}
	}
	
	public void login() throws ClassNotFoundException, IOException
	{
		String userEnteredPassword=scan.next();
		long UserEnteredAadhar=scan.nextLong();
		deSerialize(userEnteredPassword ,UserEnteredAadhar);
	}
	
	public static void main(String [] args) throws ClassNotFoundException, IOException
	{
		Registration register = new Registration();
		System.out.println("select one option to provceed"+"\n"+"1: registration()"+"\n" +"2:login()"+"\n");
		Integer option=scan.nextInt();
		switch(option) {
		case 1: register.registration() ;
				break;
		case 2: register.login();
				break;
		
	}
		
		
		
	}
	

}
