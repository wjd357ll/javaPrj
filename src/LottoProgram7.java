
// �Լ� ���� �и��ϴ� �ζ� ���α׷�

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class LottoProgram7 {

	private static int inputMainMenu() // �ζ� ���α׷� ���θ޴� ��ȣ �Է¹ޱ�
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n\t\t=============�ζ� �޴�===============");
		System.out.println("\n\t\t1. ��ȣ ��� ");
		System.out.println("\t\t2. ��ȣ �б� ");
		System.out.println("\t\t3. ��ȣ ���� ");
		System.out.println("\t\t4. ���� ");
		System.out.print("\n\t\t�޴��� �����ϼ��� : ");
		int menu = scan.nextInt();
		
		return menu;
	}
	
	private static void genLottoAuto(int[][] lottos) // �ڵ� ����
	{
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
	}
	
	private static void genLottoManual(int[][] lottos) // ���� ����
	{
		
	}
	
	public static void main(String[] args) throws IOException {
	
		// ���� �޴� �Է�
		int menu = inputMainMenu();
		
		int[][] lottos = new int[10][6];
		
		switch(inputMainMenu())
		{
		case 1:
			// �ζ� �ڵ� ����
			// ������ ���� �Է�
			
				int LottoCnt = inputLottoCnt();
				
				genLottoAuto(lottos);
	
			break;
			
		case 2:
			// �ζ� ���� ����
			// ���� ��ȣ �Է�
			
			genLottoManual(lottos);
			
			break;
		}

	}

	private static int inputLottoCnt() {
		// TODO Auto-generated method stub
		return 0;
	}
}

