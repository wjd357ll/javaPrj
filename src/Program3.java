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
		
		요기 :
		while(true){
			
			System.out.println("┌─────────────────────┐");
			System.out.println("│                       메인  메뉴                         │");
			System.out.println("└─────────────────────┘");
			System.out.println("\n\t1. 성적 입력");
			System.out.println("\t2. 성적 출력");
			System.out.println("\t3. 종료");
			System.out.print("\n\t원하는 메뉴 번호를 입력하세요 : ");
			
			menu = scan.nextInt();
			
			//성적입력 코드 작성
			
			switch(menu)
			{
				case 1:
				{
					System.out.println("\n┌─────────────────────┐");
					System.out.println("│                       성적  입력                         │");
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
				}
				break;
				
				case 2:
				{
					total = kor + eng + math;
					avg = total/3.0f;
					
					System.out.println("\n┌─────────────────────┐");
					System.out.println("│                       성적  출력                         │");
					System.out.println("└─────────────────────┘");
						
						for(int i=0; i<3; i++)
						{
							System.out.printf(" \t번호 : %d\n ", (i+1));
							System.out.printf(" \t국어 : %d\n ", kor);
							System.out.printf(" \t영어 : %d\n ", eng);
							System.out.printf(" \t수학 : %d\n ", math);
							System.out.printf(" \t총점 : %d\n ", total);
							System.out.printf(" \t평균 : %5.2f\n ", avg);
							System.out.println("───────────────────────");
						}
					}
				break;
				
				case 3:
				{
					System.out.println("\n\tGood Bye!");
					break 요기;
				}
				
				default :
				{
						System.out.println("\n\t잘못 선택하셨습니다.\n");
				}
			}
		}
	}
}
