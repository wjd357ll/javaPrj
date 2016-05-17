import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class LottoProgram8 {

	public static void main(String[] args) throws IOException  {
	
		Scanner scan = new Scanner(System.in);
		
		int menu =0;
		int current = -1;
		int[][] lottos = new int[10][6];
		
		endLotto:
		while(true)
		{
			System.out.println("\n\t\t=============�ζ� �޴�===============");
			System.out.println("\n\t\t1. ��ȣ ��� ");
			System.out.println("\t\t2. ��ȣ �б� ");
			System.out.println("\t\t3. ��ȣ ���� ");
			System.out.println("\t\t4. ���� ");
			System.out.print("\n\t\t�޴��� �����ϼ��� : ");
			menu = scan.nextInt();
		
			
			switch(menu)
			{
				case 1: // ��ȣ ���(1. ��ȣ ���� / 2. ��ȣ �Է� / 3. ���� �޴��� �̵�) ���� ���� �޴� ����

					// ����Ǿ��ִ� ���� ��� �ҷ�����
					
					endmenu1 :
					while(true)
					{	
						System.out.println("\n\t\t=============�ζ� ���===============\n");
						
						if(current==-1)
							System.out.println("\t\t\t����� �ζ� ��ȣ�� �����ϴ�!");
						
						for(int i=0; i<current+1; i++)
						{
							int[] lotto = lottos[i];
							System.out.printf("\t\t%d : %d  %d  %d  %d  %d  %d\n", i+1,lotto[0],lotto[1],lotto[2],lotto[3],lotto[4],lotto[5]);
						}
						System.out.println("\n\t\t====================================\n");
						System.out.println("\t\t1. ��ȣ ���� ");
						System.out.println("\t\t2. ��ȣ �Է� ");
						System.out.println("\t\t3. ���� �޴��� �̵� ");
						System.out.print("\n\t\t�޴��� �����ϼ��� : ");
						int submenu = scan.nextInt();
						
						switch(submenu)
						{
							case 1: // �ζ� ��ȣ ���� ����
								
								// ��ȣ 6�� ����
								
								Random rand = new Random();
								int[] lotto = new int[6];

								// �ߺ� �˻�
								
								int check = 0;
								
								do{
									check = 0;
									
									for(int i=0; i<6; i++)
										lotto[i] = rand.nextInt(45)+1;
									
									for(int i=0; i<6; i++)
										for(int j=i+1; j<6; j++)
											if(lotto[i]==lotto[j])
												check+=1;            // �ߺ��� ���� ������ check+1
											
								}while(check!=0);
								
								// ����
								
								int temp;
								
								for(int i=0; i<6; i++)
									for(int j=i+1; j<6; j++)
										if(lotto[i]>lotto[j])
										{
											temp = lotto[i];
											lotto[i]=lotto[j];
											lotto[j]=temp;
										}
								
								// ���ĵ� ���� ���
								
								System.out.printf("\n\t\t");
								
								for(int i=0; i<6; i++)
									System.out.printf("%d  ", lotto[i]);
								
								System.out.println();
								
								current++;
								
							// �ӽù迭 lotto�� �ִ� 6���� ���ڸ� lottos�� �ű��. 
								
								for(int i=0; i<6; i++)
									lottos[current][i] = lotto[i];
								
							break;
								
							case 2: // ��ȣ �Է�
								
								break;
								
							case 3: // �����޴��� �̵�
								System.out.println("\n\t\t���� �޴��� ���ư��ϴ�.\n");
								break endmenu1;
							
							default : // 1,2,3 �̿��� �޴���ȣ�� �Է����� ���
								System.out.println("\n\t\t�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. ");
								break endmenu1;
						}
					}
					break;
					
				case 2: // ��ȣ �б� ( ������ �����ߴ� ��ȣ�� �ҷ���)

					current = -1;
					
					FileInputStream fis = new FileInputStream("res/lotto/lottos.txt");
					
					int count = fis.read();
					
					for(int n=0; n<count; n++)
					{
						int[] lotto = lottos[n];
						
						for(int i=0; i<6; i++)
							lotto[i]=fis.read();
						
						current++;
					}
					fis.close();
					
					System.out.println("\n\t\t������ �б⸦ �Ϸ��߽��ϴ�.");
					
					break;
					
				case 3: // ��ȣ ���� ( ���Ͽ� ������ ��ȣ�� ������)
					
					FileOutputStream fos = new FileOutputStream("res/lotto/lottos.txt");
					
					fos.write(current+1);
					
					for(int n=0; n<current+1; n++)
					{
						int[] lotto = lottos[n];
						
						for(int i=0; i<6; i++)
							fos.write(lotto[i]);
					}
					fos.close();
					
					System.out.println("\n\t\t������ ������ �Ϸ��߽��ϴ�.");
					break;
					 
				case 4: // ���α׷� ����
					System.out.println("\n\t\t�ζ� ���α׷��� �����մϴ�.");
					break endLotto;
					
				default : // 1,2,3,4 �̿��� �޴���ȣ�� �Է��� ���
					System.out.println("\n\t\t�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
}

