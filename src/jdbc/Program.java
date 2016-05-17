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
		
		System.out.println("[ȸ�� �˻� ���α׷�]\n");
		
		System.out.print("�̸� �˻��� �Է� : ");
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
		
		//rs.next(); // �������� ���ڵ� �ϳ��� ������
		//mid = rs.getString("MID");
		//System.out.println(mid);
		
		System.out.println("\t���̵�\t\t�̸�\t\t����\n");
		
		while(rs.next()){
			
			name = rs.getString("NAME");
			mid = rs.getString("MID");
			age = rs.getInt("AGE");
			
			System.out.println("\t" + mid + "\t\t" + name + "\t\t" + age);
		
		} // �������� ���ڵ� ��ü�� ������
		
	}

}
