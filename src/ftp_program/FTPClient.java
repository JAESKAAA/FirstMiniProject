package ftp_program;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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

public class FTPClient extends TcpApplication{
	
	//스캐너
	public static Scanner sc = new Scanner(System.in);
	
	//입력 스트림
	public static InputStream in = null;
	public static DataInputStream din = null;
	public static BufferedInputStream bi = null;
	public static BufferedReader br = null;

	//출력  스트림
	public static OutputStream out = null;
	public static DataOutputStream dout = null;
	public static FileOutputStream fos =null;
	public static PrintWriter pw = null;
	
	//다운로드 바이트 증가에 따른 도형 출력을 위한 카운터
	public static int cnt = 0;
	
	//음악 다운로드 그만하게 만드는 변수
	public static String musicDownControl ="";
	 
	 //클라이언트 소켓
	 Socket socket = null;
	 
		//클라이언트 시작
		@Override
		public void start() {
			
		 try {
			socket = new Socket(IP, PORT); //소켓생성으로 서버 소켓과 연결

			 // 수신
			in = socket.getInputStream();
			din = new DataInputStream(in);
			bi = new BufferedInputStream(in);
			br = new BufferedReader(new InputStreamReader(in));
			 // 송신
			out = socket.getOutputStream();
			dout = new DataOutputStream(out);
			pw = new PrintWriter(new OutputStreamWriter(out));
			 
			// 리스트 출력
			listDown();
			System.out.println("리스트 출력 완료");

			 // <메뉴 선택 기능>
			selectMenu();
			
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
			}
			
	/*
	 * [주요 메서드 모음]
	 */
	public static void selectMenu() throws IOException {
		int input = 0;
			Loop1: while(true) {
				//메뉴 출력
				 menuDisplay();
				 //메뉴 선택
				 input=Integer.parseInt(sc.nextLine());
				 //메뉴 번호 서버로 송신
				 out.write(input);
				 out.flush();
				 
				 switch(input) {
				 case 1: 
					 pw.println(1);
					 System.out.println("재생메뉴 입니다.");
					 //<재생기능>
					 //여기에 음원 재생 메서드 넣어주시면 될거에요 !
					 break;
					 
				 case 2: 
					 // 음원 다운로드 기능
					 System.out.println("음원 다운로드 메뉴입니다.");
					 System.out.println("다운 받고 싶은 음원을 선택해 주세요.");
					 String fileName ="";
					 String endDownload="";
					 
					 while(!endDownload.equals("quit")) {
					 
					//파일 리스트 출력
					 showFileList();
					
					//선택된 번호의 파일을 다운로드
					 try {
					 fileName = sc.nextLine();
						musicDown(fileName);
						System.out.println("끝내시려면 quit 입력");
						endDownload = sc.nextLine();
					} catch (Exception e) {
						e.printStackTrace();
					}
					 }
					 break;
					 
				 case 3:
					 System.out.println("곡정보를 출력 합니다.");
					 Song song = new Song();
					 
					 //곡 리스트 출력
					 showMusicList();
					 
					 //곡 선택
					 int a = Integer.parseInt(sc.nextLine());
					 //곡 정보 출력
					 song.printSong(a);
					 break;
					 
				 case 4:
					 System.out.println("프로그램을 종료 합니다.");
					 pw.println("quit");
						pw.flush();
					 break Loop1;
				 }
			}
		 }
		


	public static void listDown() throws IOException {
		 // <파일 리스트 수신>
		System.out.println("\n[보유하고 있는 음원 목록입니다.]");
		System.out.println();
		
//		String strline = null;
//		String strlen = null;
		 while(true) {
			//파일 이름 수신
			String strline = br.readLine();
			String strlen = br.readLine(); //1바이트씩 받을것
			
			if(strline.equals("quit")) break;
			System.out.println(strline);
			System.out.println("(파일크기: "+strlen+" byte)");
			
		 }
			
		}


	public static void menuDisplay() {
		
		
		System.out.println();
		System.out.println("─────────────────────────────────────────────────────");
		System.out.println();
		System.out.println("                원하시는 메뉴를 선택해 주세요.");
		System.out.println();
		System.out.println(" [1] 음원 재생 [2] 다운로드 [3] 곡정보 출력 [4] 프로그램 종료");
		System.out.println();
		System.out.println("─────────────────────────────────────────────────────");
		System.out.println();
		System.out.print(" 선택>");
	}
	
	// 음원 파일 리스트 출력
	public static void showFileList() {
		
		
		System.out.println();
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println("   받고 싶은 파일의 이름(파일명.확장자)을 입력해 주세요.");
		System.out.println();
		System.out.println(" [1] africa-toto.wav [2] around_the_world-atc.wav [3] dont_speak-no_doubt.wav [4] evangeline-matthew_sweet.wav [5] 종료(quit 입력)");
		System.out.println();
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.print(" 선택>");
		}
	
	public static void showMusicList() {
		System.out.println();
		System.out.println("───────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println("                  음원 리스트 입니다");
		System.out.println();
		System.out.println(" [1] Africa [2] Around The World [3] Sweet [4] Don't Speak");
		System.out.println();
		System.out.println("───────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.print(" 선택>");
	}
	// 음원 선택 후 다운로드 기능
	public static void musicDown(String fileName) throws Exception {
		try {
		 
		 // 서버로 전송
		 dout.writeUTF(fileName);
		 System.out.println(timeStamp()+"파일 서버에 요청하였습니다.");
		 System.out.println();
		 
		 // 파일데이터 수신
		 System.out.println("파일 수신 중...");
		 System.out.println();
		 
		  fos = new FileOutputStream("Download\\"+fileName);
		 
		  while(true) {
			 // 읽기
			  int data = din.read();
			  System.out.println("클라에서 읽는 데이터"+data);
			 

			 // 쓰기
			  fos.write(data);
			  if(cnt%50000 ==0) {
				  System.out.print("■");
			  }
			  //속썩이던 친구가 고쳐짐
			  if(data == 255) {
				  break;
			  }
			  cnt++;
		 }
		 System.out.println("수신완료");
		 System.out.println();
		 System.out.println(timeStamp()+"파일 수신을 완료하였습니다."+"("+cnt+"바이트"+")");
		 
		 System.out.println();
		 System.out.println(timeStamp()+"파일 다운로드 완료");
		 System.out.println();
		}catch(Exception e) {}
	}
}



