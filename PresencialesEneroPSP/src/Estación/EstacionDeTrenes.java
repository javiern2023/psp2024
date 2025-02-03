package Estación;

import java.util.ArrayList;

public class EstacionDeTrenes {

    // Número máximo de andenes disponibles
    private final int maxAndenes;
    // Lista para gestionar los trenes en espera
    private final ArrayList<Tren> trenesEnEspera;
    // Número de andenes actualmente ocupados
    private int andenesOcupados = 0;

    // Constructor de la estación
    public EstacionDeTrenes(int maxAndenes) {
        this.maxAndenes = maxAndenes;
        this.trenesEnEspera = new ArrayList<>();
    }

	// Método sincronizado para que un tren entre en la estación
    public synchronized void entrarEstacion(Tren tren) throws InterruptedException {
        System.out.println("Tren " + tren.getId() + " quiere entrar en la estación.");
        // Si no hay andenes disponibles, el tren espera
        while (andenesOcupados >= maxAndenes) {
            System.out.println("Tren " + tren.getId() + " está esperando un andén libre.");
            trenesEnEspera.add(tren);
            wait();
        }
        // El tren ocupa un andén
        andenesOcupados++;
        trenesEnEspera.remove(tren);
        System.out.println("Tren " + tren.getId() + " ha entrado en la estación. Andenes ocupados: " + andenesOcupados);
    }

    // Método sincronizado para que un tren salga de la estación
    public synchronized void salirEstacion(Tren tren) {
        System.out.println("Tren " + tren.getId() + " ha terminado su operación y está saliendo de la estación.");
        // Libera un andén
        andenesOcupados--;
        System.out.println("Andenes ocupados: " + andenesOcupados);
        // Notifica a los trenes en espera que un andén está disponible
        notifyAll();
    }

    

    
}

