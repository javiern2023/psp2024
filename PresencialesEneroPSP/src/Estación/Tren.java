package Estación;

class Tren extends Thread {
    private final int id;
    private final EstacionDeTrenes estacion;

    public Tren(int id, EstacionDeTrenes estacion) {
        this.id = id;
        this.estacion = estacion;
    }

    public long getId() {
        return id;
    }

    @Override
    public void run() {
        try {
            // El tren intenta entrar en la estación
            estacion.entrarEstacion(this);
            // Simula la operación de carga y descarga
            System.out.println("Tren " + id + " está cargando y descargando pasajeros...");
            Thread.sleep((int) (Math.random() * 5000) + 1000);
            // El tren sale de la estación
            estacion.salirEstacion(this);
        } catch (InterruptedException e) {
            System.out.println("Tren " + id + " ha sido interrumpido.");
        }
    }
}
