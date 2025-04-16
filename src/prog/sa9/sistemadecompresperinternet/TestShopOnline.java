package prog.sa9.sistemadecompresperinternet;
public class TestShopOnline {
    public static void main(String[] args) throws CanNotMergeBrandsException, NotExistEnoughItemException, ShowRoomNotOpenException {
        System.out.println("----Crear y añadir productos al AparadorTemporal----\n");
        Producte polRatlles = new Producte("Pol ratlles", 50, TipusMarca.LACOSTERA);
        Producte vestitBlau = new Producte("vestit de bany blau", 40, TipusMarca.LACOSTERA);

        StockProducte stockPolRatlles = new StockProducte(polRatlles);
        StockProducte stockVestitBlau = new StockProducte(vestitBlau);

        polRatlles.setStockProducte(stockPolRatlles);
        vestitBlau.setStockProducte(stockVestitBlau);

        AparadorTemporal aparadorTemp1 = new AparadorTemporal("Estiu LaCostera 2025", TipusMarca.LACOSTERA, 5);

        aparadorTemp1.afegirProducte(stockPolRatlles);
        aparadorTemp1.afegirProducte(stockVestitBlau);
        
        System.out.println("\n----Mostrar productos ordenados alfabeticamente----\n");
        aparadorTemp1.verProductosEnVentaOrdenadosAlfabeticamente();
        
        System.out.println("\n----Consultar y mostrar unidades de cada producto----\n");
        System.out.print("Pol ratlles: " + aparadorTemp1.comprobarStockDeProducte(polRatlles) +
                         ", Vestit de bany blau: "+ aparadorTemp1.comprobarStockDeProducte(vestitBlau)+"\n");
        
        System.out.println("\n----Consulta y mostra el temps que li queda al aparador per a tancar----\n");
        System.out.println("Dias restantes para cerrar: " + aparadorTemp1.obtenirDiesRestants());
        
        System.out.println("\n----Compra de productos----\n");
        System.out.print("Pol ratlles: " + aparadorTemp1.comprobarStockDeProducte(polRatlles) +
                         ", Vestit de bany blau: "+ aparadorTemp1.comprobarStockDeProducte(vestitBlau)+"\n");
        
        aparadorTemp1.comprarProducte("Pol ratlles", 1);
        aparadorTemp1.comprarProducte("vestit de bany blau", 1);
        System.out.print("Pol ratlles: " + aparadorTemp1.comprobarStockDeProducte(polRatlles) +
                         ", Vestit de bany blau: "+ aparadorTemp1.comprobarStockDeProducte(vestitBlau)+"\n");
        
        System.out.println("\n----Consultar que el aparador esta obert----");
        System.out.println(aparadorTemp1.isAparadorActiu());
        
        System.out.println("\n*----------Prueba de un nuevo Aparador (Aparador fins fi de existencies)----------*");
        
        AparadorFinsFiDexistencies AparadorFiExistencies = new AparadorFinsFiDexistencies("Estiu LaCostera 2025 dos", TipusMarca.LACOSTERA);
        System.out.println("------Comprobando productos a la venta------");
        AparadorFiExistencies.obtindreProductesALaVenta();
        AparadorFiExistencies.afegirProducte(stockPolRatlles);
        AparadorFiExistencies.obtindreProductesALaVenta();
        System.out.println("El aparador esta obert? --> "+AparadorFiExistencies.isAparadorActiu());
        
        AparadorFiExistencies.comprarProducte("Pol ratlles", stockPolRatlles.getNumeroDeProductesDisponibles());
        System.out.println("El aparador esta obert? --> "+AparadorFiExistencies.isAparadorActiu());
        
        System.out.println("\n*----------Prueba de un nuevo Aparador (Aparador fins fi de existencies y temps)----------*");
    }
}
