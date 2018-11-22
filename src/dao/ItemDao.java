package dao;

import java.sql.Connection;
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
			String SaleDateE, int hardId, int genreId, String Sort) {
		Connection conn = null;
		List<Item> ItemList = new ArrayList<Item>();
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM item ";

			if(!Keyword.equals("") && !SaleDateS.equals("") && !SaleDateE.equals("") && hardId != 0) {
				sql += "WHERE";
			}

			if (!Keyword.equals("")) {
				sql += " AND name" + " LIKE " + "'" + "%" + Keyword + "%" + "'";
			}

			if (!SaleDateS.equals("")) {
				sql += " AND sale_date" + ">=" + "'" + SaleDateS + "'";

			}

			if (!SaleDateE.equals("")) {
				sql += " AND sale_date" + "<=" + "'" + SaleDateE + "'";
			}

			if (hardId != 0) {
				sql += "AND hard_id"+"=" + hardId;
			}

			if (genreId != 0) {
				sql += "AND genre_id"+"=" + genreId;
			}

			if (!Sort.equals("")) {
				sql += "ORDER BY" + "'" + Sort + "'";

			}

			System.out.println(sql);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int Id = rs.getInt("id");
				String Name = rs.getString("name");
				String Detail = rs.getString("detail");
				int Price = rs.getInt("price");
				int Stock = rs.getInt("stock");
				String SaleDate = rs.getString("sale_date");
				String FileName = rs.getString("file_name");
				int HardId = rs.getInt("hard_id");
				int GenreId = rs.getInt("genre_id");
				Item item = new Item(Id,Name,Detail,Price,Stock,SaleDate,FileName,HardId,GenreId);

				ItemList.add(item);
			}
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
		return ItemList;
	}

}
