import java.util.Scanner;

public class OmokProgram5 {

	public static void main(String[] args) {
		
		int height = 20;
		int width = 25;
		int[] xs = new int[500];
		int[] ys = new int[500];
		int[] types = new int[500];
		int count = 0;
		
		Scanner scan = new Scanner(System.in);
		
		// ������ �迭 ����
		
		char[][] board = new char[height][width]; // 500�̶�� ���� ���ٸ� 20*25��� ���� �� ���߿� ���� ����.
		
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
		
		int otype;
		
		for(int x=0; x<height; x++)
		{
			for(int y=0; y<width; y++)
				System.out.printf("%c", board[x][y]); // board[j]��� �ۼ��ϸ� ù ���� ��� �ݺ��Ǵ� �� (400���� �迭 �� ����ؾ��Ѵ�.)
			
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
			
				if(!(0<=(xs[count]-1) && (xs[count]-1)<=20) || !(0<=(ys[count]-1) && (ys[count]-1)<=20))
				{
					System.out.println("\n\t��ǥ�� ������ϴ�. �ٸ� ���� ��������.");
					continue;
				}
				
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
					board[ys[i]-1][xs[i]-1] = '��'; // �迭�� 0���� �����ϹǷ� 1�� ���ش�.
				else
					board[ys[i]-1][xs[i]-1] = '��';
			}
			// ������ ���
			
			for(int x=0; x<height; x++)
			{
				for(int y=0; y<width; y++)
					System.out.printf("%c", board[x][y]); // board[j]��� �ۼ��ϸ� ù ���� ��� �ݺ��Ǵ� �� (400���� �迭 �� ����ؾ��Ѵ�.)
				
				System.out.println();
			}
			
			/* ���� �̰��� �� ���� �ڵ� ����
			
			whitewin :
			for(int x=0; x<height; x++)
				for(int y=0; y<width; y++)
				{
					for(int i=0; i<5; i++)
					{
						if(board[x][y]!='��')
							break whitewin;
					}
					System.out.println("\n\t***Congratulation***\n\t�� ���� �̰���ϴ�!\n");
					break play;
				}
			
			blackwin :
				for(int x=0; x<height; x++)
					for(int y=0; y<width; y++)
					{
						for(int i=0; i<5; i++)
							if(board[x][y]!='��')
								break blackwin;
						
						System.out.println("\n\t***Congratulation***\n\t�� ���� �̰���ϴ�!\n");
						break play;
					}*/
			
			// ���� �̰��� �� ���� ����
			
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
				System.out.println("\t�� �̻� �� ���� �����ϴ�.");
				break play;
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}

}
