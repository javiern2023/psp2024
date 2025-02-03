package temaDosProgramacionMultihilo;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

//Solución colas concurrentes con Queues. Componente que crea un entorno seguro.
public class hColaConcurrente implements Runnable{
	//private static Queue<Integer> cola = new LinkedList<Integer>();
	private static Queue<Integer> cola = new ConcurrentLinkedDeque <Integer>();
	
	@Override
	public void run() {
		cola.add(10);
		for (Integer i : cola) {
			System.out.print(i+":");
			System.out.println("Tamaño cola:"+cola.size());
		}
		
	}

	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			new Thread(new hColaConcurrente()).start();
		}

	}

	
}
