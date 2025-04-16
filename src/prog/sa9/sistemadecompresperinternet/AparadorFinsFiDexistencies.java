package prog.sa9.sistemadecompresperinternet;
public class AparadorFinsFiDexistencies extends Aparador {
    
    public AparadorFinsFiDexistencies(String nom, TipusMarca marca) {
        super(nom, marca);
    }
    
    @Override
    public void obrirAparador() {
        if (hayProductosEnStock()) {
            super.obrirAparador();  
            System.out.println("L'aparador s'ha obert");
        } else {
            System.out.println("No hi ha productes en estoc, no es pot obrir l'aparador");
        }
    }

    private boolean hayProductosEnStock() {
        for (StockProducte stockProducte : stock) {
            if (stockProducte.getNumeroDeProductesDisponibles() > 0) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void tancarAparador() {
        super.aparadorActiu = false;
        System.out.println("L'aparador s'ha tancat");
    }
}
