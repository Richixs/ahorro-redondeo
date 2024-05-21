import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class AppAhorro{       
    
    private Ahorro ahorroTotal;
    ArrayList<Meta> metas;
    
    public AppAhorro(){
        ahorroTotal = new Ahorro();
        metas = new ArrayList<Meta>();
    }
    
    public double obtenerAhorro(double costoProducto){        
        double montoPagado = (int)Math.ceil(costoProducto);
        double ahorro;        
        ahorro = (double)Math.round((montoPagado - costoProducto) * 100d) / 100d; 
        return ahorro;
    }
    
    public double obtenerTotalAhorrado(){
        return ahorroTotal.obtenerAhorrado();
    }

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
            if (existeMeta(nombreMeta)) {
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

    public void asignarAhorroDirecto(double costo, String nombreMeta) {
        double ahorroTransaccion = obtenerAhorro(costo);
        this.ahorroTotal.agregarAhorro(ahorroTransaccion);
        obtenerMeta(nombreMeta).sumarAhorro(ahorroTransaccion);
    }

    public void asignarPorcentajeAhorro(double costo, String nombreMeta, int porcentaje) {
        try {
            if (verificarPorcentaje(porcentaje)) {
                double ahorroTransaccion = obtenerAhorro(costo);
                this.ahorroTotal.agregarAhorro(ahorroTransaccion);
                double metaAhorro = obtenerPorCiento(ahorroTransaccion, porcentaje);
                obtenerMeta(nombreMeta).sumarAhorro(metaAhorro);
                ahorroTransaccion -= metaAhorro;
                double ahorroRepartir = ahorroTransaccion/(obtenerMetas().size()-1);
                for (Meta meta : obtenerMetas()) {
                    if (!meta.obtenerNombreMeta().equals(nombreMeta)) {
                        meta.sumarAhorro(ahorroRepartir);
                    }
                }
            } else if (porcentaje == 100) {
                asignarAhorroDirecto(costo, nombreMeta);
            } else {
                throw new IllegalArgumentException("Chale no se va a poder...");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void asignarPorcentajeEquitativo(double costo) {
        double ahorroTransaccion = obtenerAhorro(costo);
        this.ahorroTotal.agregarAhorro(ahorroTransaccion);
        double ahorroRepartir = ahorroTransaccion/(obtenerMetas().size());
        for (Meta meta : obtenerMetas()) {
            meta.sumarAhorro(ahorroRepartir);
        }
    }

    public void depositoDirecto(String nombreMeta, double montoDeposito) {
        if (montoDeposito > 0 && existeMeta(nombreMeta)) {
            obtenerMeta(nombreMeta).sumarAhorro(montoDeposito);
            ahorroTotal.agregarAhorro(montoDeposito);
        } else {
            throw new IllegalArgumentException("Parametros introducidos no validos");
        }
    }

    public void depositoDirectoPorPorcentaje(String nombreMeta, int porcentaje) {
        if (existeMeta(nombreMeta) && verificarPorcentaje(porcentaje) && verificarMontoMeta(nombreMeta)) {
            Double montoDeposito = obtenerPorCiento(Double.valueOf(obtenerMeta(nombreMeta).obtenerMontoMeta()), porcentaje);
            obtenerMeta(nombreMeta).sumarAhorro(montoDeposito);
            ahorroTotal.agregarAhorro(montoDeposito);
        } else {
            throw new IllegalArgumentException("Parametros introducidos no validos");
        }
    }

    public void cargarMeta(String meta) {
        ArrayList<String> archivoMeta = new ArrayList<String>();
        String regex = "[^_]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(meta);
        while (matcher.find()) {
            archivoMeta.add(matcher.group());
        }
        Meta guardarMeta = new Meta(archivoMeta.get(0), archivoMeta.get(1), 
                    new Ahorro(Double.valueOf(archivoMeta.get(2))));
        metas.add(guardarMeta);
    }

    public void cargarMetas(ArrayList<String> metas) {
        for(String meta : metas) {
            cargarMeta(meta);
        }
    }

    private boolean existeMeta(String nombreMeta) {
        return obtenerMeta(nombreMeta).obtenerNombreMeta().equals(nombreMeta);
    }

    private boolean verificarPorcentaje(int porcentaje) {
        return porcentaje > 0 && porcentaje < 100;
    }

    private double obtenerPorCiento(double monto, int porcentaje) {
        return (monto*porcentaje)/100;
    }

    private boolean verificarMontoMeta(String nombreMeta) {
        return !obtenerMeta(nombreMeta).obtenerMontoMeta().equals("Monto objetivo no asignado");
    }
}