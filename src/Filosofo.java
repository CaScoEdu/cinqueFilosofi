public class Filosofo implements Runnable {
    private final int ID;
    private final Forchetta SINISTRA;
    private final Forchetta DESTRA;

    public Filosofo(final int ID, final Forchetta SINISTRA, final Forchetta DESTRA) {
        this.ID = ID;
        this.SINISTRA = SINISTRA;
        this.DESTRA = DESTRA;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensa();
                mangia();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void pensa() throws InterruptedException {
        System.out.println("Filosofo " + ID + " sta pensando...");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void mangia() throws InterruptedException {
        // Filosofi prendono prima la forchetta di sinistra, poi la destra

        SINISTRA.prendi();
        /*
         * questo ritardo è ininfluente perchè
         * il deadlock è evitato perchè si è evitata un'attesa circolare
         */
        System.out.println("Filosofo " + ID + " ha preso la forchetta sinistra " + SINISTRA.getID());
        Thread.sleep((long) (Math.random() * 1000));

        DESTRA.prendi();
        System.out.println("Filosofo " + ID + " ha preso la forchetta destra " + DESTRA.getID());

        System.out.println("Filosofo " + ID + " sta mangiando...");
        Thread.sleep((long) (Math.random() * 1000));

        // Rilasciare le forchette dopo aver mangiato
        DESTRA.rilascia();
        System.out.println("Filosofo " + ID + " ha rilasciato la forchetta destra " + DESTRA.getID());

        SINISTRA.rilascia();
        System.out.println("Filosofo " + ID + " ha rilasciato la forchetta sinistra " + SINISTRA.getID());

    }
}
