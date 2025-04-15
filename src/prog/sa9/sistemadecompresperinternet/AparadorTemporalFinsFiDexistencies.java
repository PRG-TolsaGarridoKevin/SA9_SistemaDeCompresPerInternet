package prog.sa9.sistemadecompresperinternet;
public class AparadorTemporalFinsFiDexistencies extends Aparador{
    
    public AparadorTemporalFinsFiDexistencies(String nom, TipusMarca marca) {
        super(nom, marca);
    }
    
    //Aparador temporal fins a fi d'existencies = maximo 3 dias abierto pero cierra antes si se acaba el stock.
    //Excepcion = ShowRoomNotOpenException = Intento de compra con el aparador cerrado (excepcio de obligat tractament)

}
