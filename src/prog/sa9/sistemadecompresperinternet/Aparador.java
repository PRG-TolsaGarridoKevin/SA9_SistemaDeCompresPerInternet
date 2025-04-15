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
    

    
    
    //aparador = nombre (string), marca(enum), stock(lista stockProducte)
    //max 20 productos diferentes
    //ObtindreProductesALaVenta = muestra los productos del stock disponibles con unidades
    //VerSiUnProductoYaExiste = equals de productos para ver si son iguales
    //BuscarUnProducto = consultar si queda 1 o mas unidades de 1 producto
    //VerProductosEnVentaOrdenadosAlfabeticamente = obligado usar interfaz Comparable en clase producte
    //ObtenerUnidadesDisponibles = obtener las unidades disponibles de un producto
    //SaberSiElAparadorEstaObert = boolean para ver si esta abierto o no
    //ComprarProducte = nombre y cantidad del producto que se va a comprar (necesario que el aparador esta abierto)
    //y que la cantidad del stock que se desea comprar este disponible, si se tramita la compra se actualiza el stock
    //Excepcion = NotExistEnouhtItemException = No hay suficiente stock del producto
}
