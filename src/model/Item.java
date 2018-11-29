package model;

import java.sql.Date;

public class Item {
	private int id;
	private String name;
	private String detail;
	private int price;
	private int stock;
	private Date saleDate;
	private String fileName;
	private String hardName;
	private String genreName;

	//アイテムリスト//
	public Item(int id, String name, String detail, int price, int stock, Date saleDate, String fileName) {
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.saleDate = saleDate;
		this.fileName = fileName;
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

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
}
