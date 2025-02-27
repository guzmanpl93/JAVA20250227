package fp.dam.java.streams;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
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
		m3(products.stream());

	}
	
//	1.Crea un método estático llamado m1 que muestre en la consola los productos ordenados por 
//	el precio de venta recomendado de mayor a menor.
	
	private static Map<Float,String> m1(Stream<Product> stream) {
		return stream
				.sorted((s1,s2) -> (s2.getMsrp() - s1.getMsrp()))
				.collect(Collectors.toMap(value -> value.getMsrp(), name -> name.getName));
//		return (Map<Float, String>) stream
//				.sorted((s1,s2) -> s2.getMsrp() - s1.getMsrp())
//				.mapToDouble(ej -> ej.getMsrp());
		
	}
	
//	2.Crea un método estático llamado m2 que agrupe por proveedor los productos cuyo precio de 
//	venta recomendado (msrp) no supere los 100€ y retorne el resultado.
	private static Map<String, String> m2(Stream<Product> stream) {
		return stream
				.filter(sel -> sel.getMsrp()> 100)
				.collect(Collectors.groupingBy(e -> e ,t -> t.getVendor()));
	}
	
//	3.Crea un método estático llamado m3 que retorne el precio médio de venta de los productos 
//	de cada línea de producto.
	private static Double m3(Stream<Product> stream) {
		return stream
				.collect(Collectors.groupingBy(Product::getProductLine).averagingDouble(t -> t.getBuyPrice()));
	}
//	4.Crea un método estático llamado m4 que retorne el precio del producto más caro para cada 
//	una de las líneas de producto.
	private static void m4(Stream<Product> stream) {
		return stream
				.collect(Collectors.groupingBy().averagingDouble(t -> t.getBuyPrice()));
	}
//	5.Crea un método estático llamado m5 que retorne una lista que contenga los nombres de todos 
//	los productos almacenados en el mapa que retorna el método m2.
	private static void m5(Map<In> stream) {
		
	}
//	6.Crea un método estático llamado m6 que retorne el mínimo, el máximo, la suma y la media de
//	todos los precios de compra (buyPrice).
	private static void m6(Stream<Product> stream) {
//		return stream
//				.min((e1, e2) -> e2.getBuyPrice()-e1.getBuyPrice());
		return stream.collect(
				Collectors.minBy((e1, e2) -> e2.getBuyPrice() - e1.getBuyPrice()));
	}
//	7.Crea un método estático llamado m7 que retorne una cadena que contenga una lista de los 
//	nombres de todos los productos separados por una coma y un espacio, cuya línea de producto sea Planes.
	private static void m7(Stream<Product> stream) {
		
	}
	
//	8.Crea un método estático llamado m8 que retorne el importe total que han generado las ventas
//	de productos de cada proveedor.
	private static Map<String, List<Product>> m8(Stream<Product> stream) {
		return stream.collect(Collectors.groupingBy(t -> t.getVendor(), Product::getMsrp));
	}
}
