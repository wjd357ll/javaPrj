package app.omok;

public class Game {

	public static void main(String[] args) {

		Board board = new Board();

		while(true)
		{
				board.print();
	
				Stone stone = new Stone();
				
				stone.input();
				
				boolean duplicated = board.checkDuplicated(stone);
				
				if(duplicated == true)
					printError();
				else
					board.add(stone); //board���� stone �ѱ��. board�� stone�� ������ ������ �ϴ� ���� ���� ������( ȣ������ �ʱ� ���� )
				
				//board.putStone(stone); add�ȿ� ��
				//stone.put(board.getBuf());  
		}	
	}
	
	public static void printError() {
		
		System.out.println("\n\t�̹� �ٸ� ������ �ֽ��ϴ�. �ٸ� ��ǥ�� �Է����ּ���.");
	}
}
