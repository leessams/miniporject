package GuestRoom;



	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class EsRoomDAO {

		private Connection conn = null;
		private PreparedStatement psmt = null;
		private ResultSet rs = null;

		private void getConn() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@project-db-cgi.smhrd.com:1524:xe";
				String userName = "cgi_23IS_CLOUD1_mini_4";
				String userPw = "smhrd4";
				conn = DriverManager.getConnection(url, userName, userPw);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		private void getClose() {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("자원반납시 문제 발생");
			}
		}

		public int join(EsRoomDTO dto) {

			int row = 0;

			try {
				getConn();

				String sql = "INSERT INTO USER_INFO(USER_ID, USER_PW, USER_NICKNAME) VALUES(?, ?, ?)";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getId());
				psmt.setString(2, dto.getPw());
				psmt.setString(3, dto.getNickname());
				row = psmt.executeUpdate();

				sql = "INSERT INTO GAME_INFO (USER_ID) VALUES(?)";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getId());
				psmt.executeUpdate();

			} catch (Exception e) {
				System.out.println("아이디가 중복이거나 아이디, 비밀번호, 닉네임의 길이가 너무 깁니다.");
			} finally {
				getClose();
			}
			return row;
		}

		public int delete(EsRoomDTO dto) {
			int row = 0;

			try {
				getConn();

				String sql = "DELETE FROM GAME_INFO WHERE USER_ID = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getId());
				row = psmt.executeUpdate();

				sql = "DELETE FROM USER_INFO WHERE USER_ID = ? AND USER_PW = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getId());
				psmt.setString(2, dto.getPw());
				psmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				getClose();
			}
			return row;
		}

		public EsRoomDTO login(EsRoomDTO dto) {
			EsRoomDTO result = null;
			try {
				getConn();

				String sql = "SELECT USER_ID, USER_NICKNAME FROM USER_INFO WHERE USER_ID = ? AND USER_PW = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getId());
				psmt.setString(2, dto.getPw());

				rs = psmt.executeQuery();

				if (rs.next()) {
					result = new EsRoomDTO();
					result.setNickname(rs.getString("USER_NICKNAME"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				getClose();
			}
			return result;
		}

		public void save(EsRoomDTO dto) {
			try {
				getConn();
				String sql = "UPDATE  GAME_INFO SET KITOOL = ?, BETOOL = ?, GUTOOL = ?, BOTOOL = ?, KIKEY = ?, BEKEY =  ?, GUKEY = ?, BOKEY = ?, MASTERKEY = ?, GCOUNT  =  ? WHERE USER_ID = ? ";
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, dto.getKitool());
				psmt.setInt(2, dto.getBetool());
				psmt.setInt(3, dto.getGutool());
				psmt.setInt(4, dto.getBotool());
				psmt.setInt(5, dto.getKikey());
				psmt.setInt(6, dto.getBekey());
				psmt.setInt(7, dto.getGukey());
				psmt.setInt(8, dto.getBokey());
				psmt.setInt(9, dto.getMasterkey());
				psmt.setInt(10, dto.getGcount());
				psmt.setString(11, dto.getId());
				psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				getClose();
			}

		}

		public void reset(EsRoomDTO dto) {
			dto.setKitool(0);
			dto.setBetool(0);
			dto.setGutool(0);
			dto.setBotool(0);
			dto.setKikey(0);
			dto.setBekey(0);
			dto.setGukey(0);
			dto.setBokey(0);
			dto.setMasterkey(0);
			dto.setGcount(0);
		}

		public void load(EsRoomDTO dto) {
			try {
				getConn();
				String sql = "SELECT * FROM GAME_INFO WHERE USER_ID = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getId());
				rs = psmt.executeQuery();
				if (rs.next()) {
					dto.setKitool(rs.getInt("Kitool"));
					dto.setBetool(rs.getInt("Betool"));
					dto.setGutool(rs.getInt("Gutool"));
					dto.setBotool(rs.getInt("Botool"));
					dto.setKikey(rs.getInt("Kikey"));
					dto.setBekey(rs.getInt("Bekey"));
					dto.setGukey(rs.getInt("Gukey"));
					dto.setBokey(rs.getInt("Bokey"));
					dto.setMasterkey(rs.getInt("Masterkey"));
					dto.setGcount(rs.getInt("Gcount"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				getClose();
			}
		}
		
		public boolean kill(EsRoomDTO dto) {
			
			dto.setGcount(dto.getGcount() + 1);
			if (dto.getGcount() == 99999) {
				
			} else if (dto.getGcount() == 9999999) {
				
			} else if (dto.getGcount() == 999999999) {
				return true;
			}
			
			
			
			
			return false;
		}

	}

	
	
	

