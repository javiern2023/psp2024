package temaDosProgramacionMultihilo;
/*Lanzamos una tarea que se ejecuta de manera asíncrona y dejamos en espera el
 * tratamiento de la respuesta*/
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class kLector implements Callable<String>{

	@Override
	public String call() throws Exception {
		String textoLeido = "Me gustan las peliculas de accion";
		Thread.sleep(1000);
		return textoLeido;
	}
	
	public static void main(String[] args) {
		try {
			kLector lector = new kLector();
			ExecutorService servicioEjecucion = Executors.newSingleThreadExecutor();
			Future<String> resultado = servicioEjecucion.submit(lector);
			String texto = resultado.get();
			if(resultado.isDone()) {
				System.out.println(texto);
				System.out.println("Proceso finalizado");
			} else if (resultado.isCancelled()) {
				System.out.println("Proceso cancelado");
			}
			servicioEjecucion.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	

}
