package temaDosProgramacionMultihilo;

public class nInterrupcionBasico extends Thread{
	public void run() {
		int contador=0;
		while(true) {
			contador++;
			System.out.println(contador);
			if(contador==3) {
				this.interrupt();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Interrupcion");
				return;
			}
		}
	}
	public static void main(String[] args) {
		new nInterrupcionBasico().start();

	}

}
