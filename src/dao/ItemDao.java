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
			String SaleDateE, int hardId1, int hardId2, int hardId3, int hardId4, int genreId1,int genreId2,int genreId3,int genreId4,int genreId5, String Sort) {
		Connection conn = null;
		List<Item> ItemList = new ArrayList<Item>();
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM item ";

			if(hardId1 != 0 || hardId2 != 0 || hardId3 != 0 || hardId4 != 0) {
				sql += "JOIN hard ON item.hard_id = hard.id";
			}

			if(!Keyword.equals("") && !SaleDateS.equals("") && !SaleDateE.equals("")) {
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

			if (!Sort.equals("")) {
				sql += " ORDER BY" + "'" + Sort + "'";

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
				Date SaleDate = rs.getDate("sale_date");
				String FileName = rs.getString("file_name");
				String Hard = rs.getString("hard.name");
				String Genre = rs.getString("genre.name");
				Item item = new Item(Id,Name,Detail,Price,Stock,SaleDate,FileName,Hard,Genre);

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
