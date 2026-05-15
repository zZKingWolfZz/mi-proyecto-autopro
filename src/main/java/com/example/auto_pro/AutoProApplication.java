package com.example.auto_pro;

import com.example.auto_pro.model.Producto;
import com.example.auto_pro.services.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootApplication
public class AutoProApplication implements CommandLineRunner {

	@Autowired
	private IProductoServicio servicio;

	public static void main(String[] args) {
		org.springframework.boot.builder.SpringApplicationBuilder builder = new org.springframework.boot.builder.SpringApplicationBuilder(
				AutoProApplication.class);
		builder.headless(false).run(args);
	}

	@Override
	public void run(String... args) {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		while (op != 6) {
			System.out.println("\n\t╔══════════════════════════════════════════╗");
			System.out.println("\t║          SISTEMA GESTIÓN AUTO-PRO        ║");
			System.out.println("\t╠══════════════════════════════════════════╣");
			System.out.println("\t║  [1]  Insertar nuevo producto            ║");
			System.out.println("\t║  [2]  Listar inventario completo         ║");
			System.out.println("\t║  [3]  Actualizar datos de producto       ║");
			System.out.println("\t║  [4]  Eliminar producto                  ║");
			System.out.println("\t║  [5]  Buscar con filtros avanzados       ║");
			System.out.println("\t║  [6]  Salir del sistema                  ║");
			System.out.println("\t║  [7]  Abrir Web (Localhost)              ║");
			System.out.println("\t╚══════════════════════════════════════════╝");
			System.out.print("\t> Seleccione una opción: ");
			try {
				op = Integer.parseInt(sc.nextLine());
				switch (op) {
					case 1 -> {
						System.out.print("Nombre: ");
						String n = sc.nextLine();
						System.out.print("Detalles: ");
						String d = sc.nextLine();
						System.out.print("Precio: ");
						BigDecimal p = new BigDecimal(sc.nextLine());
						System.out.print("Stock: ");
						Integer s = Integer.parseInt(sc.nextLine());
						servicio.guardarProducto(new Producto(null, n, d, null, s, false, p, null));
						System.out.println("¡Guardado!");
					}
					case 2 -> servicio.listarProductos().forEach(System.out::println);
					case 3 -> {
						servicio.listarProductos().forEach(System.out::println);
						System.out.print("ID a editar: ");
						Integer id = Integer.parseInt(sc.nextLine());
						Producto pro = servicio.buscarPorId(id);
						if (pro != null) {
							System.out.print("Nuevo Nombre: ");
							pro.setNombre(sc.nextLine());
							System.out.print("Nuevos Detalles: ");
							pro.setDescripcion(sc.nextLine());
							System.out.print("Nuevo Precio: ");
							pro.setPrecio(new BigDecimal(sc.nextLine()));
							System.out.print("Nuevo Stock: ");
							pro.setStock(Integer.parseInt(sc.nextLine()));
							servicio.guardarProducto(pro);
							System.out.println("¡Actualizado!");
						} else
							System.out.println("No existe.");
					}
					case 4 -> {
						servicio.listarProductos().forEach(System.out::println);
						System.out.print("ID a eliminar: ");
						Integer id = Integer.parseInt(sc.nextLine());
						servicio.eliminarProducto(id);
						System.out.println("Eliminado.");
					}
					case 5 -> {
						System.out.println("1. Nombre | 2. Precio > | 3. Stock |");
						int b = Integer.parseInt(sc.nextLine());
						if (b == 1) {
							System.out.print("Texto: ");
							servicio.buscarPorNombre(sc.nextLine()).forEach(System.out::println);
						} else if (b == 2) {
							System.out.print("Precio min: ");
							servicio.buscarPorPrecioMayorQue(new BigDecimal(sc.nextLine()))
									.forEach(System.out::println);
						} else if (b == 3) {
							System.out.print("Stock max: ");
							servicio.buscarPorStockMenorQue(Integer.parseInt(sc.nextLine()))
									.forEach(System.out::println);
						}
					}
					case 7 -> {
						System.out.println("\n Abriendo navegador...");
						try {
							java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://localhost:9000"));
						} catch (Exception e) {
							System.out.println("No se pudo abrir el navegador automáticamente.");
							System.out.println("Por favor, abre:" + "http://localhost:9000 en tu navegador.");
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Error en datos.");
			}
		}
	}
}