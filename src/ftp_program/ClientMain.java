package ftp_program;

import java.util.Scanner;

import com.framework.TcpApplication;

public class ClientMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 깔끔한 화면을위해 프롬프트 최상단 정리
		for (int i = 0; i < 17; i++) {
			System.out.println(" ");
		}
		
		//예외 처리 완료
		int select =0;
		Loop1: while (true) {
			//최초 메뉴 출력
			Menu.dundunDance();
			Menu.showMenu(TcpApplication.CNAME);
			System.out.printf("                >");
			//숫자 이외의 데이터 입력시 반복되도록 예외 처리
			try {
			select = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("          1 또는 0만 입력 가능합니다 !!!");
				continue;
			}
			if (select == 1 || select == 0) {
				switch (select) {
				case 1:
					System.out.printf("          1 → Start                   \n");
					System.out.printf("                                      \n");
					break Loop1;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
				}
			} else {
				System.out.println("          1 또는 0만 입력 가능합니다 !!!");
			}
		}
		//클라이언트 객체 인스턴스화
		FTPClient client = new FTPClient();

		// 클라이언트 초기화
		client.init();

		// 클라이언트 시작
		client.start();
	
	}

}
