package fp.dam.java.streams.classicmodels;

import java.util.Objects;

public class OrderDetail implements Comparable<OrderDetail>{
	private int orderNumber;
	private String productCode;
	private int quantityOrdered;
	private float priceEach;
	private int orderLineNumber;
	
	public OrderDetail(String csvLine) {
		String [] tokens = csvLine.split("\\|");
		orderNumber = Integer.parseInt(tokens[0]);
		productCode = tokens[1];
		quantityOrdered = Integer.parseInt(tokens[2]);
		priceEach = Float.parseFloat(tokens[3]);
		orderLineNumber = Integer.parseInt(tokens[4]);	
	}	
	
	public int getOrderNumber() {
		return orderNumber;
	}

	public String getProductCode() {
		return productCode;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public float getPriceEach() {
		return priceEach;
	}

	public int getOrderLineNumber() {
		return orderLineNumber;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(orderLineNumber, orderNumber, priceEach, productCode, quantityOrdered);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetail other = (OrderDetail) obj;
		return orderLineNumber == other.orderLineNumber && orderNumber == other.orderNumber
				&& Float.floatToIntBits(priceEach) == Float.floatToIntBits(other.priceEach)
				&& Objects.equals(productCode, other.productCode) && quantityOrdered == other.quantityOrdered;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderNumber=" + orderNumber + ", productCode=" + productCode + ", quantityOrdered="
				+ quantityOrdered + ", priceEach=" + priceEach + ", orderLineNumber=" + orderLineNumber + "]";
	}

	@Override
	public int compareTo(OrderDetail o) {
		int r = orderNumber - o.orderNumber;
		return r == 0 ? orderLineNumber - o.orderLineNumber : r;
	}
	
}