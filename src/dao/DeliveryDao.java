package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;
import beans.DeliveryMethodDataBeans;

public class DeliveryDao {
	public static DeliveryMethodDataBeans DeliveryMethod(int Id){
		Connection con = null;
		PreparedStatement st = null;
		DeliveryMethodDataBeans dmdb = new DeliveryMethodDataBeans();
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM delivery_method WHERE id = ?");
			st.setInt(1, Id);

			ResultSet rs = st.executeQuery();


			if (rs.next()) {
				dmdb.setId(rs.getInt("id"));
				dmdb.setName(rs.getString("name"));
				dmdb.setPrice(rs.getInt("price"));
			}

			System.out.println("searching DeliveryMethodDataBeans by DeliveryMethodID has been completed");
		} catch (

				SQLException e) {
					e.printStackTrace();
					return null;
				} finally {
					if (con != null) {
						try {
							con.close();
						} catch (SQLException e) {
							e.printStackTrace();
							return null;
						}
					}
				}
		return dmdb;
	}
}