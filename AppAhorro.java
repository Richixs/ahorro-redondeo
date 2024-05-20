import java.util.ArrayList;
public class AppAhorro{       
    
    private double ahorroTotal;
    ArrayList<Meta> metas; 
    
    public AppAhorro(){
        metas = new ArrayList<Meta>();
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
    
    public void crearMeta(String nombre){
        Meta meta = new Meta(nombre);
        metas.add(meta);
    }

    public void crearMeta(String nombre, double montoMeta) {
        Meta meta = new Meta(nombre, montoMeta);
        metas.add(meta);
    }
    
    public ArrayList<Meta> obtenerMetas(){
        return metas;
    }
    
    /*public void definirMontoMeta(String meta, double monto){
        monto = (double)Math.round(monto * 100d) / 100d;
        montoMeta.add(meta + ", " +  monto);        
    }*/
}
