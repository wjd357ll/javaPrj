import java.util.Scanner;

public class OmokProgram3 {

	public static void main(String[] args) {
		
		int height = 20;
		int width = 25;
		int[] xs = new int[400];
		int[] ys = new int[400];
		int[] types = new int[400];
		int count = 0;
		
		
		// ������ �迭 ����
		
		char[][] board = new char[height][width]; // 400�̶�� ���� ���ٸ� 20*20�̶�� ���� �� ���߿� ���� ����.
		
		// ������ �ʱ�ȭ
		
		for(int x=0; x<height; x++)
			for(int y=0; y<width; y++)
				board[x][y] = '��';
		
		// �׵θ� �׸��� : ���ڷ��̼� (����⿡�� �켱������ �ִ�. - Ưȭ�� ���� �� ����)
		
		for(int i=0; i<width; i++)
			board[0][i]='��';
		
		for(int i=0; i<width; i++)
			board[height-1][i]='��';
		
		for(int i=0; i<height; i++)
			board[i][0]='��';
		
		for(int i=0; i<height; i++)
			board[i][width-1]='��';
		
		board[0][0] = '��';
		board[0][width-1] = '��';
		board[height-1][width-1] = '��';
		board[height-1][0] = '��';
		
		// ����� �Է��� �޴� ����
		
		int ox;
		int oy;
		int otype;
		
		ox=5;
		oy=7;
		otype=1; // �Ͼᵹ 1, ������ 2
		
		xs[count] = ox;
		ys[count] = oy;
		types[count] = otype;
		count++;
		
		// ����� �Է¿� ���� ��ġ�� ������ �δ� ����
		
		for(int i=0; i<count; i++)
			board[ys[i]-1][xs[i]-1] = '��'; // �迭�� 0���� �����ϹǷ� 1�� ���ش�.
		
		// ������ ���
		
		for(int x=0; x<height; x++)
		{
			for(int y=0; y<width; y++)
				System.out.printf("%c", board[x][y]); // board[j]��� �ۼ��ϸ� ù ���� ��� �ݺ��Ǵ� �� (400���� �迭 �� ����ؾ��Ѵ�.)
			
			System.out.println();
		}
	}

}
