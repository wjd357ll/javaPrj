import java.util.Scanner;

public class OmokProgram2 {

	public static void main(String[] args) {
		
		int x = 0;
		int y = 0;
		
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i<20; i++)
		{
			for(int j=0; j<20; j++)
			{
				if(i==0 && j==0)
					System.out.printf("%c", '��'); // Ưȭ�� ���� ���� ���� ��� �Ѵ�.
				else if(i==0 && j==19)
					System.out.printf("%c", '��');
				else if(i==19 && j==19)
					System.out.printf("%c", '��');
				else if(i==19 && j==0)
					System.out.printf("%c", '��');
				else if(j==0)
					System.out.printf("%c", '��');
				else if(i==0)
					System.out.printf("%c", '��');
				else if(j == 19)
					System.out.printf("%c", '��');
				else if(i==19)
					System.out.printf("%c", '��');
				else
					System.out.printf("%c", '��');
			}
			System.out.println();
		}	
		
		//����ڿ��� ���� ��ǥ �ϳ��� �Է� �޴´�.
		System.out.print("\n�ٵϾ��� �ΰ� ���� ��ǥ�� �Է��ϼ���. (x sp y) : ");
		x = scan.nextInt();
		y = scan.nextInt();
		System.out.println();
		
		
		//������ ���
		
		for(int i=1; i<=20; i++)
		{
			for(int j=1; j<=20; j++)
			{
				if(i==y && j==x)
					System.out.printf("%c", '��');  // Ư�� ��ġ ����
			
				else if(i==1 && j==1)
					System.out.printf("%c", '��'); // ������
				else if(i==1 && j==20)
					System.out.printf("%c", '��');
				else if(i==20 && j==20)
					System.out.printf("%c", '��');
				else if(i==20 && j==1)
					System.out.printf("%c", '��');
			
				else if(j==1)
					System.out.printf("%c", '��'); // �ܺ�
				else if(i==1)
					System.out.printf("%c", '��');
				else if(j == 20)
					System.out.printf("%c", '��');
				else if(i==20)
					System.out.printf("%c", '��');
				
				else
					System.out.printf("%c", '��'); // ����
			}
			System.out.println();
		}
		
	}

}
