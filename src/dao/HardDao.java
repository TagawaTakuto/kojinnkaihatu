package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.HardDataBeans;

public class HardDao {
	public List<HardDataBeans> HardAll() {
		Connection conn = null;
		List<HardDataBeans> HardList = new ArrayList<HardDataBeans>();
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM hard";
			System.out.println(sql);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				HardDataBeans hard = new HardDataBeans();
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
}
