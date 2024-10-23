package temaDosProgramacionMultihilo;

public class oComparticionRunnable implements Runnable{
	private int contador;
	@Override
	public void run() {
		contador++;
		System.out.println("Valor del contador: "+contador);
	}
	
	public static void main(String[] args) throws InterruptedException {
		oComparticionRunnable cr = new oComparticionRunnable();
		new Thread(cr).start();
		Thread.sleep(100);
		new Thread(cr).start();
	}

	

}
