package com.supermarket.demo.Super.Market.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="item_id")
	private Long itemId;
	@Column(name="item_name")
	private String itemName;
	@Column(name="item_price")
	private Double itemPrice;
	
	@Column(name="supplier_id")
	private int supplierId;
	@Column(name="item_category")
	private String itemCategory;
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="item_quantity")
	private int itemQuantity;
	
	
	
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(Long itemId, String itemName, Double itemPrice, int supplierId, String itemCategory, String imageUrl, int itemQuantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.supplierId = supplierId;
		this.itemCategory = itemCategory;
		this.imageUrl = imageUrl;
		this.itemQuantity = itemQuantity;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", supplierId="
				+ supplierId + ", itemCategory=" + itemCategory + ", imageUrl=" + imageUrl + ", itemQuantity="
				+ itemQuantity + "]";
	}
	
	
	
	
	
	
	
}
