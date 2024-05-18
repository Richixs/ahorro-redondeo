import java.util.ArrayList;
public class AppAhorro{       
    
    private double ahorroTotal;
    ArrayList<String> metas; 
    ArrayList<String> montoMeta;
    
    public AppAhorro(){
        metas = new ArrayList<String>();
        montoMeta = new ArrayList<String>();
    }
    
    public double obtenerAhorro(double costoProducto){        
        double montoPagado = (int)Math.ceil(costoProducto);
        double ahorro;        
        ahorro = (double)Math.round((montoPagado - costoProducto) * 100d) / 100d; 
        this.ahorroTotal += ahorro;
        return ahorro;
    }
    
    public double obtenerTotalAhorrado(){         
        return ahorroTotal;
    }
    
    public void crearMeta(String meta){
        metas.add(meta);
    }
    
    public ArrayList<String> obtenerMetas(){
        return metas;
    }
    
    public ArrayList<String> obtenerMontoMeta(){
        return montoMeta;
    } 
    
    public void definirMontoMeta(String meta, double monto){
        monto = (double)Math.round(monto * 100d) / 100d;
        montoMeta.add(meta + ", " +  monto);        
    }
}
