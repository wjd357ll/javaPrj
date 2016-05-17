package collection;

import java.util.Scanner;

public class Program8 {

	static ExamCollection list;
	
	public static void main(String[] args) {
		
		list = new ExamCollection();	
		
		end :
		while(true)
		{
			switch(inputMainMenu())
			{
			case 1:
				inputExam(list);
				break;
				
			case 2:
				outputExam(list);
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
			
		// ��ü���������� ĸ��ȭ �ϴ� ��
		// for(int i=0; i<list.current+1; i++)
		// �� �κп��� ĸ���� ���� ������ �߻��Ͽ���.
		// �� �ڵ带 �Ʒ�ó�� ��ġ���� �Ѵ�. size() �޼ҵ带 �ۼ�����.
		for(int i=0; i<list.size(); i++)
		{
			// Exam exam = list.exams[i];
			// �� �κп��� �� ĸ���� ���� ������ �߻�
			// �Ʒ�ó�� ���ļ� �׸��� ��ȯ���ִ� �޼ҵ带 �ۼ�����.
			Exam exam = list.get(i);
			
			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;
			
			int total = kor + eng + math;
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

	private static void inputExam(ExamCollection list) { 
		
		int kor;
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
		
		// list.exams[++list.current] = exam;
		// ĸ���� ���� �ʱ� ���� �ӽú��� exam�� �ִ� ���� ���� �迭�� �־��ִ� �޼ҵ带 �ۼ�����.
		list.add(exam); // exam�� �Լ������� �Ѱ��ش�.
						// current�� ���� �迭 ������ ����Ǿ����� �� �� �ִ�.
		// capacity : �迭 �뷮�� �ǹ��ϴ� ����
		// ó������ �迭�� ũ�⸦ ��û ũ�� ���س��� �ͺ��� ó���� �۰� ���س��� �ʿ��ϸ� �÷����� ����� ���� �ʿ��� ����
		
	}

	private static int inputMainMenu() {
	
		int menu;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("����������������������������������������������");
		System.out.println("��        ����  �޴�                   ��");
		System.out.println("����������������������������������������������");
		System.out.println("\n\t1. ���� �Է�");
		System.out.println("\t2. ���� ���");
		System.out.println("\t3. ����");
		System.out.print("\n\t���ϴ� �޴� ��ȣ�� �Է��ϼ��� : ");
		
		menu = scan.nextInt();
		
		return menu;
	}
}