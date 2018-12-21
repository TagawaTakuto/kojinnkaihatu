package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import model.Seach;

public class GenreDao {
	//更新用商品のジャンル参照//
	public List<Seach> GenreSeach(int Id) {
		Connection con = null;
		List<Seach> GL = new ArrayList<Seach>();
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM genre LEFT JOIN genre_detail ON  genre.id = genre_detail.genre_id AND genre_detail.item_id = "
					+ Id + " ORDER BY genre.id";
			Statement stmt;

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				Seach GS = new Seach();
				GS.setId(rs.getInt("genre.id"));
				GS.setName(rs.getString("genre.name"));
				GS.setComparisonId(rs.getInt("genre_detail.genre_id"));
				GL.add(GS);
			}
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

	//TOPページアイテムリスト//
	public static List<Seach> GenreAll() {
		Connection con = null;
		List<Seach> GL = new ArrayList<Seach>();
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM genre";
			Statement stmt;

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				Seach GS = new Seach();
				GS.setId(rs.getInt("id"));
				GS.setName(rs.getString("name"));
				GL.add(GS);
			}
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
		return GL;
	}

	//商品詳細ジャンルデータ参照//
	public List<String> Genre(int Id) {
		Connection con = null;
		List<String> G = new ArrayList<String>();
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM item LEFT JOIN genre_detail ON item.id = genre_detail.item_id LEFT JOIN genre ON genre_detail.genre_id = genre.id WHERE item.id ="
					+ Id;
			Statement stmt;

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				String g = "";
				g = rs.getString("genre.name");
				G.add(g);
			}
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
		return G;
	}

	//アイテムリスト用//
	public static List<Seach> GenreSeachToItemList(List<Integer> Id) {
		Connection con = null;
		List<Seach> GL = new ArrayList<Seach>();
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM genre";
			Statement stmt;

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				Seach GS = new Seach();
				for (int i : Id) {
					if (i == rs.getInt("id")) {
						GS.setComparisonId(i);
					}
					GS.setName(rs.getString("name"));
					continue;
				}
				GS.setId(rs.getInt("id"));
				GL.add(GS);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
		return GL;

	}
}
