import java.util.Scanner;

public class GugudanProgram {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int menu = 0;
		int inputdan = 0;
		int num1, num2;
		
		ggdan :
		while(true)
		{
			System.out.println("\n����������������������������������������������");
			System.out.println("��                   ���� ���α׷�                    ��");
			System.out.println("����������������������������������������������");
			System.out.println("\n\t1. ������ ��ü ���");
			System.out.println("\t2. ���ϴ� �� ���");
			System.out.println("\t3. ���� ����");
			System.out.println("\t4. ����");
			
			System.out.print("\n\t���ϴ� �޴� ��ȣ�� �Է��ϼ��� : ");
			menu = scan.nextInt();
			
			switch(menu)
			{
				case 1 :
				{
					System.out.println("����������������������������������������������");
					System.out.println("��                   ������ ��ü ����                   ��");
					System.out.println("����������������������������������������������");
					
					for(int dan=2; dan<10; dan++)
					{
						System.out.println("\t\t===== " + dan + "�� =====\n");
						
						for(int i=1; i<10; i++)
							System.out.println("\t\t  " + dan + " X " + i + " = " + dan*i);
						
						System.out.println();
					}
				}
				break;
				
				case 2 :
				{
					System.out.println("\n����������������������������������������������");
					System.out.println("��                ������ ������ ����                   ��");
					System.out.println("����������������������������������������������");
					
					while(true)
					{
						System.out.print("\n\t���ϴ� ���� �Է��ϼ���(2~9) : ");
						inputdan = scan.nextInt();
						System.out.println("\n");
						
						if(!(1<inputdan && inputdan<10))
							System.out.println("\n\t�߸� �Է��ϼ̽��ϴ�.\n");
						else 
							break;
					}
					
					System.out.println("\t\t===== " + inputdan + "�� =====\n");
					
					for(int i=1; i<10; i++)
						System.out.println("\t\t   " + inputdan + " X " + i + " = " + inputdan*i + "\n");
				}
				break;
				
				case 3 :
				{
					System.out.println("\n����������������������������������������������");
					System.out.println("��                        ���� ����                      ��");
					System.out.println("����������������������������������������������");
					
					while(true)
					{
						System.out.print("\n\t������ ���ϴ� �� ���� �Է��ϼ���. \n\t( a sp b / ���θ޴� : 0 ) : ");
						num1 = scan.nextInt();
						
							if(num1==0)
								break;
						
						num2 = scan.nextInt();
						System.out.println("\n");
						
						System.out.printf("\t%d" + " X " + "%d" + " = " + "%d\n", num1, num2, num1*num2);
					}
				}
				break;
				
				case 4 :
				{
					System.out.println("\n\t������ ���α׷��� �����մϴ�.");
					break ggdan;
				}
				
				default :
					System.out.println("\n\t�߸� �Է��ϼ̽��ϴ�.\n");
			}
			
		}

	}

}
