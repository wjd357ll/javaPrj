import java.util.Scanner;


public class Program {

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
			
			if(menu == 1){
				
				System.out.println("\n����������������������������������������������");
				System.out.println("��                       ����  �Է�                         ��");
				System.out.println("����������������������������������������������");
				System.out.print("\n  \t���� : ");
				kor = scan.nextInt();
				System.out.print("  \n\t���� : ");
				eng = scan.nextInt();
				System.out.print("  \n\t���� : ");
				math = scan.nextInt();
			}
	
			else if(menu == 2){
			
				total = kor + eng + math;
				avg = total/3.0f;
				
				System.out.println("\n����������������������������������������������");
				System.out.println("��                       ����  ���                         ��");
				System.out.println("����������������������������������������������");
				System.out.printf(" \t���� : %d\n ", kor);
				System.out.printf(" \t���� : %d\n ", eng);
				System.out.printf(" \t���� : %d\n ", math);
				System.out.printf(" \t���� : %d\n ", total);
				System.out.printf(" \t��� : %5.2f\n ", avg);
				System.out.println("����������������������������������������������");
			}
			
			else if(menu == 3){
				System.out.println("\n\tGood Bye!");
				System.exit(0);
			}
			else
			{
					System.out.println("\n\t�߸� �����ϼ̽��ϴ�.\n");
			}
		}
	}
}
