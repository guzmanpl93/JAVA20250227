# Ejercicio Práctico - Unidad 6

Haz un fork de este repositorio desde tu cuenta de GitHub, clónalo desde Eclipse e importa el proyecto de Java que contiene.

Para realizar este ejercicio se permite:  
- Consultar la documentación publicada en Aulas Virtuales para del Módulo de Programación.
- Consultar los ejercicios resueltos en clase.
- Consultar la documentación del API de Java.  

No está permitido:  
- Consultar cualquier otra documentación.
- Consultar ejercicios resueltos.
- Consultar código fuente publicado en Internet o en cualquier otro soporte, independientemente del lenguaje de programación usado.
- Utilizar inteligencia artificial durante la realización de la práctica.  

**Especificaciones para la realización de este ejercicio práctico:**  

* En el paquete `fp.dam.java.streams.classicmodels` se han definido las clases siguientes:<br/><br/>
    * `Product`: representa modelos de vehículos a escala.
    * `ProductLine`: reprenta las diferentes líneas de producto (coches, motos, ...)
    * `Order`: representa pedidos de uno o varios modelos.
    * `OrderDetails`: representa líneas de detalle de pedidos.<br/><br/>
    
* En la clase Maindel paquete `fp.dam.java.streasms` se han creado cuatro conjuntos referenciados por las siguientes variables miembro estáticas:<br/><br/>
    * `products`<br/>referencia a un conjunto que contiene objetos `Producto`.<br/><br/>
    * `productLines`<br/>referencia a un conjunto que contiene objetos `ProductLine`.<br/><br/>
    * `orders`<br/>referencia a un conjunto que contiene objetos `Order`.<br/><br/>
    * `orderDetails`<br/>referencia a un conjunto que contiene objetos `OrderDetail`.<br/><br/>

**Usando stream pipelines, define los métodos siguientes: (1,25 puntos cada uno)**

1. Crea un método estático llamado `m1` que muestre en la consola los productos ordenados por el precio de venta recomendado de mayor a menor.</br></br>

1. Crea un método estático llamado `m2` que agrupe por proveedor los productos cuyo precio de venta recomendado (`msrp`) no supere los 100€ y retorne el resultado.</br></br>

1. Crea un método estático llamado `m3` que retorne el precio médio de venta de los productos de cada línea de producto.</br></br>

1. Crea un método estático llamado `m4` que retorne el precio del producto más caro para cada una de las líneas de producto.</br></br>

1. Crea un método estático llamado `m5` que retorne una lista que contenga los nombres de todos los productos almacenados en el mapa que retorna el método `m2`.</br></br>

1. Crea un método estático llamado `m6` que retorne el mínimo, el máximo, la suma y la media de todos los precios de compra (`buyPrice`).</br></br>

1. Crea un método estático llamado `m7` que retorne una cadena que contenga una lista de los nombres de todos los productos separados por una coma y un espacio, cuya línea de producto sea `Planes`.</br></br>

1. Crea un método estático llamado `m8` que retorne el importe total que han generado las ventas de productos de cada proveedor.</br></br>

**Puedes usar el método `main` para probar cada uno de los métodos.**
