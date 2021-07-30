package shop2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class psql {
	//[1]. DB접속
		Connection con = null;
		
	//[2]. DB데이터보내기
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
	//[3]. DB데이터 받기
		ResultSet rs = null;

		// 접속
		public void connect() {
		
			con = DBC.DBConnect();
		}
		// 해지
			public void conClose() {
				try {
					con.close();
					System.out.println("DB접속 해제! ");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
			// 회원가입
			public void shopJoin(shop sh) {
				
				
				String sql = "INSERT INTO MEMBER VALUES(?,?,?,TO_DATE(?),?,?,?,?)";
				
				try {
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, sh.getMemberno());
					pstmt.setString(2, sh.getPassword());
					pstmt.setString(3, sh.getName());
					pstmt.setString(4, sh.getBirth());
					pstmt.setString(5, sh.getGender());
					pstmt.setString(6, sh.getPhone());
					pstmt.setString(7, sh.getAddr());
					pstmt.setString(8, sh.getAccount());
					
					int result = pstmt.executeUpdate();
					
					if(result>0) {
						System.out.println("회원가입 성공! ");
					}else {
						System.out.println("회원가입 실패! ");
					}
					
				}catch (SQLException e) {
					System.out.println("SQLException 발생! ");
					e.printStackTrace();
				}
				} // 회원가입 끝
		
			//회원정보 체크
			public boolean idcheck(String memberno, String password) {
				
				boolean checkResult = false;
				String sql = "SELECT * FROM MEMBER WHERE MEMBERNO = ? AND PASSWORD = ? ";
				
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, memberno);
					pstmt.setString(2, password);
					
					rs = pstmt.executeQuery();
					
					if(rs.next()) { // 결과값이 존재할떄
						checkResult = true;
					}else {		// 결과값이 존재하지 않을떄
						checkResult = false;	
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return checkResult;
			}
			// 리스트
			public void list(String table) {
				String sql = null;
				
				if(table.equals("상의")) {
					sql = "SELECT * FROM TOP";
				}else {
					sql = "SELECT * FROM PANTS";
				}
				try {
					stmt=con.createStatement();
					rs=stmt.executeQuery(sql);
					
					while(rs.next()) {
						
					System.out.println();
					System.out.println("상품명 : "+rs.getString(1));
					System.out.println("사이즈 : "+rs.getString(2));
					System.out.println("색상 : "+rs.getString(3));
					System.out.println("가격 : "+rs.getString(4));
						
					}
				} catch (SQLException e) {
					System.out.println("sqlexception발생");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			public int checkbalance(String account) {
					int result = 0;
				
				String sql = "SELECT BALANCE FROM MEMBER WHERE ACCOUNT=?";
				
				try {
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, account);
					
					rs= pstmt.executeQuery();
					
					if(rs.next()) {
						result = rs.getInt(1);
					}	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return result;
			}
			// 입금
			public void deposit(String account, int balance) {
				String sql = "UPDATE ACC SET BALANCE = BALANCE+? WHERE ACCOUNT =?";
				
				try {
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, balance);
					pstmt.setString(2, account);
					
					int result = pstmt.executeUpdate();
					
					if(result>0) {
						System.out.println(balance+"원 입금 성공");
					}else {
						System.out.println("입금 실패 했씁니다. ");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 출금
			public void withdraw(String account, int balance) {
				String sql = "UPDATE ACC SET BALANCE= BALANCE-? WHERE ACCOUNT =?";
				
				try {
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, balance);
					pstmt.setString(2,account);
					
					int result = pstmt.executeUpdate();
					
					if(result>0) {
						System.out.println(balance +"원 출금 완료! ");
					}else {
						System.out.println("출금 실패 했씁니다. ");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			
	
}
