package bank;

import java.io.Serializable;

public class CustomerDetails implements Serializable {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	String firstName;
	String lastName;
	String password;
	String address;
	long phoneNumber;
	long aadharNumber;
	long accountNo;
	float balance=0;
	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	

	public void setBalance(float balances) {
		balance =balance+ balances;
	}
	public float getBalance() {
		return balance;
	}
}
