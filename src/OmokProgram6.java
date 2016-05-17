import java.util.Scanner;

public class OmokProgram6 {

	public static void main(String[] args) {
		
		int height = 20;
		int width = 25;
		int[] xs = new int[500];
		int[] ys = new int[500];

		int count = 0;
		
		Scanner scan = new Scanner(System.in);
		
		// ������ �迭 ����
		
		char[][] board = new char[height][width];
		
		// ������ �ʱ�ȭ
		
		for(int x=0; x<height; x++)
			for(int y=0; y<width; y++)
				board[x][y] = '��';
		
		// �׵θ� �׸���
		
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
		
		for(int x=0; x<height; x++)
		{
			for(int y=0; y<width; y++)
				System.out.printf("%c", board[x][y]); 
			
			System.out.println();
		}
		
		play :
		while(true)
		{
			place :
			while(true)
			{
				System.out.print("\n\t���� �α� (x sp y) : ");
				xs[count]=scan.nextInt();
				ys[count]=scan.nextInt();
			
				//�ٵ��� ��ǥ�� ��� ���
				if(!(0<=(xs[count]-1) && (xs[count]-1)<=20) || !(0<=(ys[count]-1) && (ys[count]-1)<=20))
				{
					System.out.println("\n\t��ǥ�� ������ϴ�. �ٸ� ���� ��������.");
					continue;
				}
				
				//�ߺ��� ���
				if(board[ys[count]-1][xs[count]-1]=='��' || board[ys[count]-1][xs[count]-1]=='��')
					System.out.println("\n\t�̹� ���� �ڸ��Դϴ�. �ٸ� ���� ��������.");
				else
					break place;
				
				System.out.println();
			}
			count++;
	
			// ����� �Է¿� ���� ��ġ�� ������ �δ� ����
			
			for(int i=0; i<count; i++)
			{
				if(i%2==0)
					board[ys[i]-1][xs[i]-1] = '��'; 
				else
					board[ys[i]-1][xs[i]-1] = '��';
			}
			// ������ ���
			
			for(int x=0; x<height; x++)
			{
				for(int y=0; y<width; y++)
					System.out.printf("%c", board[x][y]); 
				
				System.out.println();
			}
			
			// ���� �̰��� �� ���� ���� (�ȵ˴ϴ�...........�Ф�)
			
			int check = 0;
			
			end :
			for(int x=0; x<4; x++)
			{
				for(int y=0; y<4; y++)
				{
					if(board[xs[count]][ys[count]]!=board[xs[count]][ys[count]+1])
						break end;
					else
						check++;
				}
				if(check==4)
				{
					System.out.printf("\n\t**�����մϴ�! %c �� �̰���ϴ�**", board[xs[count]][ys[count]]);
					System.out.println("\n\t������ �����մϴ�.");
					break play;
				}
			}
				
			// �� �̻� �� ���� ������ ����
			
			if(count>=500)
			{
				System.out.println("\t�� �̻� �� ���� �����ϴ�. ���º�!");
				break play;
			}		
			
		}
	}

}
