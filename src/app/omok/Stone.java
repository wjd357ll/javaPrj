package app.omok;

import java.util.Scanner;

public class Stone {

	private int x;
	private int y;
	private int type; // ���� �ϳ�(��ü �ϳ�)�� �ϳ��� �� �ʿ��� ������
	
	private static boolean isWhiteTurn; // �������� ���� ������ ��ü���� �ϳ��� �ʿ��� ���� (static)
	
	// isWhiteTurn�� ��ü���� ���� ���� �ƴϴ�. ���� static���� �������ָ� ���� ��ü���� ����ص� ���� ������ �ȴ�.
	// ��ü ������ ������ ȣ���ϰ� �ϸ� ��� false�� �����ϱ� ������ static���� �����ؾ� �Ѵ�.
	
	static{
		isWhiteTurn = false; // static ������ �ʱ�ȭ�ϴ� ���
	}
	
	public Stone(){
		x = -1;
		y = -1;
		type = 1; // 1 : ������ 2 : ��
	}
	
	public static boolean isWhiteTurn() {
		return isWhiteTurn;
	}

	public static void setWhiteTurn(boolean isWhiteTurn) {
		Stone.isWhiteTurn = isWhiteTurn;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void input(){
	
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n\t���ϴ� ��ǥ�� �Է��ϼ��� (x sp y) : ");
		 x = scan.nextInt();
		 y = scan.nextInt();
		 
		type = isWhiteTurn ? 2 : 1; // type �� ���ϱ�
	}
 
	public static void toggleTurn() {
		isWhiteTurn = !isWhiteTurn;
	}
	

	
}
