import java.util.Scanner;

public class OmokProgram7 {

	// ������� �ٽ� ������
	
	public static void main(String[] args) {

		int height = 20;
		int width = 25;
		char [][] board = new char[height][width];
		int[] xs = new int[500];
		int[] ys = new int[500]; // ����ڰ� ������ ���� ��ǥ�� ������ �°� �����ϴ� �迭
		
		Scanner scan = new Scanner(System.in);
		
		omok :
		while(true)
		{
			System.out.println("����������������������������������������������");
			System.out.println("��                       ����  ����                         ��");
			System.out.println("����������������������������������������������");
			System.out.println("\n\t1. ���� ����");
			System.out.println("\t2. ���� ����");
			
			int menu;
			System.out.print("\n\t���ϴ� �޴��� �Է��ϼ��� : ");
			menu = scan.nextInt();
			System.out.println("\n");
			
			// ������ �׸���
			
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
			 
			switch(menu)
			{
				case 1:
					
					 // ������ ���
					 
					 for(int x=0; x<height; x++)
					 {
						 for(int y=0; y<width; y++)
							 System.out.printf("%c", board[x][y]);
						
						 System.out.println();
					 }
					 
					 int count = 0;
					 
					play :
					while(true)
					{
						System.out.print("\n\t���ϴ� ��ǥ�� �Է��ϼ��� (x sp y) : ");
						 xs[count] = scan.nextInt();
						 ys[count] = scan.nextInt();
						 
						 // �������� ����� ��ǥ�� �Է��� ���
						 if(!(0<xs[count] && xs[count]<height+1) || !(0<ys[count] && ys[count]<width+1))
						 {
							 System.out.println("\n\t�������� ��� ��ġ�Դϴ�. �ٽ� �Է����ּ���.");
							 continue;
						 }
						 
						 // �̹� �ٸ� ���� ���� ��ǥ�� �Է��� ��� (�ߺ�)
						 if(board[xs[count]-1][ys[count]-1]=='��' || board[xs[count]-1][ys[count]-1]=='��')
						 {
							 System.out.println("\n\t�̹� �ٸ� ������ �ֽ��ϴ�. �ٸ� ��ǥ�� �Է����ּ���.");
							 continue;
						 }
						 
						 // ����ڰ� �Է��� ��ǥ�� ���� ���
						 for(int i=0; i<=count; i++)
							 if(i%2==0)
								 board[xs[i]-1][ys[i]-1]='��'; // ����ڰ� �Է��� ��ǥ�� (1,1) ���� ���������� �迭�� [0][0]���� �����ϹǷ� -1 ���ش�.
							 else
								 board[xs[i]-1][ys[i]-1]='��';
						 
						 // ������ ���
						 for(int x=0; x<height; x++)
						 {
							 for(int y=0; y<width; y++)
								 System.out.printf("%c", board[x][y]);
							
							 System.out.println();
						 }
					     
					     // ���а� �������� ������ ������ ���� �޴��� �̵�
						 
						 /*if(xs[count]==1 && ys[count]==1)
						 for(int y=0; y<4; y++)
						 {
							 if((board[0][0]==board[0][y+1]) && board[0][0]!='��')
								 check +=1;
							 else
								 break;
							 
							 if(check==4)
				    		 {
				    			 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[0][0]);  // ���а� �������� ���� ��ǥ (x,y)
				    			 break play;
				    		 }	
						 }*/
					 	 
						 	// (���� �ֱٿ� ���� ���� ��������) ���������� 5���� ���� ���� �� ���� ����
							 int check = 0;
							
							 if(xs[count]>4)
						    	 for(int x=xs[count]-1; x<xs[count]+4; x++)
						    	 {
						    		 for(int i=1; i<6; i++)
						    			 if((board[x][ys[count]-1]==board[x][(ys[count]-1)+i]) && board[x][ys[count]-1]!='��')
						    				 check +=1;
						    			 else
						    				 break;
						    	 
						    		 if(check==4)
						    		 {
						    			 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[x][ys[count]-1]);  // ���а� �������� ���� ��ǥ (x,y)
						    			 break play;
						    		 }	 
						    	 }
							 
							// (���� �ֱٿ� ���� ���� ��������) �������� 5���� ���� ���� �� ���� ����
							 else if (xs[count]<23)
						    	 for(int x=xs[count]-1; x>xs[count]-6; x--)
						    	 {
						    		 for(int i=1; i<6; i++)
						    			 if((board[x][ys[count]-1]==board[x][(ys[count]-1)-i]) && (board[x][ys[count]-1]=='��' || board[x][ys[count]-1]=='��' ))
						    				 check +=1;
						    			 else
						    				 break;
						    	 
						    		 if(check==4)
						    		 {
						    			 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[x][ys[count]-1]);  // ���а� �������� ���� ��ǥ (x,y)
						    			 break play;
						    		 }	 
						    	 }
							 
							 // (���� �ֱٿ� ���� ���� ��������) �Ʒ��� 5���� ���� ���� �� ���� ����
							 else if (xs[count]<23)
						    	 for(int x=xs[count]-1; x>xs[count]-6; x--)
						    	 {
						    		 for(int i=1; i<6; i++)
						    			 if((board[x][ys[count]-1]==board[x][(ys[count]-1)-i]) && (board[x][ys[count]-1]=='��' || board[x][ys[count]-1]=='��' ))
						    				 check +=1;
						    			 else
						    				 break;
						    	 
						    		 if(check==4)
						    		 {
						    			 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[x][ys[count]-1]);  // ���а� �������� ���� ��ǥ (x,y)
						    			 break play;
						    		 }	 
						    	 }
							 
							// (���� �ֱٿ� ���� ���� ��������) ���� 5���� ���� ���� �� ���� ����
							 else if (ys[count]<23)
						    	 for(int x=xs[count]-1; x>xs[count]-6; x--)
						    	 {
						    		 for(int i=1; i<6; i++)
						    			 if((board[x][ys[count]-1]==board[x][(ys[count]-1)-i]) && (board[x][ys[count]-1]=='��' || board[x][ys[count]-1]=='��' ))
						    				 check +=1;
						    			 else
						    				 break;
						    	 
						    		 if(check==4)
						    		 {
						    			 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[x][ys[count]-1]);  // ���а� �������� ���� ��ǥ (x,y)
						    			 break play;
						    		 }	 
						    	 }
						 count++; // ������ ���� Ƚ��
						 
						 // ���̻� ���� �ڸ��� ���� ��
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
}



















