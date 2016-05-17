package oop.inhe.ya;

import java.util.Scanner;

public class ExamConsole {
	
	private TitlePrintListener titlePrintListener;
	private PrintListener printListener;
	// �������̽� �ڷ����� ���⶧���� ���ο� Ŭ������ ������ش�.

	private Exam exam; 
	
	// �ܺο��� ������ ȣ���� ���� ���� private ( ������ ȣ�� �� ��ŭ ��ü�� �����ǹǷ� )
	// �ٸ� Ŭ�������� ������ ������ ���� ���ϵ���(�����ͱ����� ���� �ʰ� �Լ��� ����ϸ� �ȴ�)
	// �����͸� ����� ���� ĸ�� - private���� ĸ���� ���� �ʾƾ� �Ѵ�.

	public void setPrintListener(PrintListener printListener) {
		this.printListener = printListener;
	}

	public ExamConsole() {
		
	}

	public void setTitlePrintListener(TitlePrintListener titlePrintListener) {
		this.titlePrintListener = titlePrintListener;
	}

	public ExamConsole(Exam exam){
		this.exam = exam;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}


	public void inputExam() {
		
			int kor;  // �ӽ� ����( exam.kor��� ���� ���ŷο��� ) - ��Ȳ�� ���� ���
			int eng;
			int math;
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("\n����������������������������������������������");
			System.out.println("��       ����  �Է�                     ��");
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
			
			exam.setKor(kor);
			exam.setEng(eng);
			exam.setMath(math);
		}
	
	public void printExam() {
			
			int kor = exam.getKor();
			int eng = exam.getEng();
			int math = exam.getMath();
			float avg = 0;
			int total = 0;
			 
			total = exam.total();
			avg = exam.avg();
			
			if(titlePrintListener != null)
				titlePrintListener.onTitlePrint();
			else{
			System.out.println("\n����������������������������������������������");
			System.out.println("��       ����  ���                     ��");
			System.out.println("����������������������������������������������");
			}
				
			for(int i=0; i<3; i++)
			{
				System.out.printf(" \t��ȣ : %d\n ", (i+1));
				System.out.printf(" \t���� : %d\n ", kor);
				System.out.printf(" \t���� : %d\n ", eng);
				System.out.printf(" \t���� : %d\n ", math);
				//onPrint();
				if(printListener != null)
					printListener.onPrint();
				System.out.printf(" \t���� : %d\n ", total);
				System.out.printf(" \t��� : %5.2f\n ", avg);
				System.out.println("����������������������������������������������");
			}
				
		}


	//protected abstract void onPrint();
		// �� �Լ� ��ü�� ����� ���� �����ϴ� ���� �ƴ϶� �ڽ�Ŭ�������� ���ľ� �� �ֵ��� �ϴ� �Լ��̹Ƿ� protected
		// ���ľ� �� ����ϴ� �Լ��̹Ƿ� ����ִ�.
		// abstract�� ���� �ݵ�� ���ľ����� ���� - ���������� �ʰ� �Ѿ�� ���� �߻�
		// Ŭ���� �Ϻΰ� abstract�̸� Ŭ���� ��ü�� abstract���� �������� �Ѵ�.

}
