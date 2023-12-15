package GuestRoom;

import java.util.Iterator;
import java.util.Scanner;

public class GuestRoom1 {

	public GuestRoom1(String string) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		// 손님 방
		// 침대 밑bed(열쇠)gukey, 옷걸이hanger, 서랍장chest(도구//망치)guTool, 전등lamp
		// 조건 이 곳중 한곳을 터치했을 때

		Scanner sc = new Scanner(System.in);

		
		
		GuestRoom1 bed = new GuestRoom1("침대 밑");
		GuestRoom1 hanger = new GuestRoom1("옷걸이");
		GuestRoom1 chest = new GuestRoom1("서랍장");
		GuestRoom1 lamp = new GuestRoom1("전등");

		  int gutool = 0;
	      int kikey = 0;
	      int count = 0;
	      int kitool = 0;
		
		

	    Thread t = new Thread();
	   
		String text ="손님방에 들어왔습니다.";
		
		for (int i = 0; i < text.length(); i++) {
			System.out.print(text.charAt(i));
			try {
				t.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
		String text1 ="주변을 둘러보니 여러곳이 눈에 들어왔습니다.";
		for (int i = 0; i < text1.length(); i++) {
			System.out.print(text1.charAt(i));
			try {
				t.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println();
		String text2 ="살인마가 들어오기 전에 빨리 살펴봐야 합니다.";
		for (int i = 0; i < text2.length(); i++) {
			System.out.print(text2.charAt(i));
			try {
				t.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while (true) {
			System.out.println();
			String text3 ="어디를 찾아야 할까?.....";
			for (int i = 0; i < text3.length(); i++) {
				System.out.print(text3.charAt(i));
				try {
					t.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println();
			System.out.println("[1]침대 밑 [2]옷걸이 [3]서랍장 [4]전등 [5]2층 >>");
			int select = sc.nextInt();

			while (true) {

				if (select == 1) {
					System.out.println();
					String text4 ="무엇인가가 구석 어두운 곳에서 물체가 보이긴 하다.";
					for (int j = 0; j < text4.length(); j++) {
						System.out.print(text4.charAt(j));
						try {
							t.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println();
					String text5 ="손으로는 안될 것 같다...";
					for (int h = 0; h < text5.length(); h++) {
						System.out.print(text5.charAt(h));
						try {
							t.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
						e.printStackTrace();
						}
					}
			
					System.out.println();
					System.out.print("[1]다른 곳을 살펴본다. [2]다른 곳을 찾아본다. >>");
					select = sc.nextInt();
					
					System.out.println();
					if (select == 1) {

						break;
					} else if (select == 2) {
						System.out.println("어느 방으로 먼저 가지?...");
						System.out.println();
						System.out.print("[1]안방 [2]부엌 [3]서제 [4]손님방 >>");
						System.out.println();
						select = sc.nextInt();

					} else {
						System.out.println("손이 자꾸만 떨린다...잘못 눌렀다...");
						System.out.println();
					}

				} else if (select == 2) {
					System.out.println("옷걸이의 모양이 특이한걸!... ");
					System.out.println();
					System.out.println("그런데 사용하지는 못할 것 같다.");
					System.out.println();

					

						System.out.print("[1] 다른 곳을 찾아본다. [2] 다른 방으로 간다. >>");
						System.out.println();
						int select1 = sc.nextInt();

						if (select1 == 1) {
							break;
						} else if (select == 2) {
							System.out.println("어느 방으로 먼저 가지?...");
							System.out.println();
							System.out.print("[1]안방 [2]부엌 [3]서제 [4]손님방 >>");
							System.out.println();
							select = sc.nextInt();
// 다른 방으로 가는 코드를 넣을 것
						} else {
							System.out.println("손이 자꾸만 떨린다...잘못 눌렀다...");
							System.out.println();
						}

					

				}

				else if (select == 3) {
					
						System.out.println("[1] 서랍 확인 [2] 나가기 >>");
						System.out.println();
						select = sc.nextInt();
						if (select == 1) {
							if (gutool == 1) {
								System.out.println("서랍 안이 비었습니다...");
								System.out.println();
								break;
							} else if (gutool == 0) {
								System.out.println("서랍장을 열어보니 효자손이 보였다.");
								System.out.println();
								System.out.println("사용할 수 있을 것 같다.");
								System.out.println();
								System.out.println("[1] 가져간다. [2] 그냥 나둔다. >>");
								select = sc.nextInt();
								if (select == 1) {
									System.out.println("효자손을 획득했습니다!");
									System.out.println();
									gutool = 1; // 획득한 후에 서랍 비어있다고 표시

								} else if (select == 2) {
									System.out.println("서랍이 닫혔다...");
								} else {
									System.out.println("잘못 눌렀다...");
									break;
								}
							}
						}

					
				} else if (select == 4) {
					System.out.println("전등 안에는 별 다른게 없다... ");
					System.out.println();

					System.out.println("[1] 다른 곳을 찾아본다. [2] 다른 방으로 간다. >>");
					System.out.println();
					select = sc.nextInt();

					if (select == 1) {
						break;
					} else if (select == 2) {
						System.out.println("어느 방으로 먼저 가지?...");
						System.out.println();
						System.out.println("[1]안방 [2]부엌 [3]서제 [4]손님방 >>");
						select = sc.nextInt();
// 다른 방으로 가는 코드를 넣을 것

					} else {
						System.out.println("손이 자꾸만 떨린다...잘못 눌렀다...");
						System.out.println();
					}

					
					
					
					
					
					
				} else {
					System.out.println("손이 떨려..그만 번호를 잘 못 눌렀다...");
					System.out.println();
				}

				

					

				break;
			}

		}

	}

}
