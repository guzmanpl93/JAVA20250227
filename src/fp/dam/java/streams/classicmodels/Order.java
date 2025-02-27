package fp.dam.java.streams.classicmodels;

import java.time.LocalDate;
import java.util.Objects;

public class Order implements Comparable<Order> {

	private int orderNumber;
	private LocalDate orderDate;
	private LocalDate requiredDate;
	private LocalDate shippedDate;
	private String status;
	private String comments;
	private int customerNumber;
	
	public Order(String csvLine) {
		String [] tokens = csvLine.split("\\|");
		orderNumber = Integer.parseInt(tokens[0]);
		orderDate = LocalDate.parse(tokens[1]);
		requiredDate = tokens[2].length() == 0 ? null: LocalDate.parse(tokens[2]);
		shippedDate = tokens[3].length() == 0 ? null: LocalDate.parse(tokens[3]);
		status = tokens[4];
		comments = tokens[5];
		customerNumber = Integer.parseInt(tokens[6]);
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public LocalDate getRequiredDate() {
		return requiredDate;
	}

	public LocalDate getShippedDate() {
		return shippedDate;
	}
	
	public String getStatus() {
		return status;
	}

	public String getComments() {
		return comments;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(comments, customerNumber, orderDate, orderNumber, requiredDate, shippedDate, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(comments, other.comments) && customerNumber == other.customerNumber
				&& Objects.equals(orderDate, other.orderDate) && orderNumber == other.orderNumber
				&& Objects.equals(requiredDate, other.requiredDate) && Objects.equals(shippedDate, other.shippedDate)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return String.format("%d, %s, %s, %s, %s, %s, %d" , orderNumber,
				orderDate == null ? "unknown" : orderDate.toString(),
				requiredDate == null ? "unknown" : requiredDate.toString(),
				shippedDate == null ? "unknown" : shippedDate.toString(),
				status, comments, customerNumber);
	}

	@Override
	public int compareTo(Order o) {
		int r = orderDate.compareTo(o.orderDate);
		if (r == 0) {
			r = orderNumber - o.orderNumber;
			if (r == 0) {
				r = customerNumber - o.customerNumber;
				if (r == 0) {
					r = (requiredDate == null ? (o.requiredDate == null ? 0 : -1) : (o.requiredDate == null ? 1 : requiredDate.compareTo(o.requiredDate)));
					if (r == 0) {
						r = (shippedDate == null ? (o.requiredDate == null ? 0 : -1) : (o.requiredDate == null ? 1 : requiredDate.compareTo(o.requiredDate)));
					}
				}
			}
		}
		return r;
	}
	
}
