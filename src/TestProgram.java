import java.util.Scanner;

public class TestProgram {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int menu = 0;
		int start = 0;
		int end = 0;
		int menu2 = 0;
		int count = 0;
		
		here :
		while(true)
		{
			System.out.println("����������������������������������������������");
			System.out.println("��               ���� ���ϴ� ���α׷�                 ��");
			System.out.println("����������������������������������������������");
			System.out.println("\n\t1. �� �Է�");
			System.out.println("\t2. ��� ����");
			System.out.println("\t3. ����");
			System.out.println("\t4. ����");
			System.out.print("\n\t���ϴ� �޴� ��ȣ�� �Է��ϼ��� : ");
			
			menu = scan.nextInt();
			System.out.println("\n");
			
			switch(menu) {
			
					case 1: {
						System.out.println("\n����������������������������������������������");
						System.out.println("��                       ��  �Է�                            ��");
						System.out.println("����������������������������������������������");
						
						out :
						while(true)
						{
							System.out.print("\n\t(���۰� sp ����) : ");
							
							start = scan.nextInt();
							end = scan.nextInt();
							System.out.println("\n");
				
							smallout :
							while(true)
							{
								System.out.print("\t���� �޴��� �̵� (yes-1/���Է�-2) : ");
								menu2 = scan.nextInt();
							
								if(menu2==1)
									break out;
								else if(menu2==2)
								{
									System.out.println("\t�ٽ� �Է����ּ���.");
									break smallout;
								}
								else
									System.out.println("\t�߸� �Է��ϼ̽��ϴ�.");
							}
						}		
					}
					break;
					
					case 2: {
						
						int sum=0;
						
						/*
						for(int i=start; i<=end; i++ )
							sum += i;
						*/
						count = end - start + 1;
						sum = (count*(start+end))/2;
						
						System.out.println("\n����������������������������������������������");
						System.out.println("��                       ���  ����                         ��");
						System.out.println("����������������������������������������������");
						System.out.printf("\t[%d] ���� [%d] ������ ���� [%d] �Դϴ�.\n\n", start, end, sum);
						
						while(true)
						{
							System.out.print("\t���� �޴��� �̵� (yes-1) : ");
							menu2 = scan.nextInt();
							
								if(menu2 != 1)
									System.out.println("\t�߸� �Է��ϼ̽��ϴ�.");
								else
									break;
						}
					}
					break;
					
					case 3:
						System.out.println("\t�����Դϴ�.\n");
						break;
						
					case 4:
						System.out.println("\t�����մϴ�.\n");
						break here;
						
					default :
						System.out.println("\t�߸� �Է��ϼ̽��ϴ�.\n");
				} // switch�� ����
				
			} // while�� ����
		
		}

	}

