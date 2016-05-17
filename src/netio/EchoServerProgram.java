package netio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServerProgram {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// IP 고정 (공인 IP)
		
		ServerSocket svrSocket = new ServerSocket(10000);
		System.out.println("listenning...");
		
		Socket socket = svrSocket.accept();
		
		System.out.println("connected from" + socket.getRemoteSocketAddress());
		
		InputStream nis = socket.getInputStream();
		OutputStream nos = socket.getOutputStream();
		//char c = (char)nin.read();
		//System.out.println(c);
		
		//OutputStream fout = new FileOutputStream("C:\\Users\\PPP\\Desktop\\project imgs\\Program1.jpg");
		
		//for(int c = nin.read(); c!=-1; c=nin.read())
		//	fout.write(c);
		
		//fout.flush();
		//fout.close();
		
		PrintStream nout = new PrintStream(nos,true);
		Scanner nscan = new Scanner(nis);
		
		String msg;
		
		do{
		
		msg = nscan.nextLine();
		System.out.println(msg);
		
		nout.println("echo : " + msg);
		
		}while(!msg.equals("bye"));
		
		nout.close();
		nscan.close();
		
		nis.close();
		nos.close();
		socket.close();
		
		//System.out.println("전송된 파일이 저장 되었습니다.");

	}

}
