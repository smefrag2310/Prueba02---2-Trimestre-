package plantilla.app;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import plantilla.dominio.Comercial;
import plantilla.dominio.Empleado;
import plantilla.dominio.Plantilla;
import plantilla.dominio.Tecnico;

public class GestorEmpleados {

	private Plantilla plantilla;
	private EntradaSalida consola;

	public GestorEmpleados(Plantilla plantilla, EntradaSalida consola) {
		this.plantilla = plantilla;
		this.consola = consola;
	}

	public void ejecutar() {
		int opcion;

		do {
			consola.mostrarMenu();
			opcion = consola.leerEntero("Introduce la opción");

			if (opcion == 1) {
				contratarEmpleado();
			} else if (opcion == 2) {
				listarTodos();
			} else if (opcion == 3) {
				listarPorFiltro();
			} else if (opcion == 4) {
				consola.limpiarPantalla();
			}
		} while (opcion != 4);

		System.out.println("¡Hasta la próxima!");
	}


	public void contratarEmpleado() {
		String nombre, apellidos, dni;
		double sueldoBase, ventas;
		int opcion, categoria;
		Empleado nuevoEmpleado = null;
		
		do {
		opcion = consola.leerEntero("""
				¿A quién vas a contratar?
				1 - Técnico
				2 - Comercial
				""");
		}while(opcion != 1 || opcion != 2);

		consola.imprimirLinea("Introduce los datos del empleado");
		nombre = consola.leerTexto("Nombre: ");
		apellidos = consola.leerTexto("Apellidos: ");
		dni = consola.leerTexto("DNI: ");
		sueldoBase = consola.leerImporte("Sueldo base");

		if (opcion == 1) {
			categoria = consola.leerEntero("Categoría: ");
			nuevoEmpleado = new Tecnico(dni, nombre, apellidos, sueldoBase, categoria);
		} else if (opcion == 2) {
			ventas = consola.leerImporte("Ventas: ");
			nuevoEmpleado = new Comercial(dni, nombre, apellidos, sueldoBase);
			((Comercial) nuevoEmpleado).setVentas(ventas);
		}
		plantilla.agregarEmpleado(nuevoEmpleado);
	}

	public void listarTodos() {
		
	}

	public void listarPorFiltro() {
		List<Empleado> coincidencias;
		coincidencias=plantilla.getEmpleadoPorNombre(consola.leerTexto("Introduce al empleado que quieres buscar: "));
		
		listarEmpleados(coincidencias);
	}

	public void listarEmpleados(List<Empleado> empleados) {
		
	}

	public void ordenarPorNombre(List<Empleado> empleados) {
		Collections.sort(empleados, Comparator.comparing(Empleado::getNombre));
	}
}
