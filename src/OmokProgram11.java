import java.util.Scanner;

public class OmokProgram11 {

	// ������� ����ȭ (�ϼ�)
	
	public static void main(String[] args) {

		
		Omok omoks = new Omok();
		
		omoks.xs = new int[500];
		omoks.ys = new int[500];
		
		omoks.count = -1;
		
		omok :
		while(true)
		{	
			omoks.end = 0;
			omoks.drawBoard(); // ������� �׸���
			 
			switch(inputMainMenu()) // ��inputMainMenu �Լ��� ���� �޴� ��ȣ �Է� �ޱ�
			{
				case 1:
					 
					omoks.printBoard(); // ��� ������ ���
					
					play :
					while(true)
					{
						omoks.count += 1;
						omoks.inputXY();
						 
						 // ��������� ����� ��ǥ�� �Է��� ����
						 
						 if(omoks.outOfBoard()==1)
							 continue;
						 
						 
						 // ���̹� �ٸ� ���� ���� ��ǥ�� �Է��� ��� (�ߺ�)��
						 
						 if(omoks.overLap()==1)
							 continue;
						 
						// �����ڰ� �Է��� ��ǥ�� �� ��/���� �� ����
						 
					 	omoks.putOmokStone();   
					 	
					 	if(omoks.horisontalWin()==1)  // �� ���� �¸� ���� ������ end=1�� �Ǿ� ���� ����
					 		break play;
					 	else if(omoks.verticalWin()==1)
					 		break play;
					 	else if(omoks.rightDiagonalWin()==1)
					 		break play;
					 	else if(omoks.leftDiagonalWin()==1)
					 		break play;
					 		
						 
						 // ����̻� ���� �ڸ��� ���� ��
						 
						 if(omoks.draw()==1)
							 break play;
						 
					}
				break;
				
				case 2:
					System.out.println("\n\t���� ������ �����մϴ�.");
					break omok;
			}
		}
	}


	private static int inputMainMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("����������������������������������������������");
		System.out.println("��                       ����  ����                         ��");
		System.out.println("����������������������������������������������");
		System.out.println("\n\t1. ���� ����");
		System.out.println("\t2. ���� ����");
		
		System.out.print("\n\t���ϴ� �޴��� �Է��ϼ��� : ");
		int menu = scan.nextInt();
		System.out.println("\n");
		
		return menu;
	}
}