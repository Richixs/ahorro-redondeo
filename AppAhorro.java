import java.util.ArrayList;
public class AppAhorro{       
    
    private Ahorro ahorroTotal;
    private ManejadorArchivos manejadorArchivos;
    ArrayList<Meta> metas; 
    
    public AppAhorro(){
        ahorroTotal = new Ahorro();
        metas = new ArrayList<Meta>();
        manejadorArchivos = new ManejadorArchivos();
    }
    
    // Ahorro

    public double obtenerAhorro(double costoProducto){        
        double montoPagado = (int)Math.ceil(costoProducto);
        double ahorro;        
        ahorro = (double)Math.round((montoPagado - costoProducto) * 100d) / 100d; 
        return ahorro;
    }
    
    public double obtenerTotalAhorrado(){         
        return ahorroTotal.obtenerAhorrado();
    }

    // META

    public void crearMeta(String nombre){
        Meta meta = new Meta(nombre);
        metas.add(meta);
        manejadorArchivos.crearArchivo(nombre);
        manejadorArchivos.añadirTexto(nombre, obtenerMeta(nombre).obtenerNombreMeta());
        manejadorArchivos.añadirTexto(nombre, String.valueOf(obtenerMeta(nombre).obtenerAhorrado()));
        manejadorArchivos.añadirTexto(nombre, obtenerMeta(nombre).obtenerMontoMeta());
        manejadorArchivos.añadirTexto(nombre, String.valueOf(obtenerMeta(nombre).obtenerMetaCompletado()));
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

    // Transaccion

    public void transaccion(double costo, String nombreMeta) {
        double ahorroTransaccion = obtenerAhorro(costo);
        obtenerMeta(nombreMeta).sumarAhorro(ahorroTransaccion);
        ahorroTotal.agregarAhorro(ahorroTransaccion);
    }

    public void transaccion(double costo, String nombreMeta, int porcentaje) {
        try {
            if (porcentaje > 0 && porcentaje < 100) {
                double ahorroTransaccion = obtenerAhorro(costo);
                double metaAhorro = (porcentaje*ahorroTransaccion)/100;
                obtenerMeta(nombreMeta).sumarAhorro(metaAhorro);
                ahorroTransaccion -= metaAhorro;
                double ahorroRepartir = ahorroTransaccion/(obtenerMetas().size()-1);
                for (Meta meta : obtenerMetas()) {
                    if (!meta.obtenerNombreMeta().equals(nombreMeta)) {
                        meta.sumarAhorro(ahorroRepartir);
                    }
                }
            } else if (porcentaje == 100) {
                transaccion(costo, nombreMeta);
            } else {
                throw new IllegalArgumentException("Chale no se va a poder...");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void transaccion(double costo) {
        double ahorroTransaccion = obtenerAhorro(costo);
        double ahorroRepartir = ahorroTransaccion/(obtenerMetas().size());
        ahorroTotal.agregarAhorro(ahorroTransaccion);
        for (Meta meta : obtenerMetas()) {
            meta.sumarAhorro(ahorroRepartir);
        }
    }
}