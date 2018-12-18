package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import model.Item;

public class ItemDao {

	//TOPアイテム全件//
	public List<Item> ItemAll() {
		Connection conn = null;
		List<Item> ItemList = new ArrayList<Item>();
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM item INNER JOIN hard ON item.hard_id = hard.id";
			System.out.println(sql);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				List<String> GenreName = new ArrayList<String>();
				int Id = rs.getInt("item.id");
				String Name = rs.getString("item.name");
				String Detail = rs.getString("detail");
				int Price = rs.getInt("price");
				int Stock = rs.getInt("stock");
				Date SaleDate = rs.getDate("sale_date");
				String FileName = rs.getString("file_name");
				int HardId = rs.getInt("hard_id");
				String HardName = rs.getString("hard.name");
				String UpdateDate = rs.getString("update_date");
				GenreDao genredao = new GenreDao();
				GenreName.addAll(genredao.Genre(rs.getInt("item.id")));
				Item item = new Item(Id, Name, Detail, Price, Stock, SaleDate, FileName, UpdateDate,HardId,HardName,GenreName);

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

	//ジャンル追加用引数検索//
		public int Id() {
			Connection con = null;
			int Id = 0;

			String sql = "SELECT * FROM item ORDER BY create_date DESC";
			System.out.println(sql);

			Statement stmt;
			try {
				con = DBManager.getConnection();
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					Id = rs.getInt("id");
				}
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			return Id;
		}

	//商品検索//
	public List<Item> ItemSearch(String Keyword, String SaleDateS,
			String SaleDateE, ArrayList<Integer> HId, ArrayList<Integer> GId, String Sort) {
		Connection conn = null;
		List<Item> ItemList = new ArrayList<Item>();
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM item INNER JOIN hard on item.hard_id = hard.id JOIN genre_detail ON item.id = genre_detail.item_id";

			if (!Keyword.equals("") || !SaleDateS.equals("") || !SaleDateE.equals("") || !HId.isEmpty()
					|| !GId.isEmpty()) {
				sql += " WHERE";
			}

			if (!Keyword.equals("")) {
				sql += " item.name" + " LIKE " + "'" + "%" + Keyword + "%" + "'";
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
			sql += " ORDER BY "  + Sort ;

			System.out.println(sql);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				List<String> GenreName = new ArrayList<String>();
				int Id = rs.getInt("item.id");
				String Name = rs.getString("item.name");
				String Detail = rs.getString("detail");
				int Price = rs.getInt("price");
				int Stock = rs.getInt("stock");
				Date SaleDate = rs.getDate("sale_date");
				String FileName = rs.getString("file_name");
				int HardId = rs.getInt("hard.id");
				String HardName = rs.getString("hard.name");
				GenreDao genredao = new GenreDao();
				GenreName.addAll(genredao.Genre(rs.getInt("item.id")));
				String UpdateDate = rs.getString("update_date");
				Item item = new Item(Id, Name, Detail, Price, Stock, SaleDate, FileName,UpdateDate,HardId,HardName,GenreName);

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

	//商品追加//
	public void Create(String title, String detail, int price, int stock, String saledate, String filename, int hard)
			throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO item (name,detail,price,stock,sale_date,file_name,hard_id,create_date,update_date) VALUES(?,?,?,?,?,?,?, now(),now());");
			st.setString(1, title);
			st.setString(2, detail);
			st.setInt(3, price);
			st.setInt(4, stock);
			st.setString(5, saledate);
			st.setString(6, filename);
			st.setInt(7, hard);
			st.executeUpdate();

			System.out.println(st);
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}

		}
	}



	//商品削除//
	public void ItemDelete(int id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "DELETE FROM item WHERE id =?";
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

	//商品情報更新//
	public void ItemUpdate(int id, String name, String fileName, String detail, String saleDate, int price, int stock,
			int hard) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "UPDATE item SET update_date = now() ";

			if (!name.equals("")) {
				sql += " ,name" + " = " + "'" + name + "'";
			}

			if (!detail.equals("")) {
				sql += " ,detail" + "=" + "'" + detail + "'";
			}

			if (price != 0) {
				sql += " ,price" + "=" + "'" + price + "'";
			}
			if (stock != 0) {
				sql += " ,stock" + "=" + "'" + stock + "'";
			}
			if (!saleDate.equals("")) {
				sql += " ,sale_date" + "=" + "'" + saleDate + "'";
			}

			if (!fileName.equals("")) {
				sql += " ,file_name" + "=" + "'" + fileName + "'";
			}

			if (hard != 0) {
				sql += " ,hard_id" + "=" + "'" + hard + "'";
			}

			sql += "WHERE id" + "=" + id;

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

	//商品情報参照//
	public static Item Data(int id) {
		Connection conn = null;
		Item item = null;
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM item INNER JOIN hard ON item.hard_id = hard.id WHERE item.id = " + id ;
			System.out.println(sql);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				int Id = rs.getInt("item.id");
				String Name = rs.getString("item.name");
				String Detail = rs.getString("detail");
				int Price = rs.getInt("price");
				int Stock = rs.getInt("stock");
				Date SaleDate = rs.getDate("sale_date");
				String FileName = rs.getString("file_name");
				String UpdateDate = rs.getString("update_date");
				int HardId = rs.getInt("hard_id");
				String HardName = rs.getString("hard.name");
				item = new Item(Id, Name, Detail, Price, Stock, SaleDate, FileName, UpdateDate,HardId,HardName);
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
		return item;
	}

	//合計金額//
	public static int getTotalPrice(ArrayList<Item> ItemList) {
		int total = 0;
		for(Item item:ItemList) {
			total += item.getPrice();
		}
		return total;
	}

	//在庫減少//
	public static void StockDown(int id, int buycount) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "UPDATE item SET stock = stock - "+ buycount + " WHERE id = " + id;

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
}
