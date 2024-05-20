import java.util.ArrayList;
public class AppAhorro{       
    
    private Ahorro ahorroTotal;
    ArrayList<Meta> metas; 
    
    public AppAhorro(){
        ahorroTotal = new Ahorro();
        metas = new ArrayList<Meta>();
    }
    
    // Ahorro

    public double obtenerAhorro(double costoProducto){        
        double montoPagado = (int)Math.ceil(costoProducto);
        double ahorro;        
        ahorro = (double)Math.round((montoPagado - costoProducto) * 100d) / 100d; 
        ahorroTotal.agregarAhorro(ahorro);
        return ahorro;
    }
    
    public double obtenerTotalAhorrado(){         
        return ahorroTotal.obtenerAhorrado();
    }

    // META

    public void crearMeta(String nombre){
        Meta meta = new Meta(nombre);
        metas.add(meta);
    }

    public void crearMeta(String nombre, double montoMeta) {
        Meta meta = new Meta(nombre, montoMeta);
        metas.add(meta);
    }

    public void definirMontoMeta(String nombreMeta, double monto){
        try {
            boolean metaExiste = obtenerMeta(nombreMeta).obtenerNombreMeta().equals(nombreMeta);
            if (metaExiste) {
                obtenerMeta(nombreMeta).agregarMontoMeta(monto);
            } else {
                throw new Exception("no mi pana, no tienes esa meta asignada.");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Meta obtenerMeta(String nombreMeta) {
        return metas.stream().filter(meta -> meta.obtenerNombreMeta().equals(nombreMeta)).findFirst().get();
    }

    public ArrayList<Meta> obtenerMetas(){
        return metas;
    }
}
