import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		int usernum[] = new int[7];
		int lottonum[] = new int[7];
		
		for(int i=0; i<7; i++)
		{
			lottonum[i] = (int)(Math.random()*45) + 1;
			
			for(int j=0; j<i; j++)
			{
				while(true)
				{	
					lottonum[j] = (int)(Math.random()*45) + 1;
					
					if(lottonum[i] != lottonum[j])
					{
						break;
					}
				}
			}
		}
		
		System.out.println("��������������������������������������������");
		System.out.println("��              �� 777ȸ Lotto �� ��                 ��");
		System.out.println("��������������������������������������������");
		
		
		System.out.println(" *************************************\n");
		System.out.println("\t\t\t��ȣ �Է�\n");
		System.out.println(" *************************************\n");
		System.out.print("\t [1]~[6]���� ��ȣ�� �Է��ϼ���.\n");
		
		for(int i=0; i<6; i++)
		{	
			System.out.printf("\n\t\t\t[%d] : ", i+1);
			usernum[i] = scan.nextInt();
		}
		
		System.out.print("\n\t    ���ʽ� ��ȣ�� �Է��ϼ���.\n\n");
		System.out.print("\t\t[bonus] : ");
		usernum[6] = scan.nextInt();
		
		System.out.println("\n *************************************\n");
		System.out.println("\t     �����Ͻ� ��ȣ�� Ȯ���ϼ���.\n");
		System.out.println(" *************************************\n");
		
		for(int i=0; i<usernum.length; i++)
		{
			System.out.printf("%6d\t", usernum[i]);
		}
		
		System.out.printf("%6d\n", usernum[6]);
	
		System.out.println("\n\n *************************************\n");
		System.out.println("\t\t\t��÷ ��ȣ\n");
		System.out.println(" *************************************\n");
		System.out.print("    " + lottonum[0] + "\t");
		
		for(int i=0; i<lottonum.length; i++)
			{
			System.out.print(" " + lottonum[i] + "\t");
			}
		
		System.out.print(" " + lottonum[6]);
		
	}

}
