import java.util.Scanner;

public class TeamHomework {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int menu = 0;
		char small;
		int big;
		
		Alpha :
		while(true)
		{
			System.out.println("\n\t\t����������������������������������������������");
			System.out.println("\t\t��          Ư���� ���ĺ� ���� ���α׷�           ��");
			System.out.println("\t\t����������������������������������������������");
			System.out.println("\n\t �ҹ��ڸ� �Է¹޾� �빮�ڷ� ��ȯ �� �Է¹��� ���ں��� Z����, \n\t �ٽ� �� ���ڱ��� ����ϴ� ���α׷� �Դϴ�.");
			System.out.println("\n\t1. ����");
			System.out.println("\t2. ����");
			
			System.out.print("\n\t���ϴ� �޴��� �Է��ϼ��� : ");
			menu = scan.nextInt();
			System.out.println();
			
			switch(menu)
			{
				case 1:
				{
					while(true)
					{
						System.out.print("\n\t�ҹ��ڸ� �Է��ϼ��� : ");
						small = scan.next().charAt(0); //charAt(0) : �Է¹��� ���ڿ�(string)���� 0��° ����(ó�� ����)�� +������ �����ϵ��� char������ ��ȯ
					
						if('a'<=small && small<='z')
							break;
						
						System.out.println("\n\t�߸� �Է��ϼ̽��ϴ�.");
					}
					
					big = (small-('z'-'Z'));
					
					System.out.println("\n\t�Է��Ͻ� �ҹ��ڴ� " + small + " �Դϴ�.");
					System.out.printf("\n\t�빮�ڷδ� %c �Դϴ�.", big);
					System.out.println("\n\n\t< �� �� >\n"); 
					
					int cnt = 'Z'-big+1;
					
					cnt *= 2;
					
					for(int i=0; i<cnt; i++)
					{
						if(i != 0 && i%(cnt/2)==0)
							continue;
						
						System.out.printf("%c", (i<cnt/2) ? (big + i) : ('Z'- i%(cnt/2)));
					}
					System.out.println();
				}
				break;
				
				case 2:
					System.out.println("\t���α׷��� �����մϴ�.");
					
					break Alpha;
				
				default :
					System.out.println("\t�߸� �Է��ϼ̽��ϴ�.");
			}
			
		}
	}

}
