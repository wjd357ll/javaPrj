import java.util.Scanner;


public class Program3 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int kor = 0;
		int eng = 0;
		int math = 0;
		int total;
		int menu;
		float avg;

		/* kor=60;
		eng=70;
		math=100; */
		
		��� :
		while(true){
			
			System.out.println("����������������������������������������������");
			System.out.println("��                       ����  �޴�                         ��");
			System.out.println("����������������������������������������������");
			System.out.println("\n\t1. ���� �Է�");
			System.out.println("\t2. ���� ���");
			System.out.println("\t3. ����");
			System.out.print("\n\t���ϴ� �޴� ��ȣ�� �Է��ϼ��� : ");
			
			menu = scan.nextInt();
			
			//�����Է� �ڵ� �ۼ�
			
			switch(menu)
			{
				case 1:
				{
					System.out.println("\n����������������������������������������������");
					System.out.println("��                       ����  �Է�                         ��");
					System.out.println("����������������������������������������������");
					
					do
					{
						System.out.print("\n  \t���� : ");
						kor = scan.nextInt();
						
						if(!(0<=kor && kor<=100))
							System.out.println("�߸� �Է��ϼ̽��ϴ�. 0~100 ������ ���� �Է��ϼ���.");
					}
					while(!(0<=kor && kor<=100));
					
					do
					{
						System.out.print("\n  \t���� : ");
						eng = scan.nextInt();
						
						if(!(0<=eng && eng<=100))
							System.out.println("�߸� �Է��ϼ̽��ϴ�. 0~100 ������ ���� �Է��ϼ���.");
					}
					while(!(0<=eng && eng<=100));
					
					do
					{
						System.out.print("\n  \t���� : ");
						math = scan.nextInt();
						
						if(!(0<=math && math<=100))
							System.out.println("�߸� �Է��ϼ̽��ϴ�. 0~100 ������ ���� �Է��ϼ���.");
					}
					while(!(0<=math && math<=100));
				}
				break;
				
				case 2:
				{
					total = kor + eng + math;
					avg = total/3.0f;
					
					System.out.println("\n����������������������������������������������");
					System.out.println("��                       ����  ���                         ��");
					System.out.println("����������������������������������������������");
						
						for(int i=0; i<3; i++)
						{
							System.out.printf(" \t��ȣ : %d\n ", (i+1));
							System.out.printf(" \t���� : %d\n ", kor);
							System.out.printf(" \t���� : %d\n ", eng);
							System.out.printf(" \t���� : %d\n ", math);
							System.out.printf(" \t���� : %d\n ", total);
							System.out.printf(" \t��� : %5.2f\n ", avg);
							System.out.println("����������������������������������������������");
						}
					}
				break;
				
				case 3:
				{
					System.out.println("\n\tGood Bye!");
					break ���;
				}
				
				default :
				{
						System.out.println("\n\t�߸� �����ϼ̽��ϴ�.\n");
				}
			}
		}
	}
}
