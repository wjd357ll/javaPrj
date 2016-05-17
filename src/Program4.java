import java.util.Scanner;

// �Լ��� �̿��� ������ �ۼ��ϴ� �ڵ�

public class Program4 {

	public static void main(String[] args) {
		
		Exam exam = new Exam();
		
	//	Exam.getKor(exam);
		
	//	Exam.setKor(exam, kor);
		
		
		end :
		while(true)
		{
			switch(inputMainMenu())
			{
			case 1:
				inputExam(exam); // exam�� ����
				break;
				
			case 2:
				outputExam(exam); //���⼭ ���� exam�� ������ �ƴ� ��
				break;
				
			case 3:
				exit();
				break end;	
			
			default :
					System.out.println("\n\t�߸� �����ϼ̽��ϴ�.\n");
			}
		}
	}

	private static void exit() {
	
		System.out.println("\n\tGood Bye!");
	}

	private static void outputExam(Exam exam) {
	
		int kor = exam.kor;
		int eng = exam.eng;
		int math = exam.math;
		
		int total = kor + eng + math;
		float avg = total/3.0f;
		
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

	private static void inputExam(Exam exam) {
		
		int kor;  // �ӽ� ����( exam.kor��� ���� ���ŷο��� ) - ��Ȳ�� ���� ���
		int eng;
		int math;
		
		Scanner scan = new Scanner(System.in);
		
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
		
		exam.kor = kor;
		exam.eng = eng;
		exam.math = math;
	}

	private static int inputMainMenu() {
	
		int menu;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("����������������������������������������������");
		System.out.println("��                       ����  �޴�                         ��");
		System.out.println("����������������������������������������������");
		System.out.println("\n\t1. ���� �Է�");
		System.out.println("\t2. ���� ���");
		System.out.println("\t3. ����");
		System.out.print("\n\t���ϴ� �޴� ��ȣ�� �Է��ϼ��� : ");
		
		menu = scan.nextInt();
		
		return menu;
	}
}
