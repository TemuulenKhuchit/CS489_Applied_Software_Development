package edu.miu.cs.cs489appsd.lab1.productmgmtapp.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Product model for Product Management App
 */
public class Product {
	private BigInteger productId;
	private String name;
	private LocalDate dateSupplied;
	private int quantityInStock;
	private BigDecimal unitPrice;

	// Default constructor
	public Product() {
		this.productId = null;
		this.name = "";
		this.dateSupplied = null;
		this.quantityInStock = 0;
		this.unitPrice = BigDecimal.ZERO;
	}

	// All-args constructor
	public Product(BigInteger productId, String name, LocalDate dateSupplied, int quantityInStock, BigDecimal unitPrice) {
		this.productId = productId;
		this.name = name;
		this.dateSupplied = dateSupplied;
		this.quantityInStock = quantityInStock;
		this.unitPrice = unitPrice;
	}

	// Convenience constructor accepting strings for productId, date and price
	public Product(String productIdStr, String name, String dateSuppliedStr, int quantityInStock, String unitPriceStr) {
		this.productId = productIdStr == null || productIdStr.isEmpty() ? null : new BigInteger(productIdStr);
		this.name = name;
		this.dateSupplied = (dateSuppliedStr == null || dateSuppliedStr.isEmpty()) ? null : LocalDate.parse(dateSuppliedStr);
		this.quantityInStock = quantityInStock;
		this.unitPrice = (unitPriceStr == null || unitPriceStr.isEmpty()) ? BigDecimal.ZERO : new BigDecimal(unitPriceStr);
	}

	// Getters and setters
	public BigInteger getProductId() {
		return productId;
	}

	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateSupplied() {
		return dateSupplied;
	}

	public void setDateSupplied(LocalDate dateSupplied) {
		this.dateSupplied = dateSupplied;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", name='" + name + '\'' +
				", dateSupplied=" + dateSupplied +
				", quantityInStock=" + quantityInStock +
				", unitPrice=" + unitPrice +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return quantityInStock == product.quantityInStock &&
				Objects.equals(productId, product.productId) &&
				Objects.equals(name, product.name) &&
				Objects.equals(dateSupplied, product.dateSupplied) &&
				Objects.equals(unitPrice, product.unitPrice);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, name, dateSupplied, quantityInStock, unitPrice);
	}
}

