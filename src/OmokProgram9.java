import java.util.Scanner;

public class OmokProgram9 {

	// ������� ����ȭ!!! �����ȵſ�..........
	
	public static void main(String[] args) {

		VictoryCase list1 = new VictoryCase();
		
		Omok omoks = new Omok();
		
		list1.omoks = omoks;
		
		omoks.board = new char[20][25] ;
		omoks.xs = new int[500];
		omoks.ys = new int[500];
		omoks.height = 20;
		omoks.width = 25;
		list1.count = 0;
		
		char[][] board = omoks.board;
		int[] xs = omoks.xs;
		int[] ys = omoks.ys;
		int count = list1.count;
		int height = omoks.height;
		int width = omoks.width;
		
		Scanner scan = new Scanner(System.in);
		
		omok :
		while(true)
		{	
			drawBoard(list1); // ������� �׸���
			 
			switch(inputMainMenu()) // ��inputMainMenu �Լ��� ���� �޴� ��ȣ �Է� �ޱ�
			{
				case 1:
					
					count = list1.count;  // ������� ���� Ƚ��
					 
					printBoard(list1); // ��� ������ ���
					 
					list1.check = 0;
					
					count = 0;
					
					play :
					while(true)
					{
						
						System.out.print("\n\t���ϴ� ��ǥ�� �Է��ϼ��� (x sp y) : ");
						 xs[count] = scan.nextInt();
						 ys[count] = scan.nextInt();
						 
						 // ��������� ����� ��ǥ�� �Է��� ����
						 
						 if(!(0<xs[count] && xs[count]<height+1) || !(0<ys[count] && ys[count]<width+1))
						 {
							 System.out.println("\n\t�������� ��� ��ġ�Դϴ�. �ٽ� �Է����ּ���.");
							 continue;
						 }
						 
						 // ���̹� �ٸ� ���� ���� ��ǥ�� �Է��� ��� (�ߺ�)��
						 
						 if(board[xs[count]-1][ys[count]-1]=='��' || board[xs[count]-1][ys[count]-1]=='��')
						 {
							 System.out.println("\n\t�̹� �ٸ� ������ �ֽ��ϴ�. �ٸ� ��ǥ�� �Է����ּ���.");
							 continue;
						 }
						 
						// �����ڰ� �Է��� ��ǥ�� �� ��/���� �� ����
						 
					 	putOmokStone(list1);  
					 	
					 	// ��(���� �ֱٿ� ���� ���� ��������) ���������� 5���� ���� ���� �� ���� ����
					 	
					 	rightHorisontalWin(list1);  
			    		 
			    		 if(list1.check==4)
			    		 {
			    			 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);  // ���а� �������� ���� ��ǥ (x,y)
			    			 break play;
			    		 }	
			    		 
			    		// ��(���� �ֱٿ� ���� ���� ��������) �������� 5���� ���� ���� �� ���� ����
						leftHorisontalWin(list1);  
						
			    		 if(list1.check==4)
			    		 {
			    			 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);  // ���а� �������� ���� ��ǥ (x,y)
			    			 break play;
			    		 }	
						
						 list1.count+=1; 
						 
						 // ����̻� ���� �ڸ��� ���� ��
						 if(count>=500)
						 {
							 System.out.println("\n\t���̻� ���� �ڸ��� �����ϴ�. ���º�! \n\t������ �����ϰ� ���� �޴��� ���ư��ϴ�.");
							 break play;
						 }
					}
				break;
				
				case 2:
					System.out.println("\n\t���� ������ �����մϴ�.");
					break omok;
			}
		}
	}

	private static void leftHorisontalWin(VictoryCase list) {
		
		VictoryCase list1 = new VictoryCase();
		
		Omok omoks = new Omok();
		
		list1.omoks = omoks;
		
		omoks.board = new char[20][25] ;
		omoks.xs = new int[500];
		omoks.ys = new int[500];
		
		char[][] board = omoks.board;
		int[] xs = omoks.xs;
		int[] ys = omoks.ys;
		int count = list1.count;

		
		 for(int i=1; i<6; i++)
		 {
			 if(xs[count]==1 && ys[count]<5)
				 continue; 
			 else if((board[xs[count]-1][ys[count]-1]==board[xs[count]-1][(ys[count]-1)-i]) && board[xs[count]-1][ys[count]-1]!='��')
				 list1.check +=1;
			 else
				 break;
		 }
		
	}

	private static void rightHorisontalWin(VictoryCase list) {

		VictoryCase list1 = new VictoryCase();
		
		Omok omoks = new Omok();
		
		list1.omoks = omoks;
		
		omoks.board = new char[20][25] ;
		omoks.xs = new int[500];
		omoks.ys = new int[500];
		
		char[][] board = omoks.board;
		int[] xs = omoks.xs;
		int[] ys = omoks.ys;
		int count = list1.count;

		 for(int i=1; i<6; i++)
			 if((board[xs[count]-1][ys[count]-1]==board[xs[count]-1][(ys[count]-1)+i]) && board[xs[count]-1][ys[count]-1]!='��')
				 list1.check +=1;
			 else
				 break;
	}

	private static void printBoard(VictoryCase list) {

		VictoryCase list1 = new VictoryCase();
		
		Omok omoks = new Omok();
		
		list1.omoks = omoks;
		
		for(int x=0; x<omoks.height; x++)
		 {
			 for(int y=0; y<omoks.width; y++)
				 System.out.printf("%c", omoks.board[x][y]);
			
			 System.out.println();
		 }
		
	}

	private static void putOmokStone(VictoryCase list) {

		VictoryCase list1 = new VictoryCase();
		
		Omok omoks = new Omok();
		
		list1.omoks = omoks;

		omoks.board = new char[20][25] ;
		omoks.xs = new int[500];
		omoks.ys = new int[500];
		
		char[][] board = omoks.board;
		int[] xs = omoks.xs;
		int[] ys = omoks.ys;
		int count = list1.count;

	//	System.out.println(count);
		 for(int i=1; i<=count; i++)
			 if(i%2==0)
				 board[xs[i]-1][ys[i]-1]='��'; 
			 else
				 board[xs[i]-1][ys[i]-1]='��';
		 
		 printBoard(list1); // ������ ���
	}

	private static void drawBoard(VictoryCase list) {

		VictoryCase list1 = new VictoryCase();
		
		Omok omoks = new Omok();
		
		list1.omoks = omoks;
		
		omoks.board = new char[20][25] ;
		omoks.height = 20;
		omoks.width = 25;

		
		char[][] board = omoks.board;
		int height = omoks.height;
		int width = omoks.width;

		 for(int x=0; x<height; x++)
			 for(int y=0; y<width; y++)
				  board[x][y]='��';
		
		 for(int i=0; i<height; i++)
			 board[i][0]='��';
		 for(int i=0; i<height; i++)
			 board[i][width-1]='��';
		 for(int i=0; i<width; i++)
			 board[0][i]='��';
		 for(int i=0; i<width; i++)
			 board[height-1][i]='��';
		 
		 board[0][0]='��';
		 board[0][width-1]='��';
		 board[height-1][0]='��';
		 board[height-1][width-1]='��';

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