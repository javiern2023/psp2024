package temaDosProgramacionMultihilo;

public class lRunnableBasico implements Runnable{
	private int id;
	public lRunnableBasico(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		while(true) {
			System.out.println("Procesando hilo "+id);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		for (int i=0;i<10;i++) {
			new Thread(new lRunnableBasico(i)).start();
		}

	}

	

}
