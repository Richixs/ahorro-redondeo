
public class Meta{    
    
    private String nombre;
    private String montoMeta;    
    private double ahorrado;
    private boolean metaCompletado;
    
    public Meta(String nombre){
        this.nombre = nombre;
        this.montoMeta = "Monto objetivo no asignado.";
        this.ahorrado = 0;
        this.metaCompletado = false;
    }
    
    public Meta(String nombre, double montoMeta){
        this(nombre);
        this.montoMeta = String.valueOf(montoMeta);
    } 
    
    public String obtenerNombreMeta(){
        return this.nombre;
    } 
    
    public String obtenerMontoMeta(){
        return this.montoMeta;
    }
    
    public double obtenerAhorrado(){
        return this.ahorrado;
    }
    
     public void sumarAhorro(double depositoDirecto) {
        this.ahorrado += depositoDirecto;
    }
    
    public boolean obtenerMetaCompletado(){
        return this.metaCompletado;
    }
}  
