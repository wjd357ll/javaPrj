package practice.oop.omok;

import java.util.Scanner;

public class Stone {

	private int x;
	private int y;
	private int type;
	private int check;
	static boolean isWhiteTurn;
	
	private int end;
	
	public Stone(){
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
		 
		 if(!(0<y && y<height) || !(0<x && x<width))
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
		
public int CheckWin(char[][] board) {
		
	    check = 0;
	    end = 0;       //end=1�̸� ���� ����
	 
		 if(board[y][x]=='��' || board[y][x]=='��')
		 {		 
			 // ����
				 for(int i=1; i<5; i++){
					 if(!(x>20))
						 if(board[y][x]== board[y][x+i])
							 check += 1; 
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 for(int i=1; i<5; i++){
					 if(!(i>x))
						 if(board[y][x]== board[y][x-i])
							 check += 1;
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 check = 0;
		    
	       // ����
				 for(int i=1; i<5; i++){
					 if(!(y<i))
						 if(board[y][x]== board[y-i][x])
							 check += 1; 
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 for(int i=1; i<5; i++){
					 if(!(15<y))
						 if(board[y][x]== board[y+i][x])
							 check += 1;
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 check = 0;
				 
	      // ���ʴ밢��
				 for(int i=1; i<5; i++){
					 if(y<i || x<i)
						 continue;
					 if(board[y][x]!= board[y-i][x-i])
						 break;
					 
						 check += 1; 
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 for(int i=1; i<5; i++){
					 if(15<y || x>20)
						 continue;
					 
					 if(board[y][x]!= board[y+i][x+i])
						 break;
					 
							 check += 1;
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 check = 0;
				 
		// ������ �밢�� 
				 for(int i=1; i<5; i++){
					 if(!(y<i || x>20))
						 if(board[y][x]== board[y-i][x+i])
							 check += 1; 
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 for(int i=1; i<5; i++){
					 if(!(15<y || x<i))
						 if(board[y][x]== board[y+i][x-i])
							 check += 1;
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 check = 0;		 
		 }
		 return end; 
	}
	
	public void WinMessage(char[][] board){

		 System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**\n\t���� �޴��� ���ư��ϴ�.\n\n", board[y][x]);
			end = 1; 
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