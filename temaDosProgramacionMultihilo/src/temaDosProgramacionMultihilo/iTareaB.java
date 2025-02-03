package temaDosProgramacionMultihilo;

import java.util.concurrent.Exchanger;

public class iTareaB implements Runnable{
private Exchanger<String> exchanger;
	
	public iTareaB(Exchanger<String> exchanger) {
		super();
		this.exchanger=exchanger;
	}
	@Override
	public void run() {
		try {
			String mensajeRecibido = exchanger.exchange("Mensaje enviado por TareaB");
			System.out.println("Mensaje recibido en TareaB: "+mensajeRecibido);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
