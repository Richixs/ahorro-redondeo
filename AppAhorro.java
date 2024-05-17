
/**
 * Write a description of class AppAhorro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AppAhorro{
    double montoPagado;
    double costoProducto;
    public AppAhorro(double costoProducto, double montoPagado){
        this.montoPagado = montoPagado;
        this.costoProducto = costoProducto;        
    }
    
    public double obteneRedondeo(){
        return montoPagado - costoProducto; 
    }
}
