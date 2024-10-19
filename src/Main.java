public class Main {
    public static void main(String[] args) {
        final int NUM_FILOSOFI = 5;
        final Filosofo[] FILOSOFI = new Filosofo[NUM_FILOSOFI];
        final Forchetta[] FORCHETTE = new Forchetta[NUM_FILOSOFI];

        // Inizializziamo le forchette
        for (int i = 0; i < NUM_FILOSOFI; i++) {
            FORCHETTE[i] = new Forchetta(i);
        }

        // Creiamo e avviamo i filosofi
        for (int i = 0; i < NUM_FILOSOFI; i++) {
            final Forchetta SINISTRA = FORCHETTE[i];
            final Forchetta DESTRA = FORCHETTE[(i + 1) % NUM_FILOSOFI];

            // Evitare il deadlock: per l'ultimo filosofo invertiamo l'ordine delle forchette
            
            if (i == NUM_FILOSOFI - 1) {
                FILOSOFI[i] = new Filosofo(i, DESTRA, SINISTRA);
            } else {
                FILOSOFI[i] = new Filosofo(i, SINISTRA, DESTRA);
            }
            

            new Thread(FILOSOFI[i]).start();
        }
    }
}
 