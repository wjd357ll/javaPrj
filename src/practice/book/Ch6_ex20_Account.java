package practice.book;

import java.util.Scanner;

public class Ch6_ex20_Account {

	private String accountNum;
	private String owner;
	private int balance;
	
	public Ch6_ex20_Account(){
		
		accountNum = null;
		balance = 0;
		owner = null;
	}
	
	Scanner scan = new Scanner(System.in);
	
	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void genAccount() {
		
		System.out.println("\n\t���¸� �����մϴ�. ");
		
		System.out.print("\n\t���� ��ȣ�� �Է��ϼ��� (�� : 000-000) : ");
		accountNum = scan.nextLine();
		
		System.out.print("\n\t�����ָ� �Է��ϼ��� (�� : ȫ�浿) : ");
		owner = scan.nextLine();
		
		System.out.print("\n\t�ʱ� �Աݾ��� �Է��ϼ��� (�� : 1000��) : ");
		balance = scan.nextInt();
		
		System.out.println("\n\n\t¦¦¦! ���°� �����Ǿ����ϴ�. ");
	}
	
}
