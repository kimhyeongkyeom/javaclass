/**
	Date : 2021.07.21
	Author : chayeon
	Description : jdbc
	version : 1.0
*/
package clothes;

import java.sql.*;

public class DBC {

	public static Connection DBConnect() {
		// DB에 접속정보 저장을 위한 Connection 타입의 변수 con 선언
		Connection con = null;
		
		// 접속할 db의 계정정보
		String user = "KHK";
		String password  = "1111";
		
		// 접속할 db의 주소정보
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // cne
			con = DriverManager.getConnection(url, user, password); // se
			
			System.out.println("DB접속 성공!");
			
		} catch(ClassNotFoundException cne) {
			System.out.println("DB접속 실패 : 드라이버 로딩 실패!");
			cne.printStackTrace();
			
		} catch(SQLException se) {
			System.out.println("DB접속 실패 : DB계정 주소 확인!");
			se.printStackTrace();
		}
		return con;
	}
}
