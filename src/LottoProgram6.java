
// �Լ� ���� �и��ϴ� �ζ� ���α׷�

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class LottoProgram6 {

	public static void genLotto(int[] lotto) //�ڹٿ��� Ŭ�������� ù���ڴ� �ҹ��ڷ� ���� (�ܾ ������ �� �빮�� ���) int[]lotto �̸� �ٲ㵵 �ȴ�. int[]aa ��
	{
		Random rand = new Random();
		
		for(int i=0; i<6; i++)
			lotto[i] = rand.nextInt(); 
	}
	
	public static void printLotto(int[] lotto)
	{
		System.out.print("\n\t\t\t");
		
		for(int i=0; i<6; i++)
			System.out.printf("%d  ", lotto[i]);
	
		System.out.println();
	}
	
	private static void sortLotto(int[] lotto)
	{
		int temp;
		
		for(int j=0; j<5; j++)                                    
			for(int i=0; i<5-j; i++)                          
			{
				if( lotto[i]>lotto[i+1])
				{
					temp = lotto[i];
					lotto[i] = lotto[i+1];
					lotto[i+1] = temp;
				}
			}
	}
	
	public static void main(String[] args) throws IOException {
	
		Scanner scan = new Scanner(System.in);
		
		//�÷��� �ϱ� ���� ������� �Բ� ����� ���� ����
		int [][] lottos = new int[10][6]; 
		int current = -1; 
		
		end:
		while(true)
		{	
			int menu=0; 
			System.out.println("\n\t\t=============�ζ� �޴�===============");
			System.out.println("\n\t\t1. ��ȣ ��� ");
			System.out.println("\t\t2. ��ȣ �б� ");
			System.out.println("\t\t3. ��ȣ ���� ");
			System.out.println("\t\t4. ���� ");
			
			switch(inputMainMenu())
			{
				case 1:
				{
					// �ζ� ��ȣ ����
				//	manageLotto(lottos);
				}
					break;
			
				case 2:
					
					FileInputStream fis = new FileInputStream("res/lotto/lottos.txt");
					
					current = -1; 
					
					int count = fis.read(); // read�� ���� 6���� ���ڰ� �� �� �ִ��� �о��
					
					for(int n=0; n<count; n++) // 10�� �� ���� �ʾҴµ� 10�� ���� ���� ���� ������ count ���
					{
						
						int[] lotto = lottos[n]; 
			
						for(int i=0; i<6; i++)
							lotto[i] = fis.read(); // ���� �о�� �迭�� ����
					
						current++;
					}
					fis.close();
					
					System.out.println("\n\t\t������ �бⰡ �Ϸ�Ǿ����ϴ�.");
					break;
					
				case 3: 
					// ���ڷ� ������ ��
					// "32434567" -> 16 Byte �ʿ� (������)
					// 32434567 -> 4 Byte �ʿ� (������)
					// �� ���ڷ� �����ؾ� �ϴ°� �ƴ϶�� ���ڷ� �����ϴ� ���� ������ ȿ������ ���� �� �ִ�.
					// ���̳ʸ�(����)�� �а� ��������
					
					FileOutputStream fos = new FileOutputStream("res/lotto/lottos.txt");
					fos.write(current+1);
					for(int n=0; n<current+1; n++)
					{
						int[] lotto = lottos[n]; 
						for(int i=0; i<6; i++)
							fos.write(lotto[i]);	
					}
					fos.close();
					
					
					/*FileOutputStream fos = new FileOutputStream("res/lotto/lottos.txt"); 
					PrintStream fout = new PrintStream(fos); 
						
					for(int i=0; i<current+1; i++)
					{
						int[] lotto = lottos[i]; 
						fout.printf("\t%d  %d  %d  %d  %d  %d\r\n", lotto[0],lotto[1],lotto[2],lotto[3],lotto[4],lotto[5]);
					} 
					
					fout.close();
					fos.close();*/
					
					System.out.println("\n\t\t���� �Ϸ��߽��ϴ�.");
					
					break;
					
				case 4:
					System.out.println("\n\t\t�ζ� ���α׷��� �����մϴ�.");
					break end;
			}
			
		}
	}

	private static void manageLotto(int[][] lottos, int current) {
		
		stop:
			while(true)
			{
				Scanner scan = new Scanner(System.in);
				int submenu = 0;
				
				System.out.println("\n\t\t=============�ζ� ���===============\n");
				
				// ��� ��� �ڵ带 �ۼ� (����Ǿ� �ִ� ��ȣ ���)
				
				if(current==-1)
					System.out.println("\t\t\t  ����� ��ȣ�� �����ϴ�!");
				
				for(int i=0; i<current+1; i++)
				{
					int[] lotto = lottos[i]; 
					System.out.printf("\t\t\t%d  :  %d  %d  %d  %d  %d  %d\n", i+1,lotto[0],lotto[1],lotto[2],lotto[3],lotto[4],lotto[5]);
				}
				
				System.out.println("\n\t\t====================================\n");
				System.out.println("\t\t1. ��ȣ ���� ");
				System.out.println("\t\t2. ��ȣ �Է� ");
				System.out.println("\t\t3. ���� �޴��� �̵� ");
				System.out.print("\n\t\t�޴��� �����ϼ��� : ");
				submenu = scan.nextInt();
				
				switch(submenu)
				{
					case 1: 
					{
						
						Random rand = new Random();
						int[] lotto = new int[6]; 
						int temp;
						int check = 0;
						
						for(int i=0; i<6; i++)
							lotto[i] = rand.nextInt(); 
	
						//���� : �ߺ� �˻� �Է� (���ѷ����� ������ �ʵ��� ����)
						
						do
						{
							check = 0;
							
							for(int i=0; i<6; i++)	
								lotto[i] = rand.nextInt(45)+1;
							
							for(int i=0; i<6; i++)	
								for(int j=i+1; j<6; j++)
										if(lotto[i]== lotto[j])
											check++;

						}while(check!=0);
						
						//�����ϱ�
						
						for(int j=0; j<5; j++)                                    
							for(int i=0; i<5-j; i++)                          
							{
								if( lotto[i]>lotto[i+1])
								{
									temp = lotto[i];
									lotto[i] = lotto[i+1];
									lotto[i+1] = temp;
								}
							}
						
						// �������� ���� ��ȣ ���
						System.out.print("\n\t\t\t");
						
						for(int i=0; i<6; i++)
							System.out.printf("%d  ", lotto[i]);

						System.out.println();
						
						
						//lotto�� �ִ� ���� lottos�� �ű�� �۾�
						++current; 
						
						for(int i=0; i<6; i++)
							lottos[current][i]=lotto[i]; 
					}
						break;
					
					case 2:
						break;
					
					case 3:
						break stop; // while���� ���
				}
			}
	}

	private static int inputMainMenu() {

		int menu;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n\t\t�޴��� �����ϼ��� : ");
		menu = scan.nextInt();
		
		return menu;
	}
}
