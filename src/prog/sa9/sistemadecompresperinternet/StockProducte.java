package prog.sa9.sistemadecompresperinternet;

import java.util.Random;

public class StockProducte {
    Random random = new Random();
    
    private int numeroDeProductesDisponibles;
    private Producte producteRelacionat;
    
    public StockProducte(int numeroDeProductesDisponibles, Producte producteRelacionat) {
        this.numeroDeProductesDisponibles = random.nextInt(10)+1;
        this.producteRelacionat = producteRelacionat;
    }
    
    
/*
stockProducte = numero de productes disponibles (random), producte relacionat

random entre 1 y 10 de cantidad de productos en stockProducte
si se compra un producto su stock baja

Excepcion, CanNotMergeBrandsException = cuando un producto no encaja con la marca del aparador
*/

   
}
