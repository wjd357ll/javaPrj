package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		//Class.forName("oracle.jdbc.driver.OracleDriver";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("[회원 검색 프로그램]\n");
		
		System.out.print("이름 검색어 입력 : ");
		String nameKey = scan.nextLine();
		System.out.println("\n");
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		//String sql = "SELECT * FROM MEMBER WHERE NAME LIKE '%" + nameKey + "%'";
/*		String sql = "SELECT * FROM MEMBER WHERE NAME LIKE '%" + nameKey + "%'";*/
		String sql = "SELECT * FROM MEMBER WHERE REGEXP_LIKE('^" + nameKey + "\\w+$'";
		
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		String name;
		String mid;
		int age;
		
		//rs.next(); // 서버에서 레코드 하나를 가져옴
		//mid = rs.getString("MID");
		//System.out.println(mid);
		
		System.out.println("\t아이디\t\t이름\t\t나이\n");
		
		while(rs.next()){
			
			name = rs.getString("NAME");
			mid = rs.getString("MID");
			age = rs.getInt("AGE");
			
			System.out.println("\t" + mid + "\t\t" + name + "\t\t" + age);
		
		} // 서버에서 레코드 전체를 가져옴
		
	}

}
