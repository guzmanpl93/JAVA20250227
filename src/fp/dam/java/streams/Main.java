package fp.dam.java.streams;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.dam.java.streams.classicmodels.Order;
import fp.dam.java.streams.classicmodels.OrderDetail;
import fp.dam.java.streams.classicmodels.Product;
import fp.dam.java.streams.classicmodels.ProductLine;

public class Main {
	
	static final Set<Product> products;
	static final Set<ProductLine> productLines;
	static final Set<Order> orders;
	static final Set<OrderDetail> orderDetails;
	static {
		try (Stream<String> rows = Files.lines(Path.of(ClassLoader.getSystemResource("products.csv").toURI()))) {
			products = rows.map(Product::new).collect(Collectors.toSet());
		} catch (IOException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
		
		try (Stream<String> rows = Files.lines(Path.of(ClassLoader.getSystemResource("productlines.csv").toURI()))) {
			productLines = rows.map(ProductLine::new).collect(Collectors.toSet());
		} catch (IOException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
		
		try (Stream<String> rows = Files.lines(Path.of(ClassLoader.getSystemResource("orders.csv").toURI()))) {
			orders = rows.map(Order::new).collect(Collectors.toSet());
		} catch (IOException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
		
		try (Stream<String> rows = Files.lines(Path.of(ClassLoader.getSystemResource("orderdetails.csv").toURI()))) {
			orderDetails = rows.map(OrderDetail::new).collect(Collectors.toSet());
		} catch (IOException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * EJERCICIOS
	 */
	
	
	public static void main(String[] args) {
		
	}
}
