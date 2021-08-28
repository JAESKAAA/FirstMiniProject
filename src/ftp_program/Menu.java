package ftp_program;

//각종 메뉴 출력 및 UI적인 부분을 담당하는 클래스 입니다.
public class Menu {

	public static void heart () {
		 System.out.println("");
        System.out.printf("                                  ♬♬                   ♬♬                                       \n");
        System.out.printf("                               ♬       ♬           ♬      ♬                               \n");
        System.out.printf("                             ♬            ♬    ♬           ♬                        \n");
        System.out.printf("                            ♬                ♬    	       ♬                      \n");
        System.out.printf("                             ♬                                 ♬                      \n");
        System.out.printf("                              ♬     메뉴를 선택 해주세요.    ♬                              \n");
        System.out.printf("                                 ♬                         ♬                      \n");
        System.out.printf("                                   ♬                    ♬                     \n");
        System.out.printf("                                       ♬            ♬                    \n");  
        System.out.printf("                                          ♬      ♬                  \n");  
        System.out.printf("                                              ♬                    \n");  
	}
	
	public static void menuDisplay() {	
		System.out.println();
		System.out.println("───────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println("                원하시는 메뉴를 선택해 주세요.");
		System.out.println();
		System.out.println(" [1] 음원 재생 [2] 다운로드 [3] 리뷰 게시판 [4] 프로그램 종료");
		System.out.println();
		System.out.println("───────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.print(" 선택>");
	}
	
	   public static void showFileList() {
		   System.out.println();
			System.out.println(
					"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
			System.out.println();
			System.out.println("   받고 싶은 파일의 번호을 입력해 주세요.");
			System.out.println();
			System.out.println(
					" [1] africa-toto.wav [2] around_the_world-atc.wav [3] dont_speak-no_doubt.wav [4] evangeline-matthew_sweet.wav");
			System.out.println();
			System.out.println(
					"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
			System.out.println();
			System.out.print(" 선택>");
	 	}
	   
	   public static void showMusicList(){
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
	   
	   public static void dundunDance() {
	       System.out.println("                              ⊂_ ");
	       System.out.println("　                               ＼＼ Λ＿Λ");
	       System.out.println("　                                 ＼ ( 'ㅅ' ) 둠칫");
	       System.out.println("　　                                 >　⌒ ");
	       System.out.println("　                                    / 　 へ＼");
	       System.out.println("                                     /　 /　 ＼＼ 두둠칫               ");
	       System.out.println("                                    | 　  ノ　　   _つ");
	       System.out.println("　                                 /　/|  ");
	       System.out.println("　                                 (　(   두둠칫");
	       System.out.println("　                                 |　| 、＼");
	       System.out.println("　                                 |  / ＼ ⌒)");
	       System.out.println("                    　             | |　　) /");
	       System.out.println("                                   ノ )　　L ");
	       System.out.println("");
	     }
	   
	   public static void showMenu(String a) {
			System.out.printf("                                      \n");
			System.out.printf("          ■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n");
			System.out.printf("                                      \n");
			System.out.printf("            고결의 나만 쓰는 "+a+"       \n");
//			System.out.printf("            [CLIENT version 1.0.1®]   \n");
			System.out.printf("                                      \n");
			System.out.printf("          ■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n");
			System.out.printf("                                      \n");
			System.out.printf("                                      \n");
			System.out.printf("                                      \n");

			System.out.printf("          1 → Start                   \n");
			System.out.printf("          0 → End                     \n");
			System.out.printf("                                      \n");
			System.out.printf("                                      \n");
		}
	   
	   public static void loginDisplay() {
			System.out.println();
			System.out.println("───────────────────────────────────────────────────────────────");
			System.out.println();
			System.out.println("              고결의 SOUND CLOUD v1.0");
			System.out.println();
			System.out.println(" [1] 회원 가입 [2] 로그인 [3] 게스트로 입장 [4] 프로그램 종료");
			System.out.println();
			System.out.println("───────────────────────────────────────────────────────────────");
			System.out.println();
			System.out.print(" 선택>");
		}
	   
	   public static int showRabbit() {
		   int i=0,heart=0;
		   if (FTPClient.cnt % 50000 == 0) {
               i++;
               switch (i) {
               case 1:
                  System.out.println("|/)");
                  break;
               case 2:
                  System.out.println("|')\n");
                  break;
               case 3:
                  System.out.println("|/)_/)");
                  break;
               case 4:
                  System.out.println("| 'ㅅ') \n");
                  break;
               case 5:
                  System.out.println("|/)_/)");
                  break;
               case 6:
                  System.out.println("| 'ㅅ')っ♥");
                  heart++;
                  break;
               case 7:
                  System.out.println("\n\n");
                  i = 0;
                  break;
               }
            }
		   return heart;
	   }
}
