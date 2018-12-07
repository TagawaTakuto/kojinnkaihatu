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
import model.GenreSeach;

public class GenreDao {
	//商品のジャンル参照//
	public List<GenreSeach> GenreSeach(int Id) {
		Connection con = null;
		List<GenreSeach> GL = new ArrayList<GenreSeach>();
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM genre LEFT JOIN genre_detail ON  genre.id = genre_detail.genre_id AND genre_detail.item_id = " + Id + " ORDER BY genre.id";
			Statement stmt;

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				GenreSeach gddb = new GenreSeach();
				gddb.setGenreId(rs.getInt("genre_detail.genre_id"));
				gddb.setName(rs.getString("genre.name"));
				gddb.setHikakuId(rs.getInt("genre.id"));
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

	//商品更新時の比較用ジャンルデータベースの抽出//
	public List<GenreDataBeans> GenreAll(){
		Connection con = null;
		List<GenreDataBeans> GL = new ArrayList<GenreDataBeans>();
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM genre INNER JOIN genre_detail ON genre.id = genre_detail.genre_id";
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
