import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileProgram {

	public static void main(String[] args) throws IOException {
		
		/*char[] str = new char[]{'H','e','l','l','o','\0','o','k',0}; 
		
		System.out.println("Hello everyone!".substring(3)); 

		// ���ڿ� ��ġ��
		
		//+, concat(str)
		System.out.println("Good" + "bye~~");
		System.out.println("Good".concat("bye~~"));
		
		// ���ڿ� ������
		
		String[] strs = "lotto : 12 23 45".split(" : "); 
		System.out.println(strs[0]);
		System.out.println(strs[1]);
		
		// ���ڿ� ¥����
		
		// "Hello".substring(2, 4); 
		
		String name1 = "������";
		//String name2 = "������"; 
		String name2 = new String("������");
		
		System.out.println(name1.equals(name2)); 
		 
		System.out.println(name1==name2); 
		
		System.out.println(name1=="������"); 
		
		// ���ڿ� ���ϱ�
		
		System.out.println("hello"=="hello");
		System.out.println("hello".equals("hello"));
		
		// ���ڿ� ã��
		
		System.out.println("Hello".indexOf("a"));
		System.out.println("Hello".indexOf("el"));
		System.out.println("Hello how are you".indexOf("o")); 
		
		int idx = "Hello how are you".indexOf("o"); 
		System.out.println(idx); 
		idx = "Hello how are you".indexOf("o", idx+1);
		System.out.println(idx); 
		idx = "Hello how are you".indexOf("o", idx+1);
		System.out.println(idx); 
		
		String filename = "file1.txt";
		idx = filename.lastIndexOf("."); 
		System.out.println(filename.substring(idx+1)); 
		
		String path = "C:\\workspace\\lotto.txt";
		
		idx = path.lastIndexOf("\\");
		System.out.println(path.substring(idx+1));
		
		// ���ڿ� ��ȯ (���� -> ���ڿ�)
		
		int kor = Integer.parseInt("23"); 
		System.out.println(kor+2);
		
		String s = String.valueOf(kor); 
		System.out.println(s+2); */
		
		
		
		
		FileOutputStream fos = new FileOutputStream("C:\\workspace\\hello.txt");
		PrintStream fout = new PrintStream(fos);
		fout.printf("lotto : %d %d %d", 12, 14, 15);

		fout.close(); 
		fos.close();

		System.out.println("�Է� �޾� �����?");

		FileInputStream fis = new FileInputStream("C:\\workspace\\hello.txt");
		Scanner fscan = new Scanner(fis);

		fscan.next();
		fscan.next(); 
		int n1 = fscan.nextInt();
		int n2 = fscan.nextInt();
		int n3 = fscan.nextInt(); 

		System.out.printf("n1 : %d, n2 : %d, n3 : %d\n", n1, n2, n3);

		
		String str = fscan.nextLine();
		System.out.println(str); 
		 

		fscan.close(); 
		fis.close();
		
	}

}
