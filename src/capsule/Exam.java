package capsule;

import java.util.Scanner;

public class Exam {
	
	private int kor; // �ٸ� Ŭ��������  set�Լ� ���̴� ���� �� �� ���� �ȴ�.
	private int math;
	private int eng;
	
	// �ٸ� Ŭ�������� ������ ����ϴ� ���, ĸ�� ���� ������ �����ϸ� �� Ŭ���� ���� ������ ���� �߻�
	// �ٸ� Ŭ�������� ������ ���� ������ ������ ĸ�� ���� ���븸 �� �� �ֵ��� set�Լ��� ����� ����Ѵ�.
	public static void setKor(Exam exam, int kor){  
		exam.kor = kor;
	}
	
	public static int getKor(Exam exam){  // �Ű����� �� �ʿ�! exam���� kor�� �����޶�
		return exam.kor; // �ܺο����� exam�� ������ �ִ��� kor������ ���� ������ �� ���� ������ exam���� kor���� ���� �������ִ� ����
	}
	
	public static void setEng(Exam exam, int eng){  
		exam.eng = eng;
	}
	
	public static int getEng(Exam exam){ 
		return exam.eng;
	}
	
	public static void setMath(Exam exam, int math){  
		exam.math = math;
	}
	
	public static int getMath(Exam exam){ 
		return exam.math;
	}
	
	static void outputExam(Exam exam) {
		
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

	static void inputExam(Exam exam) {
		
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
	
	static int total(int kor, int eng, int math) {
		
		return kor + eng + math ;
	}
	
	static int total(Exam exam) {
		
		return total(exam.kor, exam.eng, exam.math) ;
	}

}
