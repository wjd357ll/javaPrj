package netio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClientProgram {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
/* 구버전
		Socket socket = null;
		try{
			socket = new Socket(host, 10000);
			socket.setSoTimeout(15000);
			// 소켓입출력
		} catch(IOException ex){
			System.err.println(ex);
		} finally {
			if(socket != null){
				try{
					socket.close();
				}catch(IOException ex) { //..............
			}
		}*/
		
		
		try(Socket socket = new Socket("211.238.142.104", 10000)){
			socket.setSoTimeout(15000);
		
			System.out.println("connected to " + socket.getRemoteSocketAddress());
			
			InputStream nis = socket.getInputStream();
			OutputStream nos = socket.getOutputStream();
			//nout.write('h'); 
			//nout.flush();
			
			//InputStream fin = new FileInputStream("C:\\Users\\PPP\\Desktop\\project imgs\\eagles.png");
			
			//for(int c=fin.read(); c != -1; c=fin.read())
			//	nout.write(c);
			
			//nout.flush();
			
			//fin.close();
			
			PrintStream nout = new PrintStream(nos,true);
			Scanner nscan = new Scanner(nis);
			Scanner scan = new Scanner(System.in);
			
			String msg;
			
			//nout.println("hello network");
			
			do{
				
			msg = scan.nextLine();
			nout.println(msg);
			//System.out.println(msg);
			
			String echo = nscan.nextLine();
			System.out.println(echo);
			
			}while(!msg.equals("bye"));
			
			nout.close();
			nscan.close();
			
			nis.close();
			nos.close();
			socket.close();
			
			//System.out.println("파일 전송이 완료 되었습니다.");
			
		} catch(IOException ex){
			System.err.println("연결 오류");
		}
		
	}

}
