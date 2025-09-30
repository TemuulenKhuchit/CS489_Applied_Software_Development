package edu.miu.cs.cs489appsd.lab1.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1.productmgmtapp.model.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.math.RoundingMode;

/**
 * CLI application entry point for Product Management App
 */
public class ProductMgmtApp {

	public static void main(String[] args) {
		Product[] products = new Product[] {
				new Product("31288741190182539912", "Banana", "2025-01-24", 124, "0.55"),
				new Product("29274582650152771644", "Apple", "2024-12-09", 18, "1.09"),
				new Product("91899274600128155167", "Carrot", "2025-03-31", 89, "2.99"),
				new Product("31288741190182539913", "Banana", "2025-02-13", 240, "0.65")
		};

		printProducts(products);
	}

	/**
	 * Prints products sorted by name (asc) and unitPrice (desc) in JSON, XML and CSV formats.
	 */
	public static void printProducts(Product[] products) {
		if (products == null) return;

		// Make a copy and sort
		Product[] copy = Arrays.copyOf(products, products.length);
		Arrays.sort(copy, Comparator
				.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER)
				.thenComparing(Product::getUnitPrice, Comparator.reverseOrder())
		);

		// JSON
		System.out.println("----- JSON -----");
		System.out.println(toJson(copy));

		// XML
		System.out.println("\n----- XML -----");
		System.out.println(toXml(copy));

		// CSV
		System.out.println("\n----- CSV -----");
		System.out.println(toCsv(copy));
	}

	private static String formatPrice(BigDecimal price) {
		if (price == null) return "0.00";
		return price.setScale(2, RoundingMode.HALF_UP).toString();
	}

	private static String toJson(Product[] products) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < products.length; i++) {
			Product p = products[i];
			sb.append("{\n");
			sb.append("  \"productId\": ").append(p.getProductId() == null ? "null" : p.getProductId().toString()).append(",\n");
			sb.append("  \"name\": \"").append(escapeJson(p.getName())).append("\",\n");
			sb.append("  \"dateSupplied\": \"").append(p.getDateSupplied() == null ? "" : p.getDateSupplied().toString()).append("\",\n");
			sb.append("  \"quantityInStock\": ").append(p.getQuantityInStock()).append(",\n");
			sb.append("  \"unitPrice\": ").append(formatPrice(p.getUnitPrice())).append("\n");
			sb.append("}");
			if (i < products.length - 1) sb.append(",");
			sb.append("\n");
		}
		sb.append("]");
		return sb.toString();
	}

	private static String escapeJson(String s) {
		if (s == null) return "";
		return s.replace("\\", "\\\\").replace("\"", "\\\"");
	}

	private static String toXml(Product[] products) {
		StringBuilder sb = new StringBuilder();
		sb.append("<products>\n");
		for (Product p : products) {
			sb.append("  <product>\n");
			sb.append("    <productId>").append(p.getProductId() == null ? "" : p.getProductId().toString()).append("</productId>\n");
			sb.append("    <name>").append(escapeXml(p.getName())).append("</name>\n");
			sb.append("    <dateSupplied>").append(p.getDateSupplied() == null ? "" : p.getDateSupplied().toString()).append("</dateSupplied>\n");
			sb.append("    <quantityInStock>").append(p.getQuantityInStock()).append("</quantityInStock>\n");
			sb.append("    <unitPrice>").append(formatPrice(p.getUnitPrice())).append("</unitPrice>\n");
			sb.append("  </product>\n");
		}
		sb.append("</products>");
		return sb.toString();
	}

	private static String escapeXml(String s) {
		if (s == null) return "";
		return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&apos;");
	}

	private static String toCsv(Product[] products) {
		StringBuilder sb = new StringBuilder();
		sb.append("productId,name,dateSupplied,quantityInStock,unitPrice\n");
		for (Product p : products) {
			sb.append(p.getProductId() == null ? "" : p.getProductId().toString()).append(",");
			sb.append(quoteCsv(p.getName())).append(",");
			sb.append(p.getDateSupplied() == null ? "" : p.getDateSupplied().toString()).append(",");
			sb.append(p.getQuantityInStock()).append(",");
			sb.append(formatPrice(p.getUnitPrice())).append("\n");
		}
		return sb.toString();
	}

	private static String quoteCsv(String s) {
		if (s == null) return "";
		if (s.contains(",") || s.contains("\n") || s.contains("\"")) {
			return "\"" + s.replace("\"", "\"\"") + "\"";
		}
		return s;
	}
}

