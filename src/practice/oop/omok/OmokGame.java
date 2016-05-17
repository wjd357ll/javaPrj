package practice.oop.omok;

import java.util.Scanner;

public class OmokGame {

	public static void main(String[] args) {
		
		game : 
		while(true)
		{
			switch(inputMainMenu())
			{
				case 1:
				{
					Board board = new Board();
					board.print();
					
					play :
					while(true)
					{	
						Stone stones = new Stone();
						
						stones.input();
						
						if(stones.outOfBoard(board.getHeight(), board.getWidth())==1)
							continue;
						
						if(stones.overLap(board.getBoard())==1)
							continue;
						
						stones.put(board.getBoard());
						
						board.print();
						 
						// ������ �˻�
						
						if(stones.CheckWin(board.getBoard())==1)
							break play;
						
						 // ����̻� ���� �ڸ��� ���� ��
						 
						 if(stones.draw()==1)
							 break play;
					}
				}
				break;
				
				case 2:
					System.out.println("\n\t������ �����մϴ�.");
					break game;
					
				default :
					System.out.println("\n\t�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
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
