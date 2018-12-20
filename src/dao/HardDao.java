package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import model.Seach;

public class HardDao {
	public static List<Seach> HardAll() {
		Connection conn = null;
		List<Seach> HardList = new ArrayList<Seach>();
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM hard";
			System.out.println(sql);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Seach hard = new Seach();
				hard.setId(rs.getInt("id"));
				hard.setName(rs.getString("name"));

				HardList.add(hard);
			}
		} catch (

		SQLException e) {
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
		return HardList;
	}

	//アイテムリスト用//
	public static List<Seach> HardSeach(ArrayList<Integer> Id) {
		Connection con = null;
		List<Seach> HL = new ArrayList<Seach>();
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM hard";
			Statement stmt;

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				Seach HS = new Seach();
				for (int i : Id) {
					if (i == rs.getInt("id")) {
						HS.setComparisonId(i);
					}
					HS.setName(rs.getString("name"));
					continue;
				}
				HS.setId(rs.getInt("id"));
				HL.add(HS);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return HL;

	}
}
