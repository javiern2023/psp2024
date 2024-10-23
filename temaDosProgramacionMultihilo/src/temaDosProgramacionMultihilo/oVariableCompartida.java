package temaDosProgramacionMultihilo;

public class oVariableCompartida extends Thread{
	private static int contador;
	public void run() {
		for(int i=0;i<1000;i++) {
			contador++;
		}
	}
	public static void main(String[] args) {
		for(int i=0;i<1000;i++) {
			new oVariableCompartida().start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Valor de contador: "+contador);
	}

}
