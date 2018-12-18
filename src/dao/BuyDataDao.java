package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.BuyDataBeans;

public class BuyDataDao {
	//購入情報登録//
	public static int Buy(BuyDataBeans bdb) {
		Connection con = null;
		PreparedStatement st = null;
		int autoIncKey = -1;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO buy(user_id,total_price,delivery_method_id,hard_id,create_date) VALUES(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, bdb.getUserId());
			st.setInt(2, bdb.getTotalPrice());
			st.setInt(3, bdb.getDeliveryMethodId());
			st.setInt(4, bdb.getHardId());
			st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				autoIncKey = rs.getInt(1);
			}
			System.out.println("inserting buy-datas has been completed");

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return autoIncKey;
	}

	//購入完了画面//
	public static BuyDataBeans BuyData(int Id) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM buy"
							+ " JOIN delivery_method"
							+ " ON buy.delivery_method_id = delivery_method.id"
							+ " WHERE buy.id = ?");
			st.setInt(1, Id);

			System.out.println(st);

			ResultSet rs = st.executeQuery();

			BuyDataBeans bdb = new BuyDataBeans();
			if(rs.next()) {
				bdb.setTotalPrice(rs.getInt("total_price"));
				bdb.setBuyDate(rs.getTimestamp("create_date"));
				bdb.setDeliveryMethodId(rs.getInt("delivery_method_id"));
				bdb.setUserId(rs.getInt("user_id"));
				bdb.setDeliveryMethodPrice(rs.getInt("price"));
				bdb.setDeliveryMethodName(rs.getString("name"));
			}

			System.out.println("searching BuyDataBeans by buyID has been completed");

			return bdb;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	//ユーザページ時の購入履歴一覧//
	public static List<BuyDataBeans> BuyHis(int Id) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		List<BuyDataBeans> bdblist = new ArrayList<BuyDataBeans>();
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM buy"
							+ " JOIN delivery_method"
							+ " ON buy.delivery_method_id = delivery_method.id"
							+ " WHERE buy.user_id = ?");
			st.setInt(1, Id);

			System.out.println(st);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				BuyDataBeans bdb = new BuyDataBeans();
				bdb.setId(rs.getInt("id"));
				bdb.setTotalPrice(rs.getInt("total_price"));
				bdb.setBuyDate(rs.getTimestamp("create_date"));
				bdb.setDeliveryMethodId(rs.getInt("delivery_method_id"));
				bdb.setUserId(rs.getInt("user_id"));
				bdb.setDeliveryMethodPrice(rs.getInt("price"));
				bdb.setDeliveryMethodName(rs.getString("name"));

				bdblist.add(bdb);
			}

			System.out.println("searching BuyDataBeans by buyID has been completed");

			return bdblist;
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
