package fp.dam.java.streams.classicmodels;

import java.util.Objects;

public class ProductLine implements Comparable<ProductLine> {

	private String productLine;
	private String textDescription;
	
	public ProductLine(String csvLine) {
		String [] tokens = csvLine.split("\\|");
		productLine = tokens[0];
		textDescription = tokens[1];
	}

	public String getProductLine() {
		return productLine;
	}

	public String getTextDescription() {
		return textDescription;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(productLine, textDescription);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductLine other = (ProductLine) obj;
		return Objects.equals(productLine, other.productLine) && Objects.equals(textDescription, other.textDescription);
	}

	@Override
	public String toString() {
		return String.format("%s, %s", productLine , textDescription);
	}

	@Override
	public int compareTo(ProductLine o) {
		return productLine.compareTo(o.productLine);
	}

}
