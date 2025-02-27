package fp.dam.java.streams.classicmodels;

import java.util.Objects;

public class Product implements Comparable<Product> {
	private String code;			// Código
	private String name;			// Nombre
	private String productLine;		// Tipo de producto
	private String scale;			// Escala
	private String vendor;			// Proveedor
	private String description;		// Descripción
	private int stock;				// Unidades en stock
	private float buyPrice;			// Precio de compra
	private float msrp;				// Precio recomendado de venta (Manufacturer Suggested Retail Price)

	public Product(String csvLine) {
		String [] tokens = csvLine.split("\\|");
		code = tokens[0];
		name = tokens[1];
		productLine = tokens[2];
		scale = tokens[3];
		vendor = tokens[4];
		description = tokens[5];
		stock = Integer.parseInt(tokens[6]);
		buyPrice = Float.parseFloat(tokens[7]);
		msrp = Float.parseFloat(tokens[8]);	
	}	
	
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getProductLine() {
		return productLine;
	}

	public String getScale() {
		return scale;
	}

	public String getVendor() {
		return vendor;
	}

	public String getDescription() {
		return description;
	}

	public int getStock() {
		return stock;
	}

	public float getBuyPrice() {
		return buyPrice;
	}

	public float getMsrp() {
		return msrp;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(buyPrice, code, description, msrp, name, productLine, scale, stock, vendor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Float.floatToIntBits(buyPrice) == Float.floatToIntBits(other.buyPrice)
				&& Objects.equals(code, other.code) && Objects.equals(description, other.description)
				&& Float.floatToIntBits(msrp) == Float.floatToIntBits(other.msrp) && Objects.equals(name, other.name)
				&& Objects.equals(productLine, other.productLine) && Objects.equals(scale, other.scale)
				&& stock == other.stock && Objects.equals(vendor, other.vendor);
	}

	@Override
	public String toString() {
		return code + ", " + name + ", " + productLine + ", " + scale + ", " + msrp;
	}

	@Override
	public int compareTo(Product o) {
		return code.compareTo(o.code);
	}
	
}