package temaDosProgramacionMultihilo;
//Clase que utiliza el ejercicio de los estados de un hilo.
public class Raton extends Thread{
	private String nombre;
	private int tiempoAlimentacion;
	
	public Raton (String nombre, int tiempoAlimentacion) {
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}
	public void run() {
		
	}
}
