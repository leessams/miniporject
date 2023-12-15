package GuestRoom;

public class EsRoomController {
	
	public boolean kill(EsRoomDTO dto) {

		dto.setGcount(dto.getGcount() + 1);
		if (dto.getGcount() == 99999) {
			//현관문 열고 닫는 소리
			System.out.println("\"집주인이 돌아온 것 같다. 서두르자\"");
		} else if (dto.getGcount() == 9999999) {
			//발걸음 소리
			System.out.println("\"집주인이 나를 찾고있다. 시간이 얼마 없다.\"");
		} else if (dto.getGcount() == 999999999) {
			System.out.println("-집주인이 나를 찾아내 탈출은 불가능해 졌다.-");
			return true;
		}

		return false;
	}
	
	public String inventory(EsRoomDTO dto) {
		String toolList = "";

		if (dto.getBotool() == 1) {
			toolList += " *효자손* ";
		}
		if (dto.getGutool() == 1) {
			toolList += " *망치* ";
		}
		if (dto.getKitool() == 1) {
			toolList += " *갈고리* ";
		}
		if (dto.getBetool() == 1) {
			toolList += " *손전등* ";
		}
		if (toolList == "") {
			toolList = "비어있음";
		}
		return toolList;
	}
	
	 public void slowPrint(String str, Thread t) {

		    for (int i = 0; i < str.length(); i++) {
		       System.out.print(str.charAt(i));
		       try {
		          t.sleep(40);
		       } catch (InterruptedException e) {
		          e.printStackTrace();
		       }
		    }
		    System.out.println("");
		}
	
	
	
}

