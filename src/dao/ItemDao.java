package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import model.Item;

public class ItemDao {

	//商品表示//
	public List<Item> ItemSearch(String Keyword, String SaleDateS,
			String SaleDateE, ArrayList<Integer> HId, ArrayList<Integer> GId, String Sort) {
		Connection conn = null;
		List<Item> ItemList = new ArrayList<Item>();
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM item";

			if (!Keyword.equals("") || !SaleDateS.equals("") || !SaleDateE.equals("") || !HId.isEmpty()
					|| !GId.isEmpty()) {
				sql += " WHERE";
			}

			if (!Keyword.equals("")) {
				sql += " name" + " LIKE " + "'" + "%" + Keyword + "%" + "'";
			}

			if (!SaleDateS.equals("")) {
				if (!Keyword.equals("")) {
					sql += " AND ";
				}
				sql += " sale_date" + ">=" + "'" + SaleDateS + "'";
			}

			if (!SaleDateE.equals("")) {
				if (!Keyword.equals("") || !SaleDateS.equals("")) {
					sql += " AND ";
				}
				sql += " sale_date" + "<=" + "'" + SaleDateE + "'";
			}
			if (!HId.isEmpty()) {
				if (!Keyword.equals("") || !SaleDateS.equals("") || !SaleDateE.equals("")) {
					sql += " AND ";
				}
				for (int i = 0; HId.size() > i; i++) {
					switch (i) {
					case 0:
						break;
					default:
						sql += " OR ";
					}
					sql += " hard_id" + "=" + "'" + HId.get(i) + "'";
				}
			}
			if (!GId.isEmpty()) {
				if (!Keyword.equals("") || !SaleDateS.equals("") || !SaleDateE.equals("") || !HId.isEmpty()) {
					sql += " AND ";
				}
				for (int n = 0; GId.size() > n; n++) {
					switch (n) {
					case 0:
						break;
					default:
						sql += " OR ";
					}
					sql += " genre_id" + " = " + "'" + GId.get(n) + "'";
				}
			}
			sql += " ORDER BY " + "'" + Sort + "'";

			System.out.println(sql);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int Id = rs.getInt("id");
				String Name = rs.getString("name");
				String Detail = rs.getString("detail");
				int Price = rs.getInt("price");
				int Stock = rs.getInt("stock");
				Date SaleDate = rs.getDate("sale_date");
				String FileName = rs.getString("file_name");
				Item item = new Item(Id, Name, Detail, Price, Stock, SaleDate, FileName);

				ItemList.add(item);
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
		return ItemList;
	}

}
