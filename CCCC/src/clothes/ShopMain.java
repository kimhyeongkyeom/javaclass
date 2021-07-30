package clothes;

import java.util.Scanner;

import clothes.ShopSQL;
import clothes.Client;

public class ShopMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Client ct = new Client();
		ShopSQL ssql = new ShopSQL();
		boolean run = true;
		//접속
		ssql.connect();

		do {
			System.out.println();
			System.out.println("   ☆★  겸신사에 오신것을 환영합니다  ☆★");
			System.out.println("=============================");
			System.out.println("① 회원가입       ② 로그인        ③ 종료");
			System.out.println("       (로그인후 주문가능)");
			System.out.println("=============================");
			System.out.print("메뉴선택 >> ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				ssql.newMember();
				break;
			case 2:
				System.out.print("회원번호>> ");
				int id = sc.nextInt();
				System.out.print("비밀번호>> ");
				String pw = sc.next();

				boolean idc = ssql.idcheck(id, pw);
				
				if (idc) {
					System.out.println("=====================");
					System.out.println("① 상의     ② 하의    ③ 주문목록");
					System.out.println("=====================");
					System.out.print("어떤 종류를 찾으세요>> ");
					int menu1 = sc.nextInt();
					switch (menu1) {
					case 1:
						ssql.list("상의");
						System.out.print("상품명 >> ");
						String name = sc.next();
						
						System.out.print("사이즈 >> ");
						String size = sc.next();
						
						System.out.print("색상 >> ");
						String color = sc.next();
						
						System.out.print("가격 >> ");
						String price = sc.next();
						boolean payc = ssql.pay2(name);
						if(payc) {
							ssql.order(id, name, size, color, price);
						}
						break;
					case 2:
						ssql.list("하의");
						System.out.print("상품명 >> ");
						String name1 = sc.next();
						
						System.out.print("사이즈 >> ");
						String size1 = sc.next();
						
						System.out.print("색상 >> ");
						String color1 = sc.next();
						
						System.out.print("가격 >> ");
						String price1 = sc.next();
						payc = ssql.pay2(name1);
						if(payc) {
							ssql.order(id, name1, size1, color1, price1);
						}
						break;
					case 3:
						ssql.orderlist(id);
						break;
					default:
						System.out.println("잘못 입력하셨습니다!");
						break;
					}
				}
				break;
			case 3:
				// 해제
				ssql.conClose();
				System.out.println("시스템을 종료합니다!");
				run = false;
				break;
			default:
				System.out.println("1~5를 입력해주세요!");
				break;
			}
		} while (run);
	}
}