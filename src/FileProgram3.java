import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileProgram3 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("res/images/photo.bmp");
		FileOutputStream fos = new FileOutputStream("res/images/photo-copy.bmp");
		
		// ����size ���
		
		//��ȿ������ ���
		/*fis.read(); 
		fis.read();
		
		
		
		buf[0] = (byte)fis.read();
		buf[1] = (byte)fis.read();
		buf[2] = (byte)fis.read();
		buf[3] = (byte)fis.read();*/
		
		//[0][1][2][3] -> int totalSize;
		byte[] buf = new byte[4];
		
		int totalSize = ((int)buf[3] & 0xff)<<24 | ((int)buf[2] & 0xff)<<16 | ((int)buf[1] & 0xff)<<8 | ((int)buf[0] & 0xff)<<0; 	
		
		// & 0xff		
		
		System.out.println(totalSize);
				
		/* Width (�ʺ�) ���
		for(int i=0; i<18; i++)
			fis.read();
		
		byte[] buf = new byte[4];
		
		buf[0] = (byte)fis.read();
		buf[1] = (byte)fis.read();
		buf[2] = (byte)fis.read();
		buf[3] = (byte)fis.read();
		
		int Width = ((int)buf[3])<<24 | ((int)buf[2])<<16 | ((int)buf[1])<<8 | ((int)buf[0])<<0;
		
		System.out.println(Width);*/
		
	
		/*int n;
		
		while((n = fis.read()) != -1)
			fos.write(n);*/

		/*byte[] buf = new byte[1024]; //1024 ����Ʈ�� �о������ �迭 �غ� ( ���� ������� �ӵ��� 1024��)
		
		int size;
		
		while((size=fis.read(buf)) != -1)
			fos.write(buf, 0, size);*/
	
		fos.close();
		fis.close();
	}
}
