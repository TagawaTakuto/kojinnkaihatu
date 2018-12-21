package model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class Item {
	private int id;
	private String name;
	private String detail;
	private int price;
	private int stock;
	private Date saleDate;
	private String fileName;
	private int hardId;
	private String hardName;
	private List<String> genreName;
	private String updatedate;
	private int buycount;

	//アイテムリスト//
	public Item(int id, String name, String detail, int price, int stock, Date saleDate, String fileName,
			String updateDate, String hardName, List<String> genreName) {
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.saleDate = saleDate;
		this.fileName = fileName;
		this.updatedate = updateDate;
		this.hardName = hardName;
		this.genreName = genreName;

	}

	public Item(int id, String name, String detail, int price, int stock, Date saleDate, String fileName,
			String updateDate, int hardId, String hardName) {
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.saleDate = saleDate;
		this.fileName = fileName;
		this.updatedate = updateDate;
		this.hardId = hardId;
		this.hardName = hardName;
	}

	public Item(int id, String name, int price, String fileName, String hardName, int buycount) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.fileName = fileName;
		this.hardName = hardName;
		this.buycount = buycount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSale_date(Date sale_date) {
		this.saleDate = sale_date;
	}

	public String getHardName() {
		return hardName;
	}

	public void setHardName(String hardName) {
		this.hardName = hardName;
	}

	public List<String> getGenreName() {
		return genreName;
	}

	public void setGenreName(List<String> genreName) {
		this.genreName = genreName;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public int getHardId() {
		return hardId;
	}

	public void setHardId(int hardId) {
		this.hardId = hardId;
	}

	public String getSaleFormatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(saleDate);
	}

	public int getBuycount() {
		return buycount;
	}

	public void setBuycount(int buycount) {
		this.buycount = buycount;
	}
}
