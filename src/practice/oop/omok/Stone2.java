package practice.oop.omok;

import java.util.Scanner;

public class Stone2 {

	private int x;
	private int y;
	private int type;
	private int check;
	static boolean isWhiteTurn;
	
	private int end;
	
	public Stone2(){
		x = -1;
		y = -1;
		type = 0; // ��
		end = 0;
		check = 0;
	}
	
	static{
		isWhiteTurn = false; 
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void input(){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n\t���ϴ� ��ǥ�� �Է��ϼ��� (x sp y) : ");
		 x = scan.nextInt();
		 y = scan.nextInt();
		 
		 type = isWhiteTurn ? 0 : 1;
		isWhiteTurn = !isWhiteTurn;
	}
	
	public void put(char[][] board){
		
		board[y][x] = (type==0) ? '��' : '��';
	}


	public int outOfBoard(int height, int width){
		
		 // ��������� ����� ��ǥ�� �Է��� ����
		
		end = 0; //end�� 0���� �ʱ�ȭ
		 
		 if(!(0<y && y<height+1) || !(0<x && x<width+1))
		 {
			 System.out.println("\n\t�������� ��� ��ġ�Դϴ�. �ٽ� �Է����ּ���.");
			 end = 1;
			 isWhiteTurn = !isWhiteTurn;
		 }
		 return end;
	}
	
	public int overLap(char[][] board){
		
		 // ���̹� �ٸ� ���� ���� ��ǥ�� �Է��� ��� (�ߺ�)��
		
		end = 0; //end�� 0���� �ʱ�ȭ
		 
		 if(board[y][x]=='��' || board[y][x]=='��')
		 {
			 System.out.println("\n\t�̹� �ٸ� ������ �ֽ��ϴ�. �ٸ� ��ǥ�� �Է����ּ���.");
			end=1;
			isWhiteTurn = !isWhiteTurn;
		 }
		 return end;
	}

		public int horisontalWin(char[][] board) {
	
    check = 0;
    end = 0;       //end=1�̸� ���� ����
 
	 if(board[y][x]=='��' || board[y][x]=='��')
	 {		 
		 // (�ֱٿ� ���� ��)�ۡۡۡ� �� ���
			 for(int i=1; i<5; i++){
				 if(!(x>20))
					 if(board[y][x]== board[y][x+i])
						 check += 1; 
			 }
			 if(check==4) {
			 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
				end = 1; 
			 }
			 check = 0;
	    
       // ��(�ֱٿ� ���� ��)�ۡۡ� �� ��� 
			 for(int i=1; i<4; i++){
				 if(!(x>21))
					 if(board[y][x]== board[y][x+i])
						 check += 1;
			 }
			 if(check==3)
				 if(!(y<1))
					 if(board[y][x]== board[y][x-1])
						 check += 1;
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
				 end = 1; 
			 }
			 check = 0;
			 
      // �ۡ�(�ֱٿ� ���� ��)�ۡ� �� ��� 
			 for(int i=1; i<3; i++){
				 if(!(x>22))
					 if(board[y][x]== board[y][x+i])
						 check += 1;
			 }
			 if(check==2)
				 for(int i=1; i<3; i++){
					 if(!(y<2))
						 if(board[y][x]== board[y][x-i])
							 check += 1;
				 }
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
				 end = 1; 
				}
			 check = 0;
			 
	// �ۡۡ�(�ֱٿ� ���� ��)�� �� ��� 
			 for(int i=1; i<4; i++){
				 if(!(x<3))
					 if(board[y][x]== board[y][x-i])
						 check += 1;
			 }
			 if(check==3)
				 if(!(x>23))
					 if(board[y][x]== board[y][x+1])
						 check += 1;
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
				 end = 1; 
				}
			 check = 0;
			 
	// �ۡۡۡ�(�ֱٿ� ���� ��) �� ���
			 for(int i=1; i<5; i++){
				 if(!(x<4))
					 if(board[y][x]== board[y][x-i])
						 check += 1;
			 }
					 
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
				 end = 1; 
			   }
			 check = 0;
 	}
	 return end;
}

// ���� ���� �˻�
	public int verticalWin(char[][] board){

		check = 0;
		end = 0;      //end=1�̸� ���� ����
		
		 if(board[y][x]=='��' || board[y][x]=='��')
		 {		 
		 	// (�ֱٿ� ���� ��)�ۡۡۡۡ� �� ���
			 for(int i=1; i<5; i++){
				 if(!((y>15)))
					 if(board[y][x]== board[y+i][x])
						 check += 1;
			 }
			 if(check==4) {
			 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
			 end = 1; 
			 }
			 check = 0;
	    
			 // ���(�ֱٿ� ���� ��)�ۡۡۡ� �� ��� 
			 for(int i=1; i<4; i++){
				 if(!(y>16))
					 if(board[y][x]== board[y+i][x])
						 check += 1;
			 }
			 if(check==3)
				 if(!(y<1))
					 if(board[y][x]== board[y-1][x])
						 check += 1;
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
				 end = 1; 
			 }
			 check = 0;
			 
			 // ��ۡ�(�ֱٿ� ���� ��)�ۡۡ� �� ��� 
			 for(int i=1; i<3; i++){
				 if(!(y>17))
					 if(board[y][x]== board[y+i][x])
						 check += 1;
			 }
			 if(check==2)
				 for(int i=1; i<3; i++){
					 if(!(y<2))
						 if(board[y][x]== board[y-i][x])
							 check += 1;
				 }
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
				 end = 1; 
				}
			 check = 0;
			 
			 // ��ۡۡ�(�ֱٿ� ���� ��)�ۡ� �� ��� 
			 for(int i=1; i<4; i++){
				 if(!(y<3))
					 if(board[y][x]== board[y-i][x])
						 check += 1;
			 }
			 if(check==3)
				 if(!(y>18))
					 if(board[y][x]== board[y+1][x])
						 check += 1;
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
				 end = 1; 
				}
			 check = 0;
			 
			 // ��ۡۡۡ�(�ֱٿ� ���� ��) �� ���
			 for(int i=1; i<5; i++){
				 if(!(y<4))
					 if(board[y][x]== board[y-i][x])
						 check += 1;
			 }
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
				 end = 1; 
			   }
			 check = 0;
	 }
		 return end;
}

// ���� �밢�� ���� �˻�
	public int rightDiagonalWin(char[][] board){
		

	
		check = 0;
		end = 0;       //end=1�̸� ���� ����
		
				 if(board[y][x]=='��' || board[y][x]=='��')
				 {		 
				 	// (�ֱٿ� ���� ��)�ۡۡۡۢ� �� ���
					 for(int i=1; i<5; i++){
						 if(!(y>15 || x>20))
							 if(board[y][x]== board[y+i][x+i])
								 check += 1;
					 }
					 if(check==4) {
					 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
					 end = 1; 
					 }
					 check = 0;
			    
					 // �ء�(�ֱٿ� ���� ��)�ۡۡۢ� �� ��� 
					 for(int i=1; i<4; i++){
						 if(!(y>16 || x>21))
							 if(board[y][x]== board[y+i][x+i])
								 check += 1;
					 }
					 if(check==3)
						 if(!(y<1 || x<1))
							 if(board[y][x]== board[y-1][x-1])
								 check += 1;
					 if(check==4){
						 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
						 end = 1; 
					 }
					 check = 0;
					 
					 // �ءۡ�(�ֱٿ� ���� ��)�ۡۢ� �� ��� 
					 for(int i=1; i<3; i++){
						 if(!(y>17 || x>22))
							 if(board[y][x]== board[y+i][x+i])
								 check += 1;
					 }
					 if(check==2)
						 for(int i=1; i<3; i++){
							 if(!(y<2 || x <2))
								 if(board[y][x]== board[y-i][x-i])
									 check += 1;
						 }
					 if(check==4){
						 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
						 end = 1; 
						}
					 check = 0;
					 
					 // �ءۡۡ�(�ֱٿ� ���� ��)�ۢ� �� ��� 
					 for(int i=1; i<4; i++){
						 if(!(y<3 || x<3))
							 if(board[y][x]== board[y-i][x-i])
								 check += 1;
					 }
					 if(check==3)
						 if(!(y>18 || x>23))
							 if(board[y][x]== board[y+1][x+1])
								 check += 1;
					 if(check==4){
						 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
						 end = 1; 
						}
					 check = 0;
					 
					 // �ءۡۡۡ�(�ֱٿ� ���� ��) �� ���
					 for(int i=1; i<5; i++){
						 if(!(y<4 || x<4))
							 if(board[y][x]== board[y-i][x-i])
								 check += 1;
					 }
					 if(check==4){
						 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
						 end = 1; 
					   }
					 check = 0;
			 }
				 return end;
		}

// ������ �밢�� ���� �˻�
	public int leftDiagonalWin(char[][] board){
		
		check = 0;
		end = 0;        //end=1�̸� ���� ����
		
		 if(board[y][x]=='��' || board[y][x]=='��')
		 {		 
		 	// (�ֱٿ� ���� ��)�ۡۡۡۢ� �� ���
			 for(int i=1; i<5; i++){
				 if(!(y<4 || x>20))
					 if(board[y][x]== board[y-i][x+i])
						 check += 1;
			 }
			 if(check==4) {
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
				 end = 1; 
			 }
			 check = 0;
	    
			 // �ס�(�ֱٿ� ���� ��)�ۡۡۢ� �� ��� 
			 for(int i=1; i<4; i++){
				 if(!(y<3 || x>21))
					 if(board[y][x]== board[y-i][x+i])
						 check += 1;
			 }
			 if(check==3)
				 if(!(y>18 || x <1))
					 if(board[y][x]== board[y+1][x-1])
						 check += 1;
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
				 end = 1; 
			 }
			 check = 0;
			 
			 // �סۡ�(�ֱٿ� ���� ��)�ۡۢ� �� ��� 
			 for(int i=1; i<3; i++){
				 if(!(y>17 || x<2))
					 if(board[y][x]== board[y+i][x-i])
						 check += 1;
			 }
			 if(check==2)
				 for(int i=1; i<3; i++){
					 if(!(y<2 || x>22))
						 if(board[y][x]== board[y-i][x+i])
							 check += 1;
				 }
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
				 end = 1; 
				}
			 check = 0;
			 
			 // �סۡۡ�(�ֱٿ� ���� ��)�ۢ� �� ��� 
			 for(int i=1; i<4; i++){
				 if(!(y>16 || x <3))
					 if(board[y][x]== board[y+i][x-i])
						 check += 1;
			 }
			 if(check==3)
				 if(!(y<1 || x>23))
					 if(board[y][x]== board[y-1][x+1])
						 check += 1;
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
				 end = 1; 
				}
			 check = 0;
			 
			 // �סۡۡۡ�(�ֱٿ� ���� ��) �� ���
			 for(int i=1; i<5; i++){
				 if(!(y>15 || x<4))
					 if(board[y][x]== board[y+i][x-i])
						 check += 1;
			 }
			 if(check==4){
				 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
				 end = 1; 
			   }
			 check = 0;
	 }
		 return end;
}

		public int draw(){
			
		 // �� ���º� : ���̻� ���� �ڸ��� ���� �� 
		 
			end = 0;
			
			if(x>=500)
			{
			 System.out.println("\n\t���̻� ���� �ڸ��� �����ϴ�. ���º�! \n\t������ �����ϰ� ���� �޴��� ���ư��ϴ�.");
			 end = 1;
		 	}
			return end;
		}
}