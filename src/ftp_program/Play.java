package ftp_program;

import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Play {

	public static Clip c;
	/*
	 * 음악 번호를 받아 playmusic 실행
	 */
	public static void selectMusic(int is_mem) throws Exception {

		System.out.println("재생메뉴 입니다.");
		System.out.print("재생 하고자 하는 곡의 번호를 입력하세요 > ");

		Scanner scn = new Scanner(System.in); // 음악 번호 입력
		int sel = Integer.parseInt(scn.nextLine()); // 입력받은 값 int 로 변환
		System.out.println();

		if (Song.selFile(sel) == null) {
			System.out.print("올바른 번호를 입력해주세요.... ");
		} else {
			System.out.println("♬♪♩   " + Song.selFile(sel) + "  ♬♪♩ \n");
			Song.printSong(sel);
			playmusic(is_mem,FTPClient.DOWNLOADPATH + Song.selFile(sel)); //노래듣기	
			
		}
	}
	
//		switch (sel) {
//		case 1:
//			System.out.println("♬♪♩  africa-toto playing  ♬♪♩");
//			playmusic(FTPClient.DOWNLOADPATH + "africa-toto.wav");
//			
//			
//			//prePlay(FTPClient.DOWNLOADPATH + "africa-toto.wav"); //미리듣기
//			break;
//		case 2:
//			System.out.println("♬♪♩  around_the_world playing  ♬♪♩");
//			playmusic(FTPClient.DOWNLOADPATH + "around_the_world-atc.wav");
//			break;
//		case 3:
//			System.out.println("♬♪♩  evangeline-matthew_sweet playing  ♬♪♩");
//			playmusic(FTPClient.DOWNLOADPATH + "evangeline-matthew_sweet.wav");
//			break;
//		case 4:
//			System.out.println("♬♪♩  dont_speak-no_doubt playing ♬♪♩");
//			playmusic(FTPClient.DOWNLOADPATH + "dont_speak-no_doubt.wav");
//			break;
//		}

	/*
	 * 미리듣기
	 */
//	public static void prePlay(String FilePath) throws Exception, IllegalMonitorStateException {
//
//		System.out.println("미리듣기 실행중......");
//		File a = new File(FilePath);
//		AudioInputStream b = AudioSystem.getAudioInputStream(a);
//		c = AudioSystem.getClip();
//		c.open(b);
//		c.start();
//		Thread.sleep(10000);
//		stopMusic();
//
//	}

	/*
	 * 파일 경로를 받아 음악 재생
	 */

//	public static void playmusic(String FilePath) throws Exception, IllegalMonitorStateException {
	public static void playmusic(int is_mem, String FilePath) throws Exception, IllegalMonitorStateException {
		File a = new File(FilePath);

		AudioInputStream b = AudioSystem.getAudioInputStream(a);
		c = AudioSystem.getClip();
		c.open(b);
		c.start();
		if (is_mem == 0) { // 게스트 (is_mem==0 ): 미리듣기만 가능
			System.out.println("10초 미리듣기중 .....");
			Thread.sleep(10000); // 10초 미리듣기
			stopMusic();
		} else{ // 회원(is_mem==1): 전곡듣기 , 일시정지 가능

			c.loop(c.LOOP_CONTINUOUSLY); // 음악을 반복재생

			System.out.print("\n 일시정지 : p , 재생 종료 : q  >  ");
			int pause = 0;
			while (true) { // q 입력할때까지 반복
				Scanner scanner = new Scanner(System.in);
				String quit = scanner.nextLine();

				if (quit.equalsIgnoreCase("q")) { // q 입력시 종료
					stopMusic();
					break;
				} else if (quit.equalsIgnoreCase("p")) {
					pause++;
				
					if (pause % 2 == 1) { //일시정지
						pauseMusic();
					} else { //재생 
						System.out.println("\n재생 중 .....");	
						c.start();
						System.out.print("\n일시정지 : p , 재생 종료 : q >  ");
					}
				} else {
					System.out.print("올바른 문자를 입력해주세요...> ");
				}
			}
		}
	}
	/*
	 * 음악종료
	 */
	public static void stopMusic() {
		if (c != null) {
			c.stop();
			System.out.println("음악 정지!");
		}
	}

	/*
	 * 일시정지
	 */
	public static void pauseMusic() {
		if (c != null) {
			c.stop();
			System.out.print("일시정지 ! -> 다시 재생 : p   >");
		}
	}
}
