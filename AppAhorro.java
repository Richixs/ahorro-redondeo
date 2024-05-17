
/**
 * Write a description of class AppAhorro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AppAhorro{
    double montoPagado;
    double costoProducto;
    double ahorro;
    public AppAhorro(double costoProducto, double montoPagado){
        this.montoPagado   = montoPagado;
        this.costoProducto = costoProducto;        
    }
    
    public AppAhorro(double costoProducto){
        this.costoProducto = costoProducto ;
        this.montoPagado   = (int)Math.ceil(costoProducto);        
    }
    
    public double obteneRedondeo(){
        double redondeo = montoPagado - costoProducto;
        ahorro += redondeo;
        return redondeo; 
    }  
    
    public double getAhorro(){
        return ahorro;
    }
}
