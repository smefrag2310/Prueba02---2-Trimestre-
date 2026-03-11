package plantilla.app;

import plantilla.dominio.Plantilla;

public class GestorEmpleados {

	
	private Plantilla plantilla;
	private EntradaSalida consola;
	
	public GestorEmpleados(Plantilla plantilla, EntradaSalida consola) {
		this.plantilla= plantilla;
		this.consola= consola;
	}
}
