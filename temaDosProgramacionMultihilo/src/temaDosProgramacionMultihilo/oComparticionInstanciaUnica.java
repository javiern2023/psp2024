package temaDosProgramacionMultihilo;

public class oComparticionInstanciaUnica extends Thread{
	//Creo el objeto comun
	private ObjetoComun oc;
	public oComparticionInstanciaUnica(ObjetoComun oc) {
		this.oc = oc;
	}
	public void run() {
		this.oc.variableComun++;
		System.out.println("Variable comun: "+this.oc.variableComun);
	}
	public static void main(String[] args) throws InterruptedException {
		ObjetoComun oc = new ObjetoComun();
		oComparticionInstanciaUnica ciu1 = new oComparticionInstanciaUnica(oc);
		oComparticionInstanciaUnica ciu2 = new oComparticionInstanciaUnica(oc);
		ciu1.start();
		Thread.sleep(100);
		ciu2.start();

	}

}
