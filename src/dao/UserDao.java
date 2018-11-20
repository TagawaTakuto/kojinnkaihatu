package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;
import beans.UserDataBeans;

public class UserDao {

	/*新規登録*/
	public static void insertUser(String loginId, String Name, String Password, String Birthdate) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO user(login_id,user_name,password,birth_date,create_date,update_date) VALUES(?,?,?,?, now(),now());");
			st.setString(1, loginId);
			st.setString(2, Name);
			st.setString(3, Password);
			st.setString(4, Birthdate);
			st.executeUpdate();

			System.out.println("inserting user has been completed");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/*ログイン*/
	public UserDataBeans UserData(String login_id, String password) {
		Connection conn = null;
		UserDataBeans udb = new UserDataBeans();
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ? and password = ? ;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login_id);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}
			udb.setId(rs.getInt("user_id"));
			udb.setLoginId(rs.getString("login_id"));
			udb.setName(rs.getString("user_name"));
			udb.setPassword(rs.getString("password"));
			udb.setBirthDate(rs.getDate("birth_date"));
			udb.setCreateDate(rs.getDate("create_date"));
			udb.setUpdateDate(rs.getDate("update_date"));

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
			}
		}
		return udb;
	}

	/*ID比較*/
	public String getUserDataBeansByUserId(String loginId) throws SQLException {
		String udb = null;
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM user WHERE login_id = ?");
			st.setString(1, loginId);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				udb = (rs.getString("login_id"));
			}

			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}

		System.out.println("searching UserDataBeans by userId has been completed");
		return udb;
	}

	/*ユーザデータ検索*/
	public UserDataBeans getUserData(String loginId) throws SQLException {
		UserDataBeans udb = new UserDataBeans();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM user WHERE login_id = ?");
			st.setString(1, loginId);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				udb.setId(rs.getInt("user_id"));
				udb.setLoginId(rs.getString("login_id"));
				udb.setName(rs.getString("user_name"));
				udb.setPassword(rs.getString("password"));
				udb.setBirthDate(rs.getDate("birth_date"));
				udb.setCreateDate(rs.getDate("create_date"));
				udb.setUpdateDate(rs.getDate("update_date"));

			}

			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}

		System.out.println("searching UserDataBeans by userId has been completed");
		return udb;
	}

	/*ユーザデータ更新*/
	public void UserUpdate(String UserId, String loginId, String nameData, String Password) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "UPDATE user SET update_date = now() ";

			if (!loginId.equals("")) {
				sql += " ,login_id" + " = " + "'" + loginId + "'";
			}

			if (!nameData.equals("")) {
				sql += " ,user_name" + "=" + "'" + nameData + "'";
			}

			if (!Password.equals("")) {
				sql += " ,password" + "=" + "'" + Password + "'";
			}

			sql += "WHERE user_id" + "=" + UserId ;

			PreparedStatement st = conn.prepareStatement(sql);
			st.executeUpdate();
			System.out.println(st);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return;

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return;
				}
			}
		}
	}

	/*ID重複確認*/
	public static boolean isOverlapLoginId(String loginId, int userId) throws SQLException {
		// 重複しているかどうか表す変数
		boolean isOverlap = false;
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			// 入力されたlogin_idが存在するか調べる
			st = con.prepareStatement("SELECT login_id FROM user WHERE login_id = ? AND id != ?");
			st.setString(1, loginId);
			st.setInt(2, userId);
			ResultSet rs = st.executeQuery();

			System.out.println("searching loginId by inputLoginId has been completed");

			if (rs.next()) {
				isOverlap = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}

		System.out.println("overlap check has been completed");
		return isOverlap;
	}

}
