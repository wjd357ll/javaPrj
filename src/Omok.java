import java.util.Scanner;

public class Omok {

	int height; 
	int width; 
	char [][] board ; 
	int[] xs; 
	int[] ys; 
	
	int count;
	int check;
	int end;
	
	
	public void drawBoard() {

		height = 20;
		width = 25;
		board = new char[height][width] ;
		
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
	
	public void putOmokStone() {

			 if(count%2==0)
				 board[xs[count]-1][ys[count]-1]='��'; 
			 else
				 board[xs[count]-1][ys[count]-1]='��';
		 
		 printBoard(); // ������ ���
	}
	
	public void printBoard() {
		
		for(int x=0; x<height; x++)
		 {
			 for(int y=0; y<width; y++)
				 System.out.printf("%c", board[x][y]);
			
			 System.out.println();
		 }
		
	}
	
	public void inputXY(){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n\t���ϴ� ��ǥ�� �Է��ϼ��� (x sp y) : ");
		 xs[count] = scan.nextInt();
		 ys[count] = scan.nextInt();
	}
	
	public int outOfBoard(){
		
		 // ��������� ����� ��ǥ�� �Է��� ����
		
		end = 0; //end�� 0���� �ʱ�ȭ
		 
		 if(!(0<xs[count] && xs[count]<height+1) || !(0<ys[count] && ys[count]<width+1))
		 {
			 System.out.println("\n\t�������� ��� ��ġ�Դϴ�. �ٽ� �Է����ּ���.");
			 end = 1;
			 count--;
		 }
		 return end;
	}
	
	public int overLap(){
		
		 // ���̹� �ٸ� ���� ���� ��ǥ�� �Է��� ��� (�ߺ�)��
		
		end = 0; //end�� 0���� �ʱ�ȭ
		 
		 if(board[xs[count]-1][ys[count]-1]=='��' || board[xs[count]-1][ys[count]-1]=='��')
		 {
			 System.out.println("\n\t�̹� �ٸ� ������ �ֽ��ϴ�. �ٸ� ��ǥ�� �Է����ּ���.");
			end=1;
			count--;
		 }
		 return end;
	}
	
	// ���� ���� �˻�
	public int horisontalWin() {
		
	    check = 0;
	    end = 0;       //end=1�̸� ���� ����
	 
		 if(board[xs[count]-1][ys[count]-1]=='��' || board[xs[count]-1][ys[count]-1]=='��')
		 {		 
			 // (�ֱٿ� ���� ��)�ۡۡۡ� �� ���
				 for(int i=1; i<5; i++){
					 if(!((ys[count]-1)>20))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][ys[count]-1+i])
							 check += 1; 
				 }
				 if(check==4) {
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
					end = 1; 
				 }
				 check = 0;
		    
	       // ��(�ֱٿ� ���� ��)�ۡۡ� �� ��� 
				 for(int i=1; i<4; i++){
					 if(!((ys[count]-1)>21))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][ys[count]-1+i])
							 check += 1;
				 }
				 if(check==3)
					 if(!((xs[count]-1)<1))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][(ys[count]-1)-1])
							 check += 1;
				 if(check==4){
					 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
					 end = 1; 
				 }
				 check = 0;
				 
	      // �ۡ�(�ֱٿ� ���� ��)�ۡ� �� ��� 
				 for(int i=1; i<3; i++){
					 if(!((ys[count]-1)>22))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][ys[count]-1+i])
							 check += 1;
				 }
				 if(check==2)
					 for(int i=1; i<3; i++){
						 if(!((xs[count]-1)<2))
							 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][(ys[count]-1)-i])
								 check += 1;
					 }
				 if(check==4){
					 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
					 end = 1; 
					}
				 check = 0;
				 
		// �ۡۡ�(�ֱٿ� ���� ��)�� �� ��� 
				 for(int i=1; i<4; i++){
					 if(!((ys[count]-1)<3))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][ys[count]-1-i])
							 check += 1;
				 }
				 if(check==3)
					 if(!((ys[count]-1)>23))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][(ys[count]-1)+1])
							 check += 1;
				 if(check==4){
					 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
					 end = 1; 
					}
				 check = 0;
				 
		// �ۡۡۡ�(�ֱٿ� ���� ��) �� ���
				 for(int i=1; i<5; i++){
					 if(!((ys[count]-1)<4))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][ys[count]-1-i])
							 check += 1;
				 }
						 
				 if(check==4){
					 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
					 end = 1; 
				   }
				 check = 0;
	 	}
		 return end;
	}

// ���� ���� �˻�
	public int verticalWin(){

		check = 0;
		end = 0;      //end=1�̸� ���� ����
		
		 if(board[xs[count]-1][ys[count]-1]=='��' || board[xs[count]-1][ys[count]-1]=='��')
		 {		 
		 	// (�ֱٿ� ���� ��)�ۡۡۡۡ� �� ���
			 for(int i=1; i<5; i++){
				 if(!((xs[count]-1)>15))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1])
						 check += 1;
			 }
			 if(check==4) {
			 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
			 end = 1; 
			 }
			 check = 0;
	    
			 // ���(�ֱٿ� ���� ��)�ۡۡۡ� �� ��� 
			 for(int i=1; i<4; i++){
				 if(!((xs[count]-1)>16))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1])
						 check += 1;
			 }
			 if(check==3)
				 if(!((xs[count]-1)<1))
					 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)-1][ys[count]-1])
						 check += 1;
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
			 }
			 check = 0;
			 
			 // ��ۡ�(�ֱٿ� ���� ��)�ۡۡ� �� ��� 
			 for(int i=1; i<3; i++){
				 if(!((xs[count]-1)>17))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1])
						 check += 1;
			 }
			 if(check==2)
				 for(int i=1; i<3; i++){
					 if(!((xs[count]-1)<2))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1])
							 check += 1;
				 }
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
				}
			 check = 0;
			 
			 // ��ۡۡ�(�ֱٿ� ���� ��)�ۡ� �� ��� 
			 for(int i=1; i<4; i++){
				 if(!((xs[count]-1)<3))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1])
						 check += 1;
			 }
			 if(check==3)
				 if(!((xs[count]-1)>18))
					 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)+1][ys[count]-1])
						 check += 1;
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
				}
			 check = 0;
			 
			 // ��ۡۡۡ�(�ֱٿ� ���� ��) �� ���
			 for(int i=1; i<5; i++){
				 if(!((xs[count]-1)<4))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1])
						 check += 1;
			 }
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
			   }
			 check = 0;
	 }
		 return end;
}

// ������ �밢�� ���� �˻�
	public int rightDiagonalWin(){
		

	
		check = 0;
		end = 0;       //end=1�̸� ���� ����
		
				 if(board[xs[count]-1][ys[count]-1]=='��' || board[xs[count]-1][ys[count]-1]=='��')
				 {		 
				 	// (�ֱٿ� ���� ��)�ۡۡۡۢ� �� ���
					 for(int i=1; i<5; i++){
						 if(!((xs[count]-1)>15 || (ys[count]-1)>20))
							 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1+i])
								 check += 1;
					 }
					 if(check==4) {
					 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
					 end = 1; 
					 }
					 check = 0;
			    
					 // �ء�(�ֱٿ� ���� ��)�ۡۡۢ� �� ��� 
					 for(int i=1; i<4; i++){
						 if(!((xs[count]-1)>16 || (ys[count]-1)>21))
							 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1+i])
								 check += 1;
					 }
					 if(check==3)
						 if(!((xs[count]-1)<1 || (ys[count]-1) <1))
							 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)-1][(ys[count]-1)-1])
								 check += 1;
					 if(check==4){
						 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
						 end = 1; 
					 }
					 check = 0;
					 
					 // �ءۡ�(�ֱٿ� ���� ��)�ۡۢ� �� ��� 
					 for(int i=1; i<3; i++){
						 if(!((xs[count]-1)>17 || (ys[count]-1)>22))
							 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1+i])
								 check += 1;
					 }
					 if(check==2)
						 for(int i=1; i<3; i++){
							 if(!((xs[count]-1)<2 || (ys[count]-1) <2))
								 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1-i])
									 check += 1;
						 }
					 if(check==4){
						 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
						 end = 1; 
						}
					 check = 0;
					 
					 // �ءۡۡ�(�ֱٿ� ���� ��)�ۢ� �� ��� 
					 for(int i=1; i<4; i++){
						 if(!((xs[count]-1)<3 || (ys[count]-1) <3))
							 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1-i])
								 check += 1;
					 }
					 if(check==3)
						 if(!((xs[count]-1)>18 || (ys[count]-1)>23))
							 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)+1][(ys[count]-1)+1])
								 check += 1;
					 if(check==4){
						 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
						 end = 1; 
						}
					 check = 0;
					 
					 // �ءۡۡۡ�(�ֱٿ� ���� ��) �� ���
					 for(int i=1; i<5; i++){
						 if(!((xs[count]-1)<4 || (ys[count]-1) <4))
							 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1-i])
								 check += 1;
					 }
					 if(check==4){
						 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
						 end = 1; 
					   }
					 check = 0;
			 }
				 return end;
		}

// ���� �밢�� ���� �˻�
	public int leftDiagonalWin(){
		
		check = 0;
		end = 0;        //end=1�̸� ���� ����
		
		 if(board[xs[count]-1][ys[count]-1]=='��' || board[xs[count]-1][ys[count]-1]=='��')
		 {		 
		 	// (�ֱٿ� ���� ��)�ۡۡۡۢ� �� ���
			 for(int i=1; i<5; i++){
				 if(!((xs[count]-1)<4 || (ys[count]-1)>20))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1+i])
						 check += 1;
			 }
			 if(check==4) {
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
			 }
			 check = 0;
	    
			 // �ס�(�ֱٿ� ���� ��)�ۡۡۢ� �� ��� 
			 for(int i=1; i<4; i++){
				 if(!((xs[count]-1)<3 || (ys[count]-1)>21))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1+i])
						 check += 1;
			 }
			 if(check==3)
				 if(!((xs[count]-1)>18 || (ys[count]-1) <1))
					 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)-1][(ys[count]-1)+1])
						 check += 1;
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
			 }
			 check = 0;
			 
			 // �סۡ�(�ֱٿ� ���� ��)�ۡۢ� �� ��� 
			 for(int i=1; i<3; i++){
				 if(!((xs[count]-1)>17 || (ys[count]-1) <2))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1-i])
						 check += 1;
			 }
			 if(check==2)
				 for(int i=1; i<3; i++){
					 if(!((xs[count]-1)<2 || (ys[count]-1)>22))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1+i])
							 check += 1;
				 }
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
				}
			 check = 0;
			 
			 // �סۡۡ�(�ֱٿ� ���� ��)�ۢ� �� ��� 
			 for(int i=1; i<4; i++){
				 if(!((xs[count]-1)>16 || (ys[count]-1) <3))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1-i])
						 check += 1;
			 }
			 if(check==3)
				 if(!((xs[count]-1)<1 || (ys[count]-1)>23))
					 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)-1][(ys[count]-1)+1])
						 check += 1;
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
				}
			 check = 0;
			 
			 // �סۡۡۡ�(�ֱٿ� ���� ��) �� ���
			 for(int i=1; i<5; i++){
				 if(!((xs[count]-1)>15 || (ys[count]-1) <4))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1-i])
						 check += 1;
			 }
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
			   }
			 check = 0;
	 }
		 return end;
}
	
	public int draw(){
		
	 // �� ���º� : ���̻� ���� �ڸ��� ���� �� 
	 
		end = 0;
		
		if(count>=500)
		{
		 System.out.println("\n\t���̻� ���� �ڸ��� �����ϴ�. ���º�! \n\t������ �����ϰ� ���� �޴��� ���ư��ϴ�.");
		 end = 1;
	 	}
		return end;
	}
}
