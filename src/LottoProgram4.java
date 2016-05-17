import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;


// �ڵ� ���� ����
public class LottoProgram4 {

	public static void main(String[] args) throws IOException {
	
		//���� ���� ��ȣ ����
		//Ȯ���� ���� ��ȣ 3�� �̱� (�ð� �ȴٸ� �����غ���)
		
		//�ڵ� ���� / ���� ����(�ʼ�)
	
		Scanner scan = new Scanner(System.in);
		
		//�÷��� �ϱ� ���� ������� �Բ� ����� ���� ����
		int [][] lottos = new int[10][6]; //6������ ��ȣ�� 10�� ����
		int current = -1; 
		
		// current  : �������� ������ �������� ��ġ�� ������� �ǹ�
		// -1�̶� ����� �����Ͱ� ���� index�� �ǹ� 
		// 0���� �ʱ�ȭ�ϰ� �Ǹ� �����͸� �����ϱ� ������ �̹� 0�� ��ġ�� �����͸� �����ߴٴ� �ǹ̰� �ǹǷ� ����ó�� -1�� �ʱ�ȭ�Ͽ� ����.
		// 0���� �ʱ�ȭ�ϰ� �ʹٸ� �������� next�� �ٲ���� �帧�� �ǹ̻� �´�. (�׳� -1�� ����)
		
		end:
		while(true)
		{	
			int menu=0; //menu�� �ݺ��� ������ ���� �ٲ� �Ǵϱ� (�ʱ�ȭ ���ص� �Ǵϱ�) while�� �ȿ� �д�.
			System.out.println("\n\t\t=============�ζ� �޴�===============");
			System.out.println("\n\t\t1. ��ȣ ��� ");
			System.out.println("\t\t2. ��ȣ �б� ");
			System.out.println("\t\t3. ��ȣ ���� ");
			System.out.println("\t\t4. ���� ");
			System.out.print("\n\t\t�޴��� �����ϼ��� : ");
			menu = scan.nextInt();
			
			switch(menu)
			{
				case 1:
				{
					stop:
					while(true)
					{
						int submenu = 0;
						
						System.out.println("\n\t\t=============�ζ� ���===============\n");
						
						// ��� ��� �ڵ带 �ۼ� (����Ǿ� �ִ� ��ȣ ���)
						
						if(current==-1)
							System.out.println("\t\t\t  ����� ��ȣ�� �����ϴ�!");
						
						/* ����
						1 : 11 14 39 28 27 13
						2 : 23 28 29 43 12 11
						3 : 11 14 39 28 27 13
						...
						*/
						
						/* 1�� ��� (������ ���� �迭�ϼ��� ����������.)
						for(int i=0; i<current+1; i++)
							System.out.printf("%d : %d\t%d\t%d\t%d\t%d\t%d\n", i+1,lottos[i][0],lottos[i][1],lottos[i][2],lottos[i][3],lottos[i][4],lottos[i][5]);
						*/
						
						//2�� ��� (������ ������� �����ϴ�.)
						for(int i=0; i<current+1; i++)
						{
							int[] lotto = lottos[i]; 
							
							//���� 6���� 10���� ���� �迭�� ©�� �� �྿ �����Ѵ�. (���� �ּҸ� ��Ÿ�� �� ���� ����ִ� ������ �ƴϴ�.)
							//�⺻ �ڷ����� ��õ��� ���� �迭�� ��ġ�ϻ� lotto[i]�� 6���� ��ȣ�� ����� �迭 �ϳ�(�� ��)�� �ּҸ� �ǹ��Ѵ�.
							//lotto[i][j]�� �� ��ȿ��� j���� i�� ������ ������ �ǹ� - lotto[i] �̷��� �ڸ��� i���� ������ �ּ�(��ġ)�� �ǹ�
							
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
							// case�� �߰�ȣ�� �ʿ������ �̸��� ���� ���������� ����ϱ� ���� �߰�ȣ�� ���ش�.
							// case ������ �߰�ȣ�� ���� �̸��� ���� ���������� ����� �� �ִ�.
						    // ���� �ݺ����� case ������ �߰�ȣ�� ������ �̸��� ���� ���������� ����� �� ����.	
							{
								
								Random rand = new Random();
								int[] lotto = new int[6]; 
								
								// ���� 2�� �迭�� ���������� case1���� ����� �迭�� ���� �������ִ� ���� �ڵ尡 �������� ������ ���ϴ�.
								// �޸𸮵� ���� ����ϰ�, �ӵ��� ���������� ū ������x, ���� case1���� ���� �迭�� �ʿ� ����. 

								int temp;
								int check = 0;
								
								for(int i=0; i<6; i++)
									lotto[i] = rand.nextInt(); // ���� ���� �̴°� �ƴ϶� �ҷ��� ���� �ȿ� �ִ� ���� �ϳ��� �о��
			
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
								
								for(int j=0; j<5; j++)                                    // for(int j=5; j>0; j--)
									for(int i=0; i<5-j; i++)                              // for(int i=0; i<j; i++) 
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
								
								// current�� -1�̾��� ������ ++�� index�� 0���� �����ְ� ���� 
								// ���� ������ �ϰ� �Ǹ� �ؿ� for������ ó���� -1�� ���� �ǹǷ� ���� ���� ������� �Ѵ�. (������ p.71���� Ǯ���!)
								
								for(int i=0; i<6; i++)
									lottos[current][i]=lotto[i]; 
								
								// �� �κп��� ++current�� ������ �밢������ ��ȣ�� ������
								// 6���� ��ȣ�� �����ϴ� ���� current ���� ���ϸ� �ȵȴ�. ���ο� 6���� ��ȣ�� ������ �� ���Ѵ�.
							}
								break;
							
							case 2:
								break;
							
							case 3:
								break stop; // while���� ���
						}
					}
				}
					break;
			
				case 2:
					break;
					
				case 3: 
					
					//���� ���� ������ ����� "C:\\workspace\\hello.txt" �� ��ǻ�Ϳ� ������ ������ ����Ǿ� �ִ� ��ġ�� �Է��ϱ� ������
					//�ٸ� ��ǻ�Ϳ����� �Ȱ��� ��ġ�� (���� ���͸� ����) ������ �����ؾ� �ϹǷ� �ſ� ��ȿ�����̴�.
					//���� �Ʒ�ó�� ����� ����� ����Ѵ�.
					
					FileOutputStream fos = new FileOutputStream("res/lotto/lottos.txt"); 
					PrintStream fout = new PrintStream(fos); // ����� ���� ������ �ۼ��ϴ� �� �ڵ� ó���� �ۼ��ϴ� �ͺ��� ����.
					
					//�ƹ��͵� ���� ���ϸ� �Է��ϸ�("lottos.txt") ���� ��Ʈ ������ ������ �˻��Ѵ�.
					//res ���� ���� lotto���� ���� lottos.txt���� �˻�(��� ��� ���)
						
					for(int i=0; i<current+1; i++)
					{
						int[] lotto = lottos[i]; 
						fout.printf("\t%d  %d  %d  %d  %d  %d\r\n", lotto[0],lotto[1],lotto[2],lotto[3],lotto[4],lotto[5]);
					} 
					// �ֿܼ� �Է¹��� ���� ���� ����̴�. fout�� System.out �� ������ ��
					// ���� ����°� ��Ʈ��ũ ����¿��� ���Ͽ� ������ ������ ���� �ٲ��� �� \r�� \n�տ� �ٿ���� �ٹٲ��� �̷�����. 
					
					fout.close();
					fos.close();
					
					System.out.println("\n\t\t���� �Ϸ��߽��ϴ�.");
					
					break;
					
				case 4:
					System.out.println("\n\t\t�ζ� ���α׷��� �����մϴ�.");
					break end;
			}
			
		}
	}
}

