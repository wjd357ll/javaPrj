import java.util.Scanner;

public class Program9 {
	
	public static void main(String[] args) {
		
		ExamCollection list = new ExamCollection();
		
		list.exams = new Exam[3];
		list.current = -1;
		
		while(true)
		{
			//���θ޴� �Է�
			
			switch(inputMainMenu())
			{
			case 1: // ���� �Է�
				inputExam(list);
				break;
				
			case 2: // ���� ���
				outputExam(list);
				break;
				
			case 3: // ����
				exit();
				break;
				
			default :
				
			}
		}
	}


	private static void exit() {
		
		System.out.println("\n\t���� ���α׷��� �����մϴ�.");
	}

	private static void outputExam(ExamCollection list) {
		
		int total = 0;
		float avg = 0;
		
		System.out.println("\n����������������������������������������������");
		System.out.println("��                       ����  ���                         ��");
		System.out.println("����������������������������������������������");
			
			for(int i=0; i<=list.current+1; i++)
			{
				Exam exams = list.exams[i];
				
				int kor = exams.kor;
				int math = exams.math;
				int eng = exams.eng;
				
				total = kor + eng + math;
				avg = total/3.0f;
				
				System.out.printf(" \t��ȣ : %d\n ", (i+1));
				System.out.printf(" \t���� : %d\n ", kor);
				System.out.printf(" \t���� : %d\n ", eng);
				System.out.printf(" \t���� : %d\n ", math);
				System.out.printf(" \t���� : %d\n ", total);
				System.out.printf(" \t��� : %5.2f\n ", avg);
				System.out.println("����������������������������������������������");
			}

	}

	private static void inputExam(ExamCollection list) { 
	
		Exam exam = new Exam();
		
		int kor = exam.kor;
		int math = exam.math;
		int eng = exam.eng;
		
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
		
		Exam[] exams = list.exams;
		
		list.exams[++list.current] = exam;
	}

	private static int inputMainMenu() {
		
		Scanner  scan = new Scanner(System.in);
		
		System.out.println("����������������������������������������������");
		System.out.println("��                       ����  �޴�                         ��");
		System.out.println("����������������������������������������������");
		System.out.println("\n\t1. ���� �Է�");
		System.out.println("\t2. ���� ���");
		System.out.println("\t3. ����");
		System.out.print("\n\t���ϴ� �޴� ��ȣ�� �Է��ϼ��� : ");
		
		int menu = scan.nextInt();
		
		return menu;
	}
}
