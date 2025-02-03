package Estación;

public class Principal {
	// Método principal para ejecutar el programa
    public static void main(String[] args) {
        // Crear una estación con 2 andenes
        EstacionDeTrenes estacion = new EstacionDeTrenes(2);

        // Crear y arrancar varios trenes
        for (int i = 1; i <= 5; i++) {
            Tren tren = new Tren(i, estacion);
            tren.start();
        }
    }
}
