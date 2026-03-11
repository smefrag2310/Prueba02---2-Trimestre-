package plantilla.app;

import plantilla.dominio.Plantilla;

public class Main {
	
	public void show() {
		Consola consola= new Consola();
		Plantilla plantilla = new Plantilla();
		GestorEmpleados gestor= new GestorEmpleados(plantilla, consola);
		
		gestor.ejecutar();
	}
	public static void main(String[] args) {
		new Main().show();

	}

}
