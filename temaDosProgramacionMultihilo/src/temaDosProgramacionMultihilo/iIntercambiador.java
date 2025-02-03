package temaDosProgramacionMultihilo;

import java.util.concurrent.Exchanger;

public class iIntercambiador {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();
		new Thread(new iTareaA(exchanger)).start();
		new Thread(new iTareaB(exchanger)).start();
	}

}
