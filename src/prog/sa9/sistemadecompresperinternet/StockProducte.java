package prog.sa9.sistemadecompresperinternet;

import java.util.Random;

public class StockProducte {
    Random random = new Random();
    
    private int numeroDeProductesDisponibles;
    private Producte producteRelacionat;
    
    public StockProducte(int numeroDeProductesDisponibles, Producte producteRelacionat) {
        assert producteRelacionat != null : "El producte no pot ser null";
        assert numeroDeProductesDisponibles >= 0 : "Les unitats no poden ser negatives";
        this.numeroDeProductesDisponibles = random.nextInt(10)+1;
        this.producteRelacionat = producteRelacionat;
    }
    
    public void restarNumeroUnitats(int numero) {
        assert numero > 0 && numero <= numeroDeProductesDisponibles : "Quantitat no valida";
        numeroDeProductesDisponibles -= numero;
    }
    
    public int getNumeroDeProductesDisponibles() {
        return numeroDeProductesDisponibles;
    }
    
    public Producte getProducteRelacionat() {
        return producteRelacionat;
    }
 
}
