package oop.inhe.ya;

import java.util.Scanner;

public class ExamConsole {
	
	private TitlePrintListener titlePrintListener;
	private PrintListener printListener;
	// 인터페이스 자료형이 없기때문에 새로운 클래스로 만들어준다.

	private Exam exam; 
	
	// 외부에서 생성자 호출을 막기 위해 private ( 생성자 호출 수 만큼 객체가 생성되므로 )
	// 다른 클래스에서 데이터 구조를 알지 못하도록(데이터구조는 보지 않고 함수만 사용하면 된다)
	// 데이터를 숨기는 것이 캡슐 - private으로 캡슐을 깨지 않아야 한다.

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
		
			int kor;  // 임시 변수( exam.kor라고 쓰기 번거로워서 ) - 상황에 따라 사용
			int eng;
			int math;
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("\n┌─────────────────────┐");
			System.out.println("│       성적  입력                     │");
			System.out.println("└─────────────────────┘");
			
			do
			{
				System.out.print("\n  \t국어 : ");
				kor = scan.nextInt();
				
				if(!(0<=kor && kor<=100))
					System.out.println("잘못 입력하셨습니다. 0~100 사이의 값을 입력하세요.");
			}
			while(!(0<=kor && kor<=100));
			
			do
			{
				System.out.print("\n  \t영어 : ");
				eng = scan.nextInt();
				
				if(!(0<=eng && eng<=100))
					System.out.println("잘못 입력하셨습니다. 0~100 사이의 값을 입력하세요.");
			}
			while(!(0<=eng && eng<=100));
			
			do
			{
				System.out.print("\n  \t수학 : ");
				math = scan.nextInt();
				
				if(!(0<=math && math<=100))
					System.out.println("잘못 입력하셨습니다. 0~100 사이의 값을 입력하세요.");
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
			System.out.println("\n┌─────────────────────┐");
			System.out.println("│       성적  출력                     │");
			System.out.println("└─────────────────────┘");
			}
				
			for(int i=0; i<3; i++)
			{
				System.out.printf(" \t번호 : %d\n ", (i+1));
				System.out.printf(" \t국어 : %d\n ", kor);
				System.out.printf(" \t영어 : %d\n ", eng);
				System.out.printf(" \t수학 : %d\n ", math);
				//onPrint();
				if(printListener != null)
					printListener.onPrint();
				System.out.printf(" \t총점 : %d\n ", total);
				System.out.printf(" \t평균 : %5.2f\n ", avg);
				System.out.println("───────────────────────");
			}
				
		}


	//protected abstract void onPrint();
		// 이 함수 자체에 기능이 따로 존재하는 것이 아니라 자식클래스에서 고쳐쓸 수 있도록 하는 함수이므로 protected
		// 고쳐쓸 때 사용하는 함수이므로 비어있다.
		// abstract를 통해 반드시 고쳐쓰도록 강요 - 재정의하지 않고 넘어가면 오류 발생
		// 클래스 일부가 abstract이면 클래스 자체도 abstract으로 명시해줘야 한다.

}
