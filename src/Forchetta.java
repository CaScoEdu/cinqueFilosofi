public class Forchetta {
    private final int ID;
    private boolean inUso;

    public Forchetta(final int ID) {
        this.ID = ID;
        this.inUso = false;
    }

    public synchronized void prendi() throws InterruptedException {
        while (inUso) {
            wait(); // Aspetta finché la forchetta non è disponibile
        }
        inUso = true;
    }

    public synchronized void rilascia() {
        inUso = false;
        notifyAll(); // Notifica che la forchetta è disponibile
    }

    public int getID() {
        return ID;
    }
}
