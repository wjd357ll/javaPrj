import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileProgram2 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("res/images/photo.bmp");
		FileOutputStream fos = new FileOutputStream("res/images/photo-copy.bmp");
		
		// ����size ���
		fis.read();
		fis.read();
		
		byte[] buf = new byte[4];
		
		buf[0] = (byte)fis.read();
		buf[1] = (byte)fis.read();
		buf[2] = (byte)fis.read();
		buf[3] = (byte)fis.read();
		
		//[0][1][2][3] -> int totalSize;
		int totalSize = ((int)buf[3])<<24 | ((int)buf[2])<<16 | ((int)buf[1])<<8 | ((int)buf[0])<<0; 
		
		//buf[0]���� buf[3]������ ���ؼ� totalSize�� ����
				//shift �����ڸ� ����� ��Ʈ �ڸ��� �ű�� | �����ڸ� �̿��� ��Ʈ�� ������
				// big endian : CPU�� �����ʺ��� ��Ʈ�� ä��������. (ǥ�ع��)
				// little endian : ���ʺ���
		
		System.out.println(totalSize);
				
		//Width (�ʺ�) ���
		/*for(int i=0; i<18; i++)
			fis.read();
		
		byte[] buf = new byte[4];
		
		buf[0] = (byte)fis.read();
		buf[1] = (byte)fis.read();
		buf[2] = (byte)fis.read();
		buf[3] = (byte)fis.read();
		
		int Width = ((int)buf[3])<<24 | ((int)buf[2])<<16 | ((int)buf[1])<<8 | ((int)buf[0])<<0;
		
		System.out.println(Width);*/
		
		//fos.write(fis.read()); //�ڵ��� �������� ��ȿ����(�ϳ��� �ű��) -> �迭�� �������
		
		
		/* 
		 while(fis.read() != -1)
		 	fos.write(fis.read());  // �ſ� ū �Ǽ� - �� ���о ���� ����� ������ ���� - ¦����° �о�� ���� -1�� ��, Ȧ�� ��°�� ����ϴ� ����߻�
		 */
		
		// ����Ʈ ������ ������ �����ϴ� ���� ȿ������ ���(����ڿ��� �������� �� ���� �� ����) :
		/*int n;
		
		while((n = fis.read()) != -1)
			fos.write(n);*/
		
		//����Ʈ ������ �ʹ� �۾Ƽ� �ð��� �����ɸ�
		//1KB�� �о������ �ϴ� ���
		//CPU>�޸�>�ϵ��ũ : �ӵ�
		
		/*byte[] buf = new byte[1024]; //1024 ����Ʈ�� �о������ �迭 �غ� ( ���� ������� �ӵ��� 1024��)
		
		int size;
		
		while((size=fis.read(buf)) != -1)
			fos.write(buf, 0, size);*/
		
		// read �Լ����� �о�ͼ� �ٷ� �־��ִ� (���⼭�� buf��) ���ҵ� �ִ�. 
		// size = �� ���� �о���� ũ�� (���������� �о�� ������ ���� ���� 1024����Ʈ���� ���� Ȯ���� ũ��)
		// �������� 3����Ʈ�� ���Ƶ� ���� �������� ���ؼ� 1024����Ʈ�� �����´�. ���� ������ ����� �����Ⱚ�� ��µǴ� �� ���ƾ��Ѵ�. 
		// �׷��� write �Լ��� �о�� ���� ������ �������� �� �ִ�. �� ���������� 0���� size���� ���� ����Ѵ�.
		
		/* ���� ���	(�ʺ��ڿ��� �ڵ尡������ ����)
		int n;
		
		while(true)
		{
			n = fis.read();
			
			if(n==-1)
				break;
			else
				fos.write(n);
		}
		*/
		fos.close();
		fis.close();
	}
}
