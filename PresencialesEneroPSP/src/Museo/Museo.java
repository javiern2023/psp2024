package Museo;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Museo {

    // Semáforo para el límite de visitantes en el museo
    private final Semaphore limiteMuseo;
    // Semáforos para las tres salas
    private final Semaphore[] limiteSalas;
    // Lista para gestionar los hilos de visitantes
    private final ArrayList<Thread> visitantes;

    // Constructor
    public Museo(int limiteMuseo, int[] limitesSalas) {
        this.limiteMuseo = new Semaphore(limiteMuseo);
        this.limiteSalas = new Semaphore[3];
        this.visitantes = new ArrayList<>();

        // Inicializamos los semáforos de las salas con sus respectivos límites
        for (int i = 0; i < 3; i++) {
            this.limiteSalas[i] = new Semaphore(limitesSalas[i]);
        }
    }

    // Clase interna para representar a un visitante
    class Visitante extends Thread {
        private final int id;
        private final Random random;

        public Visitante(int id) {
            this.id = id;
            this.random = new Random();
        }

        @Override
        public void run() {
            try {
                // Intentar entrar al museo
                System.out.println("Visitante " + id + " quiere entrar al museo.");
                limiteMuseo.acquire(); // Adquirir un permiso para entrar al museo
                System.out.println("Visitante " + id + " ha entrado al museo.");

                // Elegir una sala aleatoriamente
                int sala = random.nextInt(3);
                System.out.println("Visitante " + id + " quiere entrar a la sala " + (sala + 1) + ".");
                limiteSalas[sala].acquire(); // Adquirir un permiso para entrar a la sala
                System.out.println("Visitante " + id + " ha entrado a la sala " + (sala + 1) + ".");

                // Simular el tiempo en la sala
                Thread.sleep(random.nextInt(3000) + 1000);

                // Salir de la sala
                System.out.println("Visitante " + id + " ha salido de la sala " + (sala + 1) + ".");
                limiteSalas[sala].release(); // Liberar el permiso de la sala

                // Salir del museo
                System.out.println("Visitante " + id + " ha salido del museo.");
                limiteMuseo.release(); // Liberar el permiso del museo
            } catch (InterruptedException e) {
                System.out.println("Visitante " + id + " fue interrumpido.");
            }
        }
    }

    // Método para ejecutar la simulación
    public void iniciarSimulacion(int numVisitantes) {
        // Crear y agregar visitantes a la lista
        for (int i = 1; i <= numVisitantes; i++) {
            Visitante visitante = new Visitante(i);
            visitantes.add(visitante);
            visitante.start(); // Iniciar el hilo
        }

        // Esperar a que todos los visitantes terminen
        for (Thread visitante : visitantes) {
            try {
                visitante.join(); // Esperar a que el hilo termine
            } catch (InterruptedException e) {
                System.out.println("Error al esperar la finalización de un visitante.");
            }
        }

        System.out.println("Todos los visitantes han salido. El museo está cerrado.");
    }

    public static void main(String[] args) {
        // Límite de personas en el museo
        int limiteMuseo = 5;
        // Límites aleatorios entre 1 y 4 para las tres salas
        int[] limitesSalas = {
            new Random().nextInt(4) + 1,
            new Random().nextInt(4) + 1,
            new Random().nextInt(4) + 1
        };

        // Imprimir los límites de las salas
        System.out.println("Límite de personas en cada sala:");
        for (int i = 0; i < limitesSalas.length; i++) {
            System.out.println("Sala " + (i + 1) + ": " + limitesSalas[i] + " personas.");
        }

        // Crear el museo y ejecutar la simulación
        Museo museo = new Museo(limiteMuseo, limitesSalas);
        museo.iniciarSimulacion(10); // Simular con 10 visitantes
    }
}

