package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.BuyDetailDataBeans;
import model.Item;

public class BuyDetailDao {
	public static void insertBuyDetail(BuyDetailDataBeans bdb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO buy_detail(buy_id,item_id,buy_count) VALUES(?,?,?)");
			st.setInt(1, bdb.getBuyId());
			st.setInt(2, bdb.getItemId());
			st.setInt(3, bdb.getBuyCount());
			st.executeUpdate();
			System.out.println("inserting BuyDetail has been completed");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static ArrayList<Item> getItemDataBeansListByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT item.id,"
							+ " item.name,"
							+ " item.price"
							+ "item.file_name"
							+ " FROM buy_detail"
							+ " JOIN item"
							+ " ON buy_detail.item_id = item.id"
							+ " JOIN hard"
							+ " ON item.hard_id = hard.id"
							+ " WHERE buy_detail.buy_id = ?");
			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();
			ArrayList<Item> buyDetailItemList = new ArrayList<Item>();

			while (rs.next()) {
				int Id = rs.getInt("id");
				String Name = rs.getString("name");
				int Price = rs.getInt("price");
				String FileName = rs.getString("file_name");
				String HardName = rs.getString("item.hard_name");
				int BuyCount = rs.getInt("buy_count");
				Item idb = new Item(Id, Name, Price, FileName, HardName, BuyCount);
				buyDetailItemList.add(idb);
			}

			System.out.println("searching ItemDataBeansList by BuyID has been completed");
			return buyDetailItemList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

}
