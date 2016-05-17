package practice.book;

import java.util.Scanner;

public class Ch6_ex20_BankApplication {

	private static String inputaccountNum; // ����ڰ� ���� ���¸� ã�� �� �Է��ϴ� ���¹�ȣ 
	
	private static int money;
	private static int index;
	private static int current;
	private static int end;
	private static Ch6_ex20_Account[] accounts;
	
	static{
		money = 0;
		index = -1;
		current = -1;
		end = 0;
		accounts = new Ch6_ex20_Account[100];
	}
	
	public static void main(String[] args) {
		
		endProgram :
		while(true)
		{
			Ch6_ex20_Account account = new Ch6_ex20_Account();
			
			switch(inputMainMenu())
			{
			case 1: // ���»���
				account.genAccount();
				add(account);
				break;
				
			case 2: // ���¸��
				listAccount();
				break;
				
			case 3: // ����
				saveMoney();
				break;
				
			case 4: // ���
				withdrawMoney();
				break;
				
			case 5: // ����
				System.out.println("\n\t���°��� ���α׷��� �����մϴ�.");
				break endProgram;
				
			default :
				System.out.println("\n\t�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");	
			}
		}

	}

	private static int inputMainMenu() {

		Scanner scan = new Scanner(System.in);
		System.out.println("-----------------------------------------------------------");
		System.out.println("\n\t\t\t\t\t���� ���� ���α׷�");		
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("\n\t1.���»���  ��  2.���¸��  ��  3.����  ��  4.���  ��  5.����");
		System.out.println("\n-----------------------------------------------------------");

		System.out.print("\n\t���Ͻô� �޴��� �Է��ϼ���(1-5) : ");
		int menu = scan.nextInt();
		System.out.println("\n\n-----------------------------------------------------------");
		
		return menu;
	}	
	
	public static void add(Ch6_ex20_Account account){
		
		current += 1;
		
		accounts[current] = account;
		
	}
	
	public static void listAccount() {

		System.out.println("\n\t���� ����� �ҷ��ɴϴ�.");
		
		for(int i=0; i<current+1; i++){
			System.out.printf("\n\t%s\t%s\t%d", accounts[i].getAccountNum(), accounts[i].getOwner(), accounts[i].getBalance());
			System.out.println();
		}
	}
	
	public static void withdrawMoney() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n\t��� �޴��� �����ϼ̽��ϴ�. ");
		
		System.out.print("\n\t���� ��ȣ�� �Է��ϼ��� (�� : 000-000) : ");
		inputaccountNum = scan.nextLine();
		
		if(findAccount()==1)
			return;
		
		System.out.printf("\n\t���� ���� ������ �ܾ��� %d �� �Դϴ�. ", accounts[index].getBalance());
		
		System.out.print("\n\t��ݾ��� �Է��ϼ��� (�� : 1000) : ");
		money = scan.nextInt();
		
		withdrawing();
		
		System.out.printf("\n\t%s ������ ���¿��� %d ���� ��� �Ǿ����ϴ�. �̿����ּż� �����մϴ�.", accounts[index].getOwner(), money);
		
		System.out.println();
	}
	
	private static void withdrawing() {
		
		int temp;
		
		temp = accounts[index].getBalance();
		
		temp -= money;
		
		accounts[index].setBalance(temp);
		
	}

	public static void saveMoney() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n\t���� �޴��� �����ϼ̽��ϴ�. ");
		
		System.out.print("\n\t���� ��ȣ�� �Է��ϼ��� (�� : 000-000) : ");
		inputaccountNum = scan.nextLine();
		
		if(findAccount()==1)
			return;
		
		System.out.print("\n\t���ݾ��� �Է��ϼ��� (�� : 1000) : ");
		money = scan.nextInt();
		
		saving(); // ���� �ܾ׿� ���ݾ� �߰�
		
		System.out.printf("\n\t%s ������ ���¿� %d ���� ���� �Ǿ����ϴ�. �̿����ּż� �����մϴ�.", accounts[index].getOwner(), money);
		
		System.out.println();
	}

	private static int findAccount() {
		
		end = 0;
		
		for(int i=0; i<current+1; i++)
			if(inputaccountNum.equals(accounts[i].getAccountNum())) {
				index =  i;
				System.out.printf("\n\t%s ������ �����Դϴ�.\n", accounts[i].getOwner());
				return 0;
			}	
		System.out.println("\n\t�������� �ʴ� ���¹�ȣ �Դϴ�. ���¸� �������ּ���.");	
		end = 1;

		return end;
	}
	
	private static void saving() {
		
		int temp;
		
		temp = accounts[index].getBalance();
		
		temp += money;
		
		accounts[index].setBalance(temp);
	}

}
