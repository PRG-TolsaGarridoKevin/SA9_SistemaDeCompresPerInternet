package prog.sa9.sistemadecompresperinternet;

import java.util.Random;

public class StockProducte {
    private static final int MAX_RANDOM_UNITS = 10;
    Random random = new Random();
    
    private int numeroDeProductesDisponibles;
    private Producte producteRelacionat;
    
    public StockProducte(int numeroDeProductesDisponibles, Producte producteRelacionat) {
        assert producteRelacionat != null : "El producte no pot ser null";
        assert numeroDeProductesDisponibles >= 0 : "Les unitats no poden ser negatives";
        assert this.numeroDeProductesDisponibles > 0 && this.numeroDeProductesDisponibles <= MAX_RANDOM_UNITS : "Numero aleatori de productes fora del rang esperat (1-10)";
        
        this.numeroDeProductesDisponibles = random.nextInt(MAX_RANDOM_UNITS) + 1;
        this.producteRelacionat = producteRelacionat;
    }
    
    public void restarNumeroUnitats(int numero) {
        assert numero > 0 : "El numero a restar ha de ser positiu";
        assert numero <= numeroDeProductesDisponibles : "No es poden restar mes unitats de les disponibles";

        numeroDeProductesDisponibles -= numero;

        assert numeroDeProductesDisponibles >= 0 : "El nombre de productes no pot ser negatiu despres de restar";
    }
    
    public int getNumeroDeProductesDisponibles() {
        assert numeroDeProductesDisponibles >= 0 : "El numero de productes disponibles no pot ser negatiu";
        return numeroDeProductesDisponibles;
    }
    
    public Producte getProducteRelacionat() {
        assert producteRelacionat != null : "El producte relacionat no pot ser null";
        return producteRelacionat;
    }
 
}
