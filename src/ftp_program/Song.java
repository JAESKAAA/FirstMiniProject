package ftp_program;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Song {
	
	static Scanner scn = new Scanner(System.in);						
	static Map<String, String> map = new HashMap<String, String>();		
	
	// 음악 별로 코멘트가 저정되는 리스트들이며, 수정이 빈번할것으로 예상되어 LinkedList로 구현 하였음
	public static List<Song> song1 = new LinkedList<>();
	public static List<Song> song2 = new LinkedList<>();
	public static List<Song> song3 = new LinkedList<>();
	public static List<Song> song4 = new LinkedList<>();
	
	//곡 정보
	private String songName;
	private String albumName;
	private String albumDate;
	
	//아티스트 정보
	private String artistName;


	
	//생성자(노래 관련 정보를 초기화 시켜줌)
	public Song() {}
	
	public Song(String songName, String albumName, String albumDate, String artistName) {
	this.songName = songName;
	this.albumName = albumName;
	this.albumDate = albumDate;
	this.artistName = artistName;
	}
	
	
	//getter & setter
	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlnumDate() {
		return albumDate;
	}

	public void setAlnumDate(String alnumDate) {
		this.albumDate = alnumDate;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	//다시 오버라이딩 함
	@Override
	public String toString() {
		return this.songName;
	}
	//Song 객체 print시 하기 형식으로 출력 하도록 오버라이딩
//	@Override
//	public String toString() {
//		return 
//				"■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n"
//			+   "│\t 곡    이름  → "+ songName+ "\n"
//			+   "│\t 앨범 정보  → "+ albumName+ "\n"
//			+   "│\t 발  매  일  → "+ albumDate+ "\n"
//			+   "│\t 아티스트   → "+ artistName+ "\n"
//			+   "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n";
//	}
	public static void printSong(int a) {
		switch(a) {
		case 1:
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("│\t 곡  이름\t→\tAfrica");
			System.out.println("│\t 앨범 정보\t→\tSaFaRy");
			System.out.println("│\t 발 매 일\t→\t2006.05.21");
			System.out.println("│\t 아티스트\t→\tTOTO");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			break;
		case 2:
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("│\t 곡  이름\t→\tAround The World");
			System.out.println("│\t 앨범 정보\t→\tPEACE");
			System.out.println("│\t 발 매 일\t→\t2015.11.22");
			System.out.println("│\t 아티스트\t→\tATC");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			break;
		case 3:
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("│\t 곡  이름\t→\tSweet");
			System.out.println("│\t 앨범 정보\t→\tCandy");
			System.out.println("│\t 발 매 일\t→\t2011.09.11");
			System.out.println("│\t 아티스트\t→\tEvangeline Matthew");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			break;
		case 4:
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("│\t 곡  이름\t→\tDon't Speak");
			System.out.println("│\t 앨범 정보\t→\tNO MOUSE");
			System.out.println("│\t 발 매 일\t→\t1998.07.25");
			System.out.println("│\t 아티스트\t→\tNO DOUBT");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			break;
		default :
			System.out.println("숫자로 다시 입력해 주세요.");
			break;
		}
	}
	
	public static String selFile(int fileNum) {
		String numfileName = null;
		switch (fileNum) {
		case 1:
			numfileName = "africa-toto.wav";
			break;
		case 2:
			numfileName = "around_the_world-atc.wav";
			break;
		case 3:
			numfileName = "evangeline-matthew_sweet.wav";
			break;
		case 4:
			numfileName = "dont_speak-no_doubt.wav";
			break;
		}
		return numfileName;
	}
	
	
	
}