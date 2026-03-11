package plantilla.dominio;

import java.util.ArrayList;
import java.util.List;

public class Plantilla {

	private List<Empleado> empleados;
	
	public Plantilla() {
		empleados= new ArrayList<>();
	}
	
	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public List<Empleado> getEmpleadoPorNombre(String filtroNombre){
		List<Empleado> listaBusqueda= new ArrayList<>();
		
		if(filtroNombre.isBlank() || filtroNombre == "") {
			return empleados;
		}else if(empleados.isEmpty()) {
			return empleados;
		}else {
		for(int i=0; i< empleados.size(); i++) {
			if(empleados.get(i).getNombre().equalsIgnoreCase(filtroNombre) || empleados.get(i).getApellidos().equalsIgnoreCase(filtroNombre)) {
				listaBusqueda.add(empleados.get(i));
			}
		}
		return listaBusqueda;
	}
	}
}
