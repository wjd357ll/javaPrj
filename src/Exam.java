
public class Exam {
	
	 int kor;
	 int math;
	 int eng;
	
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

}
