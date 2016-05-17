import java.util.Scanner;

// ������ ������ ���� ��ü �ٷ��

public class Program7 {

	
	public static void main(String[] args) {
		
		/*int current = -1;
		
		Exam exams[] = new Exam[3];*/
		
		ExamCollection list = new ExamCollection(); //new�� ���� ������ ���� ����. ������ ����. new�� ������ ���� ������ �� �����Ƿ�
		
		list.exams = new Exam[3];
		list.current = -1;
		
		int x = 0;
		int y;
		
		x+=3;
		y = x+2;
		
		
		// ������ �ƴ϶� ������ ����ü�� ��Ÿ���� �̸�ǥ �� ���� ���� ���̴�. (������ ����ü �迭�� ����.) 
		// 
		
		/*
		exams[0] = new Exam(); // ������ ������
		
		exams[0].kor = 3; // ������ new�� ���� �����ϱ� ������ �̸�ǥ�� ���� �ִ� �� �Ұ���
		 */		
		
		end :
		while(true)
		{
			switch(inputMainMenu())
			{
			case 1:
				inputExam(list); // exam�� ����
				break;
				
			case 2:
				outputExam(list); //���⼭ ���� exam�� ������ �ƴ� ��
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

	private static void outputExam(ExamCollection list) {

		System.out.println("\n����������������������������������������������");
		System.out.println("��                       ����  ���                         ��");
		System.out.println("����������������������������������������������");
			
		for(int i=0; i<list.current+1; i++)
		{
			Exam exam = list.exams[i];
			
			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;
			
			int total = total(exam);
			float avg = total/3.0f;
			
			System.out.printf(" \t��ȣ : %d\n ", (i+1));
			System.out.printf(" \t���� : %d\n ", kor);
			System.out.printf(" \t���� : %d\n ", eng);
			System.out.printf(" \t���� : %d\n ", math);
			System.out.printf(" \t���� : %d\n ", total);
			System.out.printf(" \t��� : %5.2f\n ", avg);
			System.out.println("����������������������������������������������");
			
		}
			
	}

	private static int total(int kor, int eng, int math) {
		
		return kor + eng + math ;
	}
	
	private static int total(Exam exam) {
		
		return total(exam.kor, exam.eng, exam.math) ;
	}


	private static void inputExam(ExamCollection list) {
		
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
		
		Exam exam = new Exam();
		
		exam.kor = kor;
		exam.eng = eng;
		exam.math = math;
		
		list.exams[++list.current] = exam;
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
