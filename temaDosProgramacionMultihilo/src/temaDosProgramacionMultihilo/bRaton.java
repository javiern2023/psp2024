package temaDosProgramacionMultihilo;

public class bRaton extends Thread{
	protected String nombre;
	protected int tiempoAlimentacion;
	
	public bRaton(String nombre, int tiempo){
		this.nombre=nombre;
		this.tiempoAlimentacion=tiempo;
	}
	
	public void run(){
		try{
			System.out.printf("El raton %s ha comenzado a alimentarse%n", nombre);
			Thread.sleep(tiempoAlimentacion * 1000);//pausa la ejecuci�n del hilo. Milisegundos.
			System.out.printf("El raton %s ha terminado de alimentarse%n",nombre);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		bRaton fievel = new bRaton("Fievel", 4);
		bRaton jerry = new bRaton("Jerry", 5);
		bRaton pinky = new bRaton("Pinky", 3);
		bRaton mickey = new bRaton("Mickey", 6);
		fievel.start();
		jerry.start();
		pinky.start();
		mickey.start();
		//Cada rat�n comienza a comer de inmediato.
	}
}
