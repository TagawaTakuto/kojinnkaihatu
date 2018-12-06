package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.GenreDataBeans;

public class GenreDao {
	//商品のジャンル参照//
	public List<Integer> GenreSeach(int Id) {
		Connection con = null;
		List<Integer> GL = new ArrayList<Integer>();
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM genre_detail WHERE item_id = " + Id;
			Statement stmt;

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				int gddb;
				gddb = rs.getInt("genre_id");
				GL.add(gddb);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return GL;

	}

	//ジャンル更新用一旦削除""
	public void GenreDelete(int id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "DELETE FROM genre_detail WHERE item_id =?";
			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, id);

			int i = st.executeUpdate();
			System.out.println(i);
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

	//商品追加ジャンル//
	public void GenreCreate(int Id, ArrayList<Integer> g) {
		Connection con = null;
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO genre_detail VALUES (" + Id + "," + g.get(0) + ")";
			for (int i = 1; g.size() > i; i++) {
				sql += ",";
				sql += "(" + Id + "," + g.get(i) + ")";
			}
			System.out.println(sql);

			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
	}

	//ジャンルデータベースの抽出//
	public List<GenreDataBeans> GenreAll(){
		Connection con = null;
		List<GenreDataBeans> GL = new ArrayList<GenreDataBeans>();
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM genre ";
			Statement stmt;

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				GenreDataBeans gddb = new GenreDataBeans();
				gddb.setId(rs.getInt("genre_detail.genre_id"));
				gddb.setName(rs.getString("name"));
				GL.add(gddb);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return GL;

	}
}
