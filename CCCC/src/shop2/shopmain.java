package shop2;

import java.util.Scanner;

public class shopmain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean run = true; // 반복문에 쓸꺼
		int menu = 0;
		psql psql = new psql();
		shop sh = new shop();
		int balance;
		
		do {
			System.out.println("◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈");
			System.out.println("◈ 1. DB접속      2. DB접속해제       3. 회원가입");
			System.out.println("◈ 4. 계좌           5. 로그인              6. 종료");
			System.out.println("◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈");
			System.out.print("메뉴 선택 >> ");
			
			menu = sc.nextInt();
			
			switch(menu){
			
			case 1: 
				psql.connect();
				break;
			case 2:
				psql.conClose();
				break;
			case 3:
				System.out.println("회원정보를 입력해주세요!! ");
				System.out.print("아이디 >> ");
				String memberno = sc.next();
				
				System.out.print("비밀번호 >> ");
				String password = sc.next();
				
				System.out.print("이름 >> ");
				String name = sc.next();
				
				System.out.println("생년월일 ");
				System.out.print("년도(4자리) >> ");
				String year = sc.next();
				
				System.out.print("월 >> ");
				int month = sc.nextInt();
				
				System.out.print("일 >> ");
				int day = sc.nextInt();
				
				System.out.print("성별>> ");
				String gender = sc.next();

				System.out.print("전화번호 >> ");
				String phone = sc.next();
				
				System.out.print("주소>> ");
				String addr = sc.next();
				
				System.out.print("계좌번호>> ");
				String account = sc.next();
				
				String month1;
				String day1;
				
				if(month>=10) {
					month1 = Integer.toString(month);
				}else {
					
					month1 = "0"+Integer.toString(month);
				}
				// Integer.toString(num) ==> int num을 String num1로
				if(day>=10) {
					day1 = Integer.toString(day);
				}else {
					day1 = "0"+Integer.toString(day);
				}
				
				String birth = year + month1 + day1;
				//	20210722	 2021 +  07   +  22
				
				sh.setMemberno(memberno);
				sh.setPassword(password);
				sh.setName(name);
				sh.setBirth(birth);
				sh.setGender(gender);
				sh.setPhone(phone);
				sh.setAddr(addr);
				sh.setAccount(account);
				
				psql.shopJoin(sh);
				
				break;
			case 4: //계좌생성
				System.out.println("=========================");
				System.out.println("1. 잔액조회     2. 입금  	3.출금");
				System.out.println("=========================");
				System.out.print("메뉴선택 >> ");
				int menu3 = sc.nextInt();
				
				switch(menu3) {
				case 1 :
					System.out.print("조회할 계좌번호 >>");
					account = sc.next();
					//잔액
					balance = psql.checkbalance(account);
					System.out.println("잔액 : "+balance);
					break;
				case 2:
					System.out.print("계좌번호 >>");
					account = sc.next();
					System.out.print("입금액 >> ");
					balance = sc.nextInt();
					
					psql.deposit(account,balance); // 메소드
					break;
				case 3:
					System.out.print("계좌번호 >>");
					account = sc.next();
					System.out.print("출금액 >> ");
					int wbalance = sc.nextInt();
					
					// 기존에 있던 잔액이 출금액보다 큰지 확인
					balance = psql.checkbalance(account);
					if(balance>=wbalance) {
						psql.withdraw(account,wbalance);
					}else {
						System.out.println("출금액이 "+(wbalance-balance)+"원 부족합니다.");
					}
					break;
				default :
					System.out.println("잘못입력하셨습니다.!!!");
					break;
					
				}
				break;
			case 5: // 로그인
				System.out.println("로그인");
				System.out.print("아이디    >>");
				memberno = sc.next();
				System.out.print("비밀번호 >>");
				password = sc.next();
				// 회원체크
				boolean check1 = psql.idcheck(memberno,password);
				
				if(check1) {
					System.out.println("============================");
					System.out.println("1.상의            2. 하의        3. 주문 ");
					System.out.println("============================");
					System.out.print("메뉴 선택 >> ");
					
					int menu1 = sc.nextInt();
					
					switch(menu1) {
					case 1:
						psql.list("상의");
						System.out.print("상품명을 입력하세요 >>");
						String order=sc.next();
						break;
					case 2:
						psql.list("하의");
						System.out.print("상품명을 입력하세요 >>");
						order=sc.next();
						break;	
					case 3: //주문하기
						
						
					default :
						System.out.println("잘못 입력하셨습니다!!");
					break;
					}
					
					
				}else {
					System.out.println("아이디와 비밀번호가 일치하지 않습니다. ");
				}
			case 6:
				break;
			case 7 :
				System.out.println("시스템을 종료합니다");
				run = false;
				break;
			default :
				System.out.println("잘못입력했어요 다시 입력하세요");
				break;
			
			}
		}while(run);

	}

}
