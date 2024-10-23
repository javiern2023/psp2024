package temaDosProgramacionMultihilo;
//Estructuras de la interface Collection (List, Map, Set, Qeue o Deque)
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class jLectorEscritorSeguro extends Thread{
	private static List<String> palabras = new CopyOnWriteArrayList<String>();
	
	public void run() {
		palabras.add(new String("Nueva palabra"));
		for(String palabra : palabras) {
			palabras.size();
		}
		System.out.println(palabras.size());
	}
	
	public static void main(String[] args) {
		for(int i=0; i<100; i++) {
			new jLectorEscritorSeguro().start();
		}

	}

}
