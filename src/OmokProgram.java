import java.util.Scanner;

public class OmokProgram {

	public static void main(String[] args) {
		
		int height = 20;
		int width = 20;
		
		// ������ �迭 ����
		char[] board = new char[height * width]; // 400�̶�� ���� ���ٸ� 20*20�̶�� ���� �� ���߿� ���� ����.
		
		// ������ �ʱ�ȭ
		for(int i=0; i<400; i++) 
			board[i] = '��';
		
		// ��ǥ�� �̿��� ���� �α� �Ǵ� �׵θ� �׸���
		board[width*0 + 0] = '��';
		board[width*0 + 19] = '��';
		board[width*19 + 19] = '��';
		board[width*19 + 0] = '��';
		
		board[width*(3-1) + (3-1)] = '��';
		
		// ������ ���
		for(int i=0; i<height; i++)
		{
			for(int j=0; j<width; j++)
				System.out.printf("%c", board[j + i*height]); //board[j]��� �ۼ��ϸ� ù ���� ��� �ݺ��Ǵ� �� (400���� �迭 �� ����ؾ��Ѵ�.)
			
			System.out.println();
		}
	}

}
