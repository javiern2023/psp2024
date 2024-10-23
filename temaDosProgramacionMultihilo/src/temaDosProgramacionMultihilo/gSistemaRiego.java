package temaDosProgramacionMultihilo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Interface executor. Permite ejecutar tareas de Runnable.
public class gSistemaRiego implements Runnable{

	@Override
	public void run() {
		System.out.println("Regando...");
		
	}
	
	public static void main(String[] args) {
		gSistemaRiego sr = new gSistemaRiego();
		//Interface que permite programar tareas concurrentes en hilos independientes
		ScheduledExecutorService stp = (ScheduledExecutorService) Executors.newSingleThreadExecutor();
		/*Se le indica qué tarea se quiere realizar, cuantas unidades de tiempo
		 *tiene que esperar hasta su inicio, cuando tiempo debe esperar hasta su
		 *repetición y en qué unidades de tiempo están configuradas. */
		stp.scheduleAtFixedRate(sr, 1, 2, TimeUnit.SECONDS);
		System.out.println("Sistema de riego configurado.");
	}

	

}
