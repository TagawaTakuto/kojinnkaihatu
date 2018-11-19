package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;
import beans.UserDataBeans;
import model.User;

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
	public User UserData(String login_id, String password) {
		Connection conn = null;
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
			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("user_name");
			return new User(loginIdData, nameData);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
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
				udb.setBirth_date(rs.getDate("birth_date"));
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
	public static void updateUser(UserDataBeans udb) throws SQLException {
		// 更新された情報をセットされたJavaBeansのリスト
		UserDataBeans updatedUdb = new UserDataBeans();
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("UPDATE user SET name=?, login_id=? WHERE id=?;");
			st.setString(1, udb.getName());
			st.setString(2, udb.getLoginId());
			st.setInt(3, udb.getId());
			st.executeUpdate();
			System.out.println("update has been completed");

			st = con.prepareStatement("SELECT name, login_id FROM user WHERE id=" + udb.getId());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				updatedUdb.setName(rs.getString("name"));
				updatedUdb.setLoginId(rs.getString("login_id"));
			}

			st.close();
			System.out.println("searching updated-UserDataBeans has been completed");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
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
