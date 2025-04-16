package prog.sa9.sistemadecompresperinternet;

import java.util.ArrayList;

public abstract class Aparador {
    private static final int LIMITE = 20;
    
    private boolean aparadorActiu;
    private String nom;
    private TipusMarca marca;
    private ArrayList<StockProducte> stock = new ArrayList<>();

    public Aparador(String nom, TipusMarca marca) {
        this.nom = nom;
        this.marca = marca;
        this.aparadorActiu = true;
    }

    public void obrirAparador() {
        this.aparadorActiu = true;
    }

    public void tancarAparador() {
        this.aparadorActiu = false;
    }
    
    //Cambiar nombres de metodos a unos mas legibles y simplificados
    
    public void ObtindreProductesALaVenta(){
        for (StockProducte Producte : stock) {
            System.out.println(Producte);
        }
    };
    
    public boolean VerSiUnProductoYaExiste(Producte producte){
        for (StockProducte Producte : stock) {
            if (Producte.getProducteRelacionat().equals(producte)) {
                return true;
            }
        }
        return false;
    };
    
    public boolean ComprobarStockDeProducte(Producte producte){
        for (StockProducte Producte : stock) {
            if (Producte.getProducteRelacionat().equals(producte) && Producte.getNumeroDeProductesDisponibles() > 0) {
                return true;
            }
        }
        return false;
    };
    
    
    public static void VerProductosEnVentaOrdenadosAlfabeticamente(){
        //obligado usar interfaz Comparable en clase producte
    };
    
    public int ObtenerUnidadesDisponibles(Producte producte){
        for (StockProducte Producte : stock) {
            if (Producte.getProducteRelacionat().equals(producte)) {
                return Producte.getNumeroDeProductesDisponibles();
            }
        }
    return 0;
    };
    
    public static boolean SaberSiElAparadorEstaObert(Aparador aparador){
        return aparador.aparadorActiu;
    };
    
    public boolean ComprarProducte(String idProducte, int quantitat) {
    if (!this.aparadorActiu) {
        System.out.println("L'aparador esta tancat, no es poden fer compres");
        return false;
    }

    for (StockProducte Producte : stock) {
        Producte producteComprat = Producte.getProducteRelacionat();
        
        if (producteComprat.getId().equals(idProducte)) {
            if (Producte.getNumeroDeProductesDisponibles() >= quantitat) {
                Producte.restarNumeroUnitats(quantitat);
                System.out.println("Compra realitzada: " + quantitat + " unitats del producte " + idProducte);
                return true;
            } else {
                System.out.println("No hi ha prou unitats disponibles del producte selleccionat");
                return false;
            }
        }
    }

    System.out.println("Producte no trobat en el aparador");
    return false;
}
    
    //max 20 productos diferentes
    //Excepcion = NotExistEnouhtItemException = No hay suficiente stock del producto
}
