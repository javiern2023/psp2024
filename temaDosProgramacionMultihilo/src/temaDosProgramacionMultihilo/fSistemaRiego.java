package temaDosProgramacionMultihilo;

import java.util.Timer;
import java.util.TimerTask;
//Programa que simula controlar un sistema de regadío automático.
public class fSistemaRiego extends TimerTask{

	@Override
	public void run() {
		System.out.println("Regando...");
		
	}
	
	public static void main(String[] args) {
		Timer temporizador = new Timer();
		/*Riega por primera vez transcurridos 1000 milisegundos desde el inicio
		de la ejecución y repite el riego cada 2000 milisegundos*/
		temporizador.schedule(new fSistemaRiego(), 1000, 2000);
	}

	

}
