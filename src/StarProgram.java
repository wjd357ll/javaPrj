
public class StarProgram {

	public static void main(String[] args) {

		
		for(int y=1; y<=10; y++) 
		{
			for(int x=1; x<=10; x++) 
			{		
				if((y>=x) && (y<=-x+10))
					System.out.print("��");
				else
					System.out.print("��");
			}
			System.out.println();	
		}
		
		
		
		/*
		for(int i=0, n=1; i<20; i++)
			if((i+1) == (2+(n-1)*3)) // an = a1 + (n-1)d �������� �̿��ؼ� ���ǽ��� �ۼ�����.
			{	
				System.out.print("��");
				n++;
			}
			else
				System.out.print("��");
				*/
	}
}
