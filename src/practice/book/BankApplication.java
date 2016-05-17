package practice.book;

import java.util.Scanner;

public class BankApplication {
	
	private static Account[] accounts = new Account[100];
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		boolean run = true;
		while(run) {
			
			System.out.println("-----------------------------------------------------------");
			System.out.println("\n\t\t\t\t\t���� ���� ���α׷�");		
			System.out.println("\n-----------------------------------------------------------");
			System.out.println("\n\t1.���»���  ��  2.���¸��  ��  3.����  ��  4.���  ��  5.����");
			System.out.println("\n-----------------------------------------------------------");

			System.out.print("\n\t���Ͻô� �޴��� �Է��ϼ���(1-5) : ");
			int menu = scan.nextInt();
			System.out.println("\n\n-----------------------------------------------------------");
			
			switch(menu)
			{
			case 1: // ���»���
				createAccount();
				break;
				
			case 2: // ���¸��
				accountList();
				break;
				
			case 3: // ����
				deposit();
				break;
				
			case 4: // ���
				withdraw();
				break;
				
			case 5: // ����
				System.out.println("\n\t���°��� ���α׷��� �����մϴ�.");
				run = false;
				
			default :
				System.out.println("\n\t�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");	
			}
		}
		
		

	}

	private static void withdraw() {
		// TODO Auto-generated method stub
		
	}

	private static void deposit() {
		
/*		System.out.println("\n\t���� �޴��� �����ϼ̽��ϴ�. ");
		
		System.out.print("\n\t���� ��ȣ�� �Է��ϼ��� (�� : 000-000) : ");
		String ano = scan.nextLine();
		
		System.out.print("\n\t���ݾ��� �Է��ϼ��� (�� : 1000) : ");
		int money = scan.nextInt();
		
		Account account = findAccount(ano);
		
		if(account == null) {
			System.out.println("\n\t��� : ���°� �����ϴ�.");
			return;
		}
		account.setBalance(account.getBalance() + money);*/
		
	}

	private static void accountList() {
		
		System.out.println("\n\t���� ����� �ҷ��ɴϴ�.");
		
		for(int i=0; i<accounts.length; i++){
			Account account = accounts[i];
			
			if(account != null) {
				System.out.print(account.getAno());
				System.out.print("\t");
				
				System.out.print(account.getOwner());
				System.out.print("\t");
				
				System.out.print(account.getBalance());
				System.out.println();
			}
		}	
	}

	private static void createAccount() {
		
		System.out.println("\n\t���¸� �����մϴ�. ");
		
		System.out.print("\n\t���� ��ȣ�� �Է��ϼ��� (�� : 000-000) : ");
		String ano = scan.nextLine();
		
		System.out.print("\n\t�����ָ� �Է��ϼ��� (�� : ȫ�浿) : ");
		String owner = scan.nextLine();
		
		System.out.print("\n\t�ʱ� �Աݾ��� �Է��ϼ��� (�� : 1000��) : ");
		int balance = scan.nextInt();
		
		Account newAccount = new Account(ano, owner, balance);
		
		for(int i=0; i<accounts.length; i++) {
			if(accounts[i] == null) {
				accounts[i] = newAccount;
				
				System.out.println("\n\n\t¦¦¦! ���°� �����Ǿ����ϴ�. ");
				break;
			}
		}
	}
}
