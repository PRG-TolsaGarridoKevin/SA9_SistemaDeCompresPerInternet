package prog.sa9.sistemadecompresperinternet;

import java.util.ArrayList;

public abstract class Aparador {
    private static final int LIMITE = 20;
    
    private String nom;
    private TipusMarca marca;
    private ArrayList<StockProducte> stock = new ArrayList<>();

    public Aparador(String nom, TipusMarca marca) {
        this.nom = nom;
        this.marca = marca;
    }
    
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
    
    public static boolean BuscarUnProducto(){
    return false;
        //consultar si queda 1 o mas unidades de 1 producto
    };
    
    
    public static void VerProductosEnVentaOrdenadosAlfabeticamente(){
        //obligado usar interfaz Comparable en clase producte
    };
    
    public static int ObtenerUnidadesDisponibles(){
    return -1;
        //obtener las unidades disponibles de un producto
    };
    
    public static boolean SaberSiElAparadorEstaObert(){
        return false;
        //boolean para ver si esta abierto o no
    };
    
    public static void ComprarProducte(){
         //nombre y cantidad del producto que se va a comprar (necesario que el aparador esta abierto)
          //y que la cantidad del stock que se desea comprar este disponible, si se tramita la compra se actualiza el stock
    };
    
    //max 20 productos diferentes
    //Excepcion = NotExistEnouhtItemException = No hay suficiente stock del producto
}
