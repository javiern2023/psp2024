package temaDosProgramacionMultihilo;

import java.util.concurrent.Exchanger;

public class iTareaA implements Runnable{
	private Exchanger<String> exchanger;
	
	public iTareaA(Exchanger<String> exchanger) {
		super();
		this.exchanger=exchanger;
	}
	@Override
	public void run() {
		try {
			String mensajeRecibido = exchanger.exchange("Mensaje enviado por TareaA");
			System.out.println("Mensaje recibido en TareaA: "+mensajeRecibido);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
