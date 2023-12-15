package GuestRoom;



	
	import java.util.Scanner;

//	import javazoom.jl.player.MP3Player;

	public class EsRoomMain {

		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
			EsRoomDAO dao = new EsRoomDAO();
			EsRoomController con = new EsRoomController();
			Thread t = new Thread();
//			MP3Player mp3 = new MP3Player();
//			String compath = "C:\\Users\\USER\\Desktop\\JavaStudy\\EscapeGame\\\\src\\\\player\\\\";
//			Music m = new Music("Butterfly", "전영호", compath + "Butterfly.mp3");
//			mp3.play(m.getPath());
			int input = 0;
			int select = 0;
			while (true) {
				System.out.println();
				System.out.println("==Escape Room==");
				System.out.print("[1]회원가입 [2]로그인 [3]회원탈퇴 [4] 종료 >> ");
				input = sc.nextInt();
				if (input == 1) {
					System.out.println();
					System.out.println("==회원가입==");
					System.out.print("ID : ");
					String id = sc.next();
					System.out.print("PASSWORD : ");
					String pw = sc.next();
					System.out.print("NICKNAME : ");
					String nickname = sc.next();

					EsRoomDTO dto = new EsRoomDTO();
					dto.setId(id);
					dto.setPw(pw);
					dto.setNickname(nickname);
					int row = dao.join(dto);
					if (row > 0) {
						System.out.println("**회원가입 성공**");
					} else {
						System.out.println("**회원가입 실패**");
					}
				} else if (input == 2) {
					System.out.println();
					System.out.println("==로그인==");
					System.out.print("id : ");
					String id = sc.next();
					System.out.print("password : ");
					String pw = sc.next();
					EsRoomDTO dto = new EsRoomDTO();
					dto.setId(id);
					dto.setPw(pw);
					EsRoomDTO result = dao.login(dto);
					if (result != null) {
						System.out.println("**로그인 성공**");
						System.out.println("환영합니다. " + result.getNickname() + "님");
						while (true) {
							System.out.println();
							System.out.println("==게임 메뉴==");
							System.out.print("[1]새로하기 [2]이어하기 [3]로그아웃 >> ");
							input = sc.nextInt();
							if (input == 1 || input == 2) {
								if (input == 1) {
									dao.reset(dto);
									con.slowPrint("\"평소 왕래가 없던 이웃 주민의 저녁식사에 초대받아 식탁앞에 앉았는데 그 이후의 기억이 없다.\"", t);
									con.slowPrint("\"아무래도 이웃 주민이 음식에 약을 탄 모양이다.\"", t);
									con.slowPrint("\"상황파악을 위해 집을 둘러본 결과, 이웃주민의 정체는 연일 뉴스에서 떠들던 의문의 연쇄살인마였다.\"", t);
									con.slowPrint("\"이웃 주민은 나간듯 하니 이웃주민이 돌아오기 전에 이 집에서 탈출해야한다.\"", t);
								} else {
									dao.load(dto);
								}
								Loop: while (true) {
									System.out.println();
									System.out.println("====1층====");
									System.out.print("[1] 밖으로 나가기 [2]안방들어가기 [3]주방들어가기 [4]2층올라가기 [5]도구 인벤토리 [6]게임종료 >> ");
									select = sc.nextInt();
									if (con.kill(dto) == true) {
										dao.reset(dto);
										break Loop;
									}

									if (select == 1) {
										if (dto.getMasterkey() == 4) {
											con.slowPrint("\"연쇄살인마로부터 무사히 탈출에 성공했다.\"", t);
											con.slowPrint("\"하지만 타겟이 된 이상 완전히 안전하진 않다.\"", t);
											con.slowPrint("\"나의 안전을 위해 연쇄살인마를... 죽   여   야   만   한   다......\"", t);
											con.slowPrint("추가진행은 DLC를 구매해 주세요.", t);
											dao.save(dto);
											break;
										} else {
											System.out.println("문이 잠겨 있어 나갈 수 없다. 열쇠가 필요할것 같다.");
										}
									} else if (select == 2) {
										System.out.println();
										System.out.println("====안방====");
										System.out.println("안방에 들어왔다. 꽤 오랫동안 청소를 안한 듯 싶다.");
										while (true) {
											System.out.println();
											System.out.print("[1]옷장 [2]화장대 [3]침대 [4]커튼 [5]안방에서 나간다. [6]게임종료 >> ");
											select = sc.nextInt();
											if (con.kill(dto) == true) {
												dao.reset(dto);
												break Loop;
											}
											if (select == 1) {
												System.out.println();
												System.out.println("***옷장***");
												System.out.println("대저택의 방답게 옷장도 화려하다.");
												while (true) {
													System.out.println();
													System.out.print("[1]옷장 열기 [2]옷장 위 [3]돌아가기 >> ");
													select = sc.nextInt();
													if (con.kill(dto) == true) {
														dao.reset(dto);
														break Loop;
													}
													if (select == 1) {
														// 옷장 열기
														if (dto.getBetool() == 0) {
															System.out.println("옷장 안에서 손전등을 획득했다.");
															dto.setBetool(1);

														} else {
															System.out.println("옷 하나 없이 텅 비어있다.");

														}
													} else if (select == 2) {
														// 옷장 위
														System.out.println("먼지만 가득 쌓여있다.");
													} else if (select == 3) {
														// 돌아가기
														break;
													} else {
														System.out.println("잘못된 숫자를 입력하였습니다");
													}
												}
											} else if (select == 2) {
												System.out.println();
												System.out.println("***화장대***");
												System.out.println("거울은 얼룩덜룩하지만 고급스러운 화장대다.");
												while (true) {
													System.out.println();
													System.out.print("[1]거울보기 [2]서랍열기 [3]돌아가기 >> ");
													select = sc.nextInt();

													if (con.kill(dto) == true) {
														dao.reset(dto);
														break Loop;
													}
													if (select == 1) {
														// 거울 보기
														System.out.println("빨간 글씨같은 것들이 있다. 하지만 알아볼 수 없다.");
													} else if (select == 2) {
														// 서랍 열기
														System.out.println("다 끊어진 머리끈들이 있다.쓸모 없어 보인다.");
													} else if (select == 3) {
														// 돌아가기
														break;
													} else {
														System.out.println("잘못된 숫자를 입력하였습니다");
													}
												}
											} else if (select == 3) {
												System.out.println();
												System.out.println("***침대***");
												System.out.println("푹신해보이고 잘 정리되어 있는 침대다.");
												while (true) {
													System.out.println();
													System.out.print("[1]이불 아래 [2]침대 밑 [3]돌아가기 >> ");
													select = sc.nextInt();
													if (con.kill(dto) == true) {
														dao.reset(dto);
														break Loop;
													}
													if (select == 1) {
														// 이불 아래
														System.out.println("얼룩진 이불이 깔려있다. 누으면 굉장히 불쾌할 것 같다.");
													} else if (select == 2) {
														// 침대 밑
														if (dto.getBekey() == 0) {
															if (dto.getBetool() == 0) {
																System.out.println("반짝거리는 무언가가 있다. 꺼낼수 있는 도구가 필요할 것 같다.");
															} else {
																System.out.println("갈고리를 사용해 열쇠조각을 획득했다..");
																dto.setBekey(1);
																dto.setMasterkey(dto.getMasterkey() + 1);
																System.out.println(dto.getMasterkey() + " / 4");
															}
														} else {
															System.out.println("먼지들만 쌓여있다.");
														}
													} else if (select == 3) {
														// 돌아가기
														break;
													} else {
														System.out.println("잘못된 숫자를 입력하였습니다");
													}
												}
											} else if (select == 4) {
												System.out.println();
												System.out.println("***커튼***");
												System.out.println("벽면 한쪽을 다 가릴만큼 큰 커튼이다.");
												while (true) {
													System.out.println();
													System.out.print("[1]커튼 뒤 [2]커튼 무늬 [3]돌아가기 >> ");
													select = sc.nextInt();
													if (con.kill(dto) == true) {
														dao.reset(dto);
														break Loop;
													}
													if (select == 1) {
														// 커튼 뒤
														System.out.println("커튼 뒤 창문에 창살이 있다. 이쪽으로는 못 나갈 것 같다.");
													} else if (select == 2) {
														// 커튼 무늬
														System.out.println("자세히 보니 꽃무늬다. 집주인 취향인가보다.");
													} else if (select == 3) {
														// 돌아가기
														break;
													} else {
														System.out.println("잘못된 숫자를 입력하였습니다");
													}
												}
											} else if (select == 5) {
												// 방 나가기
												System.out.println("안방에서 나간다.");
												break;
											} else if (select == 6) {
												dao.save(dto);
												break Loop;
											} else {
												System.out.println("잘못된 숫자를 입력하였습니다");
											}
										}
									} else if (select == 3) {
										System.out.println();
										System.out.println("====주방====");
										System.out.println("주방에 들어왔다 . 주방에 악취가 가득하다.");
										while (true) {
											System.out.println();
											System.out.print("[1]냉장고 [2]찬장 [3]싱크대 [4]오븐 [5]주방에서 나간다. [6]게임종료 >> ");
											select = sc.nextInt();
											if (con.kill(dto) == true) {
												dao.reset(dto);
												break Loop;
											}
											if (select == 1) {
												System.out.println();
												System.out.println("***냉장고***");
												System.out.println("대저택이라 그런지 냉장고도 엄청 크다.");
												while (true) {
													System.out.println();
													System.out.print("[1]냉장고를 열어본다 [2]냉장고 위를 살펴본다 [3]돌아가기 >> ");
													select = sc.nextInt();
													if (con.kill(dto) == true) {
														dao.reset(dto);
														break Loop;
													}
													if (select == 1) {
														System.out.println("냉장고를 열어봤지만  특별한게 보이지는 않는다.");
													} else if (select == 2) {
														System.out.println("냉장고 위에 죽은 쥐가 있다.");
													} else if (select == 3) {
														break;
													} else {
														System.out.println("잘못된 숫자를 입력하였습니다");
													}
												}
											} else if (select == 2) {
												System.out.println();
												System.out.println("***찬장***");
												System.out.println("유리로된 찬장이 보인다.");

												while (true) {
													System.out.println();
													System.out.print("[1]찬장을 열어본다 [2]찬장 주변을 살펴본다 [3]돌아가기 >> ");
													select = sc.nextInt();
													if (con.kill(dto) == true) {
														dao.reset(dto);
														break Loop;
													}
													if (select == 1) {
														if (dto.getKikey() == 1) {
															System.out.println("이미 조사를 한 곳이다.");
														} else {
															if (dto.getGutool() == 0) {
																System.out.println("찬장이 잠겨있어 유리를 깰 무언가가 필요할것 같다.");
															} else {
																System.out.println("망치로 찬장유리를 깨 열쇠조각을 획득했다..");
																dto.setKikey(1);
																dto.setMasterkey(dto.getMasterkey() + 1);
																System.out.println(dto.getMasterkey() + " / 4");
															}
														}
													} else if (select == 2) {
														System.out.println("찬장 주변을 살펴봤지만 먼지 밖에 안보인다.");
													} else if (select == 3) {
														break;
													} else {
														System.out.println("잘못된 숫자를 입력하였습니다.");
													}
												}

											} else if (select == 3) {
												System.out.println();
												System.out.println("***싱크대***");
												System.out.println("싱크대에는 설거짓거리들로 가득차서 악취가 난다.");
												while (true) {
													System.out.println();
													System.out.print("[1]싱크대안을 살펴본다 [2]돌아가기 >> ");
													select = sc.nextInt();
													if (con.kill(dto) == true) {
														dao.reset(dto);
														break Loop;
													}
													if (select == 1) {
														System.out.println("싱크대안을 살펴봤지만 설거짓거리와 날파리들로 가득찼다.");
													} else if (select == 2) {
														break;
													} else {
														System.out.println("잘못된 숫자를 입력하였습니다");
													}
												}
											} else if (select == 4) {
												System.out.println();
												System.out.println("***오븐***");
												System.out.println("오븐은 음식 찌꺼기와 기구들로 가득차있다.");
												while (true) {
													System.out.println();
													System.out.print("[1]오븐 조사하기 [2]오븐 작동시키기 [3]돌아가기 >> ");
													select = sc.nextInt();
													if (con.kill(dto) == true) {
														dao.reset(dto);
														break Loop;
													}
													if (select == 1) {
														if (dto.getKitool() == 0) {
															System.out.println("오븐에서 갈고리를 획득했다.");
															dto.setKitool(1);
														} else {
															System.out.println("오븐안에는 음식 찌꺼기들만 있다.");
														}
													} else if (select == 2) {
														System.out.println("콘센트가 뽑혀있는지 오븐은 작동하지 않는다.");
													} else if (select == 3) {
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
												System.out.println("잘못된 숫자를 입력하였습니다");
											}
										}
									} else if (select == 4) {
										while (true) {
											System.out.println();
											System.out.println("====2층====");
											System.out.print("[1]게스트룸 [2]서재 [3]1층으로 내려가기 [4]도구 인벤토리 [5]게임종료 >> ");
											select = sc.nextInt();
											if (con.kill(dto) == true) {
												dao.reset(dto);
												break Loop;
											}
											if (select == 1) {
												System.out.println();
												System.out.println("====게스트룸====");
												System.out.println("게스트룸에 들어왔다. 여러 가구들이 보인다.");
												while (true) {
													System.out.println("[1]침대 밑 [2]옷걸이 [3]서랍장 [4]전등 [5]돌아가기 [6]게임종료 >> ");
													select = sc.nextInt();
													if (con.kill(dto) == true) {
														dao.reset(dto);
														break Loop;
													}

													if (select == 1) {
														System.out.println();
														System.out.println("***침대***");
														System.out.println("헝클어진 이블이 쌓여 있는 것이 보인다.");

														while (true) {
															System.out.println();
															System.out.print("[1]이블을 걷어본다 [2]침대 밑 주변을 살펴본다 [3]돌아가기 >> ");
															select = sc.nextInt();
															if (con.kill(dto) == true) {
																dao.reset(dto);
																break Loop;
															}
															if (select == 1) {
																System.out.println("이블을 걷었는데 갑자기 바퀴벌레들이 튀어나왔다.");
															} else if (select == 2) {
																if (dto.getGukey() == 0) {
																	if (dto.getBotool() == 1) {
																		System.out.println("효자손으로 끄집어내 열쇠조각을 획득했다");
																		dto.setGukey(1);
																		dto.setMasterkey(dto.getMasterkey() + 1);
																		System.out.println(dto.getMasterkey() + " / 4");
																	} else {
																		System.out.println("무엇인가가 구석 어두운 곳에서 물체가 보인다");
																		System.out.println(
																				"안쪽에 있어 손이 닿지 않아 길다란 물체가 필요할 것 같다.");
																	}
																} else {
																	System.out.println("이미 조사를 한 곳이다.");
																}
															} else if (select == 3) {
																break;
															} else {
																System.out.println("잘못된 숫자를 입력하였습니다.");
															}
														}
													} else if (select == 2) {
														System.out.println();
														System.out.println("***옷장***");
														System.out.println("낡은 옷장이 보인다.");
														while (true) {
															System.out.println();
															System.out
																	.print("[1]옷장 속 옷걸이를 살펴본다. [2]옷장 위를 살펴본다. [3]돌아가기 >> ");
															select = sc.nextInt();
															if (con.kill(dto) == true) {
																dao.reset(dto);
																break Loop;
															}
															if (select == 1) {
																System.out.println("평범한 옷걸이다.");
															} else if (select == 2) {
																System.out.println("옷장위엔 개미들이 기어다니고 있다.");
															} else if (select == 3) {
																break;
															} else {
																System.out.println("잘못된 숫자를 입력하였습니다.");
															}

														}

													}

													else if (select == 3) {
														System.out.println();
														System.out.println("***서랍장***");
														System.out.println("쓰레기장에서나 보일법한 서랍이다.");
														while (true) {
															System.out.println();
															System.out.println("[1] 서랍 위 확인 [2] 서랍 밑 확인 [3]돌아가기 >> ");
															select = sc.nextInt();
															if (con.kill(dto) == true) {
																dao.reset(dto);
																break Loop;
															}
															if (select == 1) {
																if (dto.getGutool() == 0) {
																	System.out.println("서랍장을 열어보니 망치가 있어 챙겼다.");
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
														System.out.println();
														System.out.println("***전등***");
														System.out.println("전등의 불빛이 어둡다");
														while (true) {
															System.out.println();
															System.out.print("[1]전등을 살펴본다 [2]전등을 킨다. [3]돌아가기 >> ");
															select = sc.nextInt();
															if (con.kill(dto) == true) {
																dao.reset(dto);
																break Loop;
															}
															if (select == 1) {
																System.out.print("전등 안에는 별 다른게 없다");
															} else if (select == 2) {
																System.out.println("전등에 불이 잠깐 들어오다 꺼졌다. 아무래도 고장난 듯 하다.");
															} else if (select == 3) {
																break;
															} else {
																System.out.println("잘못된 숫자를 입력하였습니다.");
															}
														}
													} else if (select == 5) {
														System.out.println("게스트룸을 나간다.");
														break;
													} else if (select == 6) {
														dao.save(dto);
														break Loop;
													} else {
														System.out.println("잘못된 숫자를 입력하였습니다.");
													}
												}
											}
											if (select == 2) {
												System.out.println();
												System.out.println("====서재====");
												System.out.println("서재에 들어왔다. 먼지와 종이냄새가 나를 덮친다.");
												while (true) {
													System.out.println();
													System.out.print("[1]책장 [2]책상 [3]제습기 [4]소파 [5]서재에서 나간다. [6]게임종료 >> ");
													select = sc.nextInt();
													if (con.kill(dto) == true) {
														dao.reset(dto);
														break Loop;
													}
													if (select == 1) {
														System.out.println();
														System.out.println("***책장***");
														System.out.println("다양한 장르의 책들이 꽂혀있다.");
														while (true) {
															System.out.println();
															System.out.print("[1]추리소설 조사 [2]백과사전 조사 [3]돌아가기 >> ");
															select = sc.nextInt();
															if (con.kill(dto) == true) {
																dao.reset(dto);
																break Loop;
															}
															if (select == 1) {
																System.out.println("추리소설 책은 부분부분 찢어져 있고 여기저기 낙서가 있다.");
															} else if (select == 2) {
																System.out.println("백과사전은 한번도 보지 않았는지 아주 깨끗하다.");
															} else if (select == 3) {
																break;
															} else {
																System.out.println("잘못된 숫자를 입력하였습니다.");
															}
														}
													} else if (select == 2) {
														System.out.println();
														System.out.println("***책상***");
														System.out.println("책상은 여러 필기구와 책들로 어지러져 있다.");
														while (true) {
															System.out.println();
															System.out.print("[1]책상서랍[2]책상 밑 [3]돌아가기 >> ");
															select = sc.nextInt();
															if (con.kill(dto) == true) {
																dao.reset(dto);
																break Loop;
															}
															if (select == 1) {
																System.out.println("집 주인의 일기로 보이는 다이어리가 있다.");
															} else if (select == 2) {
																if (dto.getBotool() == 0) {
																	System.out.println("효자손이 떨어져 있다. 효자손을 획득했다.");
																	dto.setBotool(1);
																} else {
																	System.out.println("먼지만 쌓여있다.");
																}
															} else if (select == 3) {
																break;
															} else {
																System.out.println("잘못된 숫자를 입력하였습니다.");
															}
														}
													} else if (select == 3) {
														System.out.println();
														System.out.println("***제습기***");
														System.out.println("서재 습도관리를 위한 제습기인것 같다.");
														while (true) {
															System.out.println();
															System.out.print("[1]제습기안쪽 보기 [2]제습기뒷판 열기 [3]돌아가기 >> ");
															select = sc.nextInt();
															if (con.kill(dto) == true) {
																dao.reset(dto);
																break Loop;
															}
															if (select == 1) {
																if (dto.getGutool() == 0) {
																	System.out.println("제습기 안쪽이 어두워 보이지 않는다.");
																} else {
																	System.out.println("손전등을 사용해 제습기 안을 비춰 열쇠를 찾았다.");
																	dto.setBokey(1);
																	dto.setMasterkey(dto.getMasterkey() + 1);
																	System.out.println(dto.getMasterkey() + " / 4");
																}
															} else if (select == 2) {
																System.out.println("제습기 뒷판을 열었지만 전선들밖에 보이지 않는다.");
															} else if (select == 3) {
																break;
															} else {
																System.out.println("잘못된 숫자를 입력하였습니다.");
															}
														}
													} else if (select == 4) {
														System.out.println();
														System.out.println("***소파***");
														while (true) {
															System.out.println();
															System.out.print("[1]소파밑 조사 [2]소파시트 들어보기 [3] 돌아가기 >> ");
															select = sc.nextInt();
															if (con.kill(dto) == true) {
																dao.reset(dto);
																break Loop;
															}
															if (select == 1) {
																System.out.println("바퀴벌레가 기어다니고 있다.");
															} else if (select == 2) {
																System.out.println("곰팡이가 피어있다.");
															} else if (select == 3) {
																break;
															} else {
																System.out.println("잘못된 숫자를 입력하였습니다.");
															}
														}
													} else if (select == 5) {
														System.out.println("서재에서 나갑니다.");
														break;
													} else if (select == 6) {
														dao.save(dto);
														break Loop;
													} else {
														System.out.println("잘못된 숫자를 입력하였습니다.");
													}

												}
											}
											if (select == 3) {
												break;
											}
											if (select == 4) {
												System.out.println(con.inventory(dto));
											}
											if (select == 5) {
												dao.save(dto);
												break Loop;
											}
										}

									} else if (select == 5) {
										System.out.println(con.inventory(dto));
									} else if (select == 6) {
										dao.save(dto);
										break;
									} else {
										System.out.println("잘못된 숫자를 입력하였습니다.");
									}
								}
							} else if (input == 3) {
								break;
							} else {
								System.out.println("잘못된 숫자를 입력하였습니다.");
							}
						}
					} else {
						System.out.println("회원정보가 존재하지 않거나 일치하지 않습니다.");
					}
				} else if (input == 3) {
					System.out.println();
					System.out.println("==회원 탈퇴==");
					System.out.print("ID : ");
					String id = sc.next();
					System.out.print("PASSWORD : ");
					String pw = sc.next();
					EsRoomDTO dto = new EsRoomDTO();
					dto.setId(id);
					dto.setPw(pw);
					int row = dao.delete(dto);
					if (row > 0) {
						System.out.println("회원탈퇴 되었습니다.");
					} else {
						System.out.println("존재하지 않거나 올바르지 않은 회원정보입니다.");
					}
				} else if (input == 4) {
					break;
				} else {
					System.out.println("잘못된 입력입니다.");
				}
			}

		}
	}
