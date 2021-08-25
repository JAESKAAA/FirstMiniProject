package ftp_program;

public class Song {

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

	//Song 객체 print시 하기 형식으로 출력 하도록 오버라이딩
	@Override
	public String toString() {
		return 
				"■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n"
			+   "│\t 곡    이름  → "+ songName+ "\n"
			+   "│\t 앨범 정보  → "+ albumName+ "\n"
			+   "│\t 발  매  일  → "+ albumDate+ "\n"
			+   "│\t 아티스트   → "+ artistName+ "\n"
			+   "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n";
	}
	public void printSong(int a) {
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
			System.out.println("│\t 곡  이름\t→\tArount The World");
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
		case 5:
			break;
			
		}
		
		
	}
}
