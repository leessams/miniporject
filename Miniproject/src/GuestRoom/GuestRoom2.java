package GuestRoom;

import java.util.Scanner;

public class GuestRoom2 {

	public GuestRoom2(String string) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		// 손님 방
		// 침대 밑bed(열쇠)gukey, 옷걸이hanger, 서랍장chest(도구//망치)guTool, 전등lamp
		// 조건 이 곳중 한곳을 터치했을 때

		Scanner sc = new Scanner(System.in);
		EsRoomDAO dao = new EsRoomDAO();
		EsRoomDTO dto = new EsRoomDTO();

		Thread t = new Thread();

		slowPrint("손님방에 들어왔습니다.", t);
		System.out.println();
		slowPrint("주변을 둘러보니 여러곳이 눈에 들어왔습니다.", t);
		System.out.println();
		slowPrint("살인마가 들어오기 전에 빨리 살펴봐야 합니다.", t);

		Loop: while (true) {
			System.out.println();
			slowPrint("어디를 찾아야 할까?.....", t);
			System.out.println("[1]침대 밑 [2]옷걸이 [3]서랍장 [4]전등 [5]나가기 [6]종료 >>");
			int select = sc.nextInt();
			if (dao.kill(dto) == true) {
				slowPrint("살인마에게 걸려 사망했습니다.", t);
				dao.reset(dto);
				break Loop;
			}

			if (select == 1) {
				System.out.println("***침대***");
				System.out.println("헝클어진 이블이 쌓여 있는 것이 보인다.");

				while (true) {
					System.out.print("[1]이블을 걷어본다[2]침대 밑 주변을 살펴본다[3]볼게없다 되돌아간다 >>");
					select = sc.nextInt();
					if (dao.kill(dto) == true) {
						System.out.println("살인마에게 걸려 사망했습니다.");
						dao.reset(dto);
						break Loop;
					}
					if (select == 1) {
						System.out.println("이블을 걷었는데 갑자기 바퀴벌레들이 튀어나왔다.");
					}

					else if (select == 2) {
						if (dto.getGukey() == 0) {
     
							if (dto.getBotool() == 1) {
								slowPrint("효자손으로 끄집어내 열쇠조각을 획득했다..", t);
								dto.setGukey(1);
								dto.setMasterkey(dto.getMasterkey() + 1);
							} else {
								slowPrint("무엇인가가 구석 어두운 곳에서 물체가 보이긴 하다.", t);

								slowPrint("손으로는 안될 것 같다...", t);

								slowPrint("무언가 길다란 것이 필요할 것 같다.", t);
								System.out.println();
							}

						} else {
							slowPrint("이미 조사를 한 곳이다.", t);
						}

					} else if (select == 3) {
						break;
					} else {
						System.out.println("잘못된 숫자를 입력하였습니다.");
					}
				}
			} else if (select == 2) {

				System.out.println("***옷걸이***");
				slowPrint("옷걸이의 모양이 특이한걸!... ", t);
				while (true) {
					System.out.print("[1]옷걸이를 살펴본다 [2]볼게없다 되돌아간다 >>");
					select = sc.nextInt();
					if (dao.kill(dto) == true) {
						System.out.println("살인마에게 걸려 사망했습니다.");
						dao.reset(dto);
						break Loop;
					}
					if (select == 1) {
						slowPrint("그런데 사용하지는 못할 것 같다.", t);

					} else if (select == 2) {
						break;
					} else {
						System.out.println("잘못된 숫자를 입력하였습니다");
					}

				}

			}

			else if (select == 3) {

				System.out.println("***서랍장***");
				while (true) {

					System.out.println("[1] 윗서랍 확인 [2] 서랍 밑에 보기 [3]나가기 >>");
					select = sc.nextInt();
					if (dao.kill(dto) == true) {
						slowPrint("살인마에게 걸려 사망했습니다.", t);
						dao.reset(dto);
//						break Loop;
					}

					if (select == 1) {
						if (dto.getGutool() == 0) {
							slowPrint("서랍장을 열어보니 망치가 있어 챙겼다.", t);
							dto.setGutool(1);
						} else {
							System.out.println("서랍장 안이 비어있다.");
						}
					} else if (select == 2) {
						System.out.println("서랍 밑에는 먼지만 쌓여 있다.");
					} else if (select == 3) {
						break;
					} else {
						System.out.println("잘못된 숫자를 입력하였습니다");
					}
				}

			} else if (select == 4) {
				System.out.println("***전등***");
				System.out.println("전등의 불빛이 어둡다...");
				while (true) {
					System.out.print("[1]전등을 살펴본다 [2]볼게없다 되돌아간다 >>");
					select = sc.nextInt();
					if (dao.kill(dto) == true) {
						System.out.println("살인마에게 걸려 사망했습니다.");
						dao.reset(dto);
						break Loop;
					}
					if (select == 1) {
						slowPrint("전등 안에는 별 다른게 없다... ", t);

					} else if (select == 2) {
						break;
					} else {
						System.out.println("잘못된 숫자를 입력하였습니다");
					}

				}

			} else if (select == 5) {
				break;
			} else if (select == 6) {
				dao.save(dto);
				break Loop;
			} else {
				slowPrint("손이 떨려..그만 번호를 잘못 눌렀다...", t);
			}

//			}

		}

	}

	private static void slowPrint(String str, Thread t) {

		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
			try {
				t.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
