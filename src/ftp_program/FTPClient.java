package ftp_program;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.framework.TcpApplication;

public class FTPClient extends TcpApplication {
	/*
	 * [필드]
	 */

	// 경로 관련 변수
	public static String DOWNLOADPATH = "Download\\";
	public static String FILENAME = "";

	// 스캐너
	public static Scanner sc = new Scanner(System.in);

	// 입력 스트림
	public static InputStream in = null;
	public static DataInputStream din = null;
	public static BufferedInputStream bi = null;
	public static BufferedReader br = null;

	// 출력 스트림
	public static OutputStream out = null;
	public static DataOutputStream dout = null;
	public static FileOutputStream fos = null;
	public static PrintWriter pw = null;

	// 다운로드 바이트 증가에 따른 도형 출력을 위한 카운터
	public static int cnt = 0;

	// 회원, 게스트 구분
	public static int is_mem = 0;

	// 음원 정보 선택을 받아줄 변수
	public static int musicSelect;
	// 클라이언트 소켓
	Socket socket = null;

	// 클라이언트 시작
	@Override
	public void start() {

		try {
			socket = new Socket(IP, PORT); // 소켓생성으로 서버 소켓과 연결

			// 수신 스트림 설정
			in = socket.getInputStream();
			din = new DataInputStream(in);
			bi = new BufferedInputStream(in);
			br = new BufferedReader(new InputStreamReader(in));

			// 송신 스트림 설정
			out = socket.getOutputStream();
			dout = new DataOutputStream(out);
			pw = new PrintWriter(new OutputStreamWriter(out));

			// <로그인 세션>
			while (true) {
				try {
					accountCheck();
					break;
				} catch (NumberFormatException e) {
					System.out.println("숫자형식으로 입력 바랍니다.");
				}
			}

			// <리스트 세션>
			listDown();
			System.out.println("리스트 출력 완료");

			// <메인 세션>
			// 메뉴에 예외 발생하면 반복 실행되도록 구현
			// 메뉴 선택 기능
			Menu.heart();

			while (true) {
				try {
					selectMenu();
					break;
				} catch (NumberFormatException e) {
					System.out.println("숫자형식으로 입력 바랍니다.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 소켓 및 스트림 닫기
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println(timeStamp() + "파일 전송 서비스를 종료합니다.");
	} // start 메서드 종료

	/*
	 * [주요 메서드 모음]
	 */
	public static void selectMenu() throws Exception {
		int input = 0;
		Loop1: while (true) {
			// 메뉴 출력
			Menu.menuDisplay();
			// 메뉴 선택
			input = Integer.parseInt(sc.nextLine());
			// 메뉴 번호 서버로 송신
			out.write(input);
			out.flush();

			switch (input) {
			case 1:
				pw.println(1);
				System.out.println("재생메뉴 입니다.");
				Menu.showMusicList();

				// <재생기능>
				try {
					// 게스트 :0 회원 :1
					// 회원 여부에 따른 음악재생
					Play.selectMusic(is_mem);
				} catch (FileNotFoundException e) {
					System.out.println("\n음원을 먼저 다운로드 해주세요.");
				}
				break;

			case 2:
				// 음원 다운로드 기능
				System.out.println("음원 다운로드 메뉴입니다.");
				System.out.println("다운 받고 싶은 음원을 선택해 주세요.");

				while (true) {
					try {
						// 파일 리스트 출력
						Menu.showFileList();

						// 선택된 번호의 파일을 다운로드
						int fileNum = Integer.parseInt(sc.nextLine());
						FILENAME = Song.selFile(fileNum);
						musicDown(FILENAME);
						break;
					} catch (NumberFormatException e) {
						System.out.println("숫자로 입력해 주세요.");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;
			case 3:
				// 로그인 회원만 게시판 접근 가능하도록 구현
				if (is_mem == 1) {
					System.out.println("리뷰 게시판을 출력 합니다.");

					// 곡 리스트 출력
					Menu.showMusicList();

					// 곡 선택
					musicSelect = Integer.parseInt(sc.nextLine());

					// 곡 정보 출력
					Song.printSong(musicSelect);

					// 리뷰 작성
					int is_review = Person.reviewOrNo();
					Person.showComment2(is_review);
					break;
				} else {
					System.out.println("게시판은 회원 전용 입니다.");
				}
				break;
			case 4:
				System.out.println("프로그램을 종료 합니다.");
				pw.println("quit");
				pw.flush();
				break Loop1;
			}
		}
	}

	private void accountCheck() throws IOException {

		int input = 0;
		Login: while (true) {
			// 로그인 메뉴 출력
			Menu.loginDisplay();
			// 메뉴 선택
			input = Integer.parseInt(sc.nextLine());

			// 메뉴 번호 서버로 송신
			out.write(input);
			out.flush();

			// 회원가입 메소드를 위한 객체 생성
			Person p = new Person();

			switch (input) {
			case 1:
				// 회원 가입 기능
				System.out.println("******** 회원 가입 페이지 입니다. *********");
				p.sign();
				break;
			case 2:
				// login 메소드를 이용해 로그인 후, 성공시 1, 실패시 0을 반환해줌
				System.out.println("******** 로그인 페이지 입니다.******** ");
				int is_success = p.login();
				is_mem = is_success;

				// 로그인 성공여부 서버로 전송
				out.write(is_success);
				out.flush();

				// 로그인 성공이면 다음 세션으로넘어가고, 실패하면 다시 while문 반복
				if (is_success != 0) {
					break Login;
				} else {
					break;
				}
			case 3:
				// 게스트 입장시 다음 세션으로
				System.out.println("******** 게스트로 입장합니다.******** ");
				break Login;
			case 4:
				// 프로그램 강제 종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}

	public static void listDown() throws IOException {
		// <파일 리스트 수신>
		System.out.println("\n[보유하고 있는 음원 목록입니다.]");
		System.out.println();

		while (true) {
			// 파일 이름 수신
			String strline = br.readLine();
			String strlen = br.readLine(); // 1바이트씩 받을것

			if (strline.equals("quit"))
				break;
			System.out.println(strline);
			System.out.println("(파일크기: " + strlen + " byte)");
		}
	}

	// 음원 선택 후 다운로드 기능
	public static void musicDown(String fileName) throws Exception {
		try {
			// 서버로 전송
			dout.writeUTF(fileName);
			System.out.println(timeStamp() + "파일 서버에 요청하였습니다.");
			System.out.println();

			// 파일데이터 수신
			System.out.println("파일 수신 중...");
			System.out.println();
			
			//매개변수의 기입된 경로로 파일이 만들어질 길을 설정해줌
			fos = new FileOutputStream(DOWNLOADPATH + fileName);
			
			//전송속도 측정 시작
			long start = System.currentTimeMillis();
			int heart = 0;
			while (true) {
				// 읽기
				int data = din.read();
//	            System.out.println("클라에서 읽기"+data); //데이터 입출력 이상있을때 체크용

				// 쓰기
				fos.write(data);
				fos.flush();
//	            System.out.println("클라에서 쓰기"+data); //데이터 입출력 이상있을때 체크용

				// 토끼 나오도록 구현
				heart = Menu.showRabbit();
				//***-1을 반환받지 못해 마지막으로 반환받은 255로 결국 설정함. 왜 -1을 반환하지 않는지 확인 필요함***
				if (data == 255) {
					break;
				}
				cnt++;
			}
			//전송 속도 출력 완료
			long end = System.currentTimeMillis();
			System.out.println("당신은 토끼에게 " + heart + "개의 ♥ 를 받았습니다.");
			System.out.println("\n데이터 수신 완료 : 약" + (end - start) / 1000 + "초");
			System.out.println();
			System.out.println(timeStamp() + "파일 수신을 완료하였습니다." + "(" + cnt + "바이트" + ")");

			System.out.println();
			System.out.println(timeStamp() + "파일 다운로드 완료");
			System.out.println();
		} catch (Exception e) {
		}
	}
}
