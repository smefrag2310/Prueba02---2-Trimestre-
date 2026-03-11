package plantilla.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola implements EntradaSalida{

	private Scanner sc;
	
	public Consola() {
		sc= new Scanner(System.in);
	}
	
	public void imprimir(String texto) {
		System.out.print(texto);
	}
	
	public void imprimirLinea(String texto) {
		System.out.println(texto);
	}
	
	public String leerTexto(String mensaje) {
		String texto;
		
		imprimirLinea(mensaje);
		texto= sc.nextLine();
		
		return texto.trim();
	}
	
	public int leerEntero(String mensaje) {
		int entero;
		boolean valido;
		imprimirLinea(mensaje);
		entero=0;
		do {
			valido=true;
			try {
			entero=sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Introduce un entero por favor");
				valido=false;
			}
		}while(!valido);
		
		return entero;
	}
	
	public double leerImporte(String mensaje) {
		double importe;
		boolean valido;
		imprimirLinea(mensaje);
		importe=0;
		do {
			valido=true;
			try {
			importe=sc.nextDouble();
			}catch(InputMismatchException e) {
				System.out.println("Introduce un numero decimal por favor");
				valido=false;
			}
		}while(!valido);
		
		return importe;
	}
	
	public void mostrarMenu() {
		imprimirLinea("""
				===== Menu =====
				1 - Contratar empleado
				2 - Listar todos los empleados
				3 - Listar empleados con filtro
				4 - Salir""");
	}
	
	public void limpiarPantalla() {
		for(int i=0; i<10; i++) {
			System.out.println();
		}
	}
	
	public void pausa() {
		imprimirLinea("Pulse una tecla para continuar...");
		
	}
}
