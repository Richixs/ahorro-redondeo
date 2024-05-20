public class Meta{
    
    private String nombre;
    private double ahorrado;
    private String montoMeta;
    private boolean metaCompletado;

    public Meta(String nombre){
        this.nombre = nombre;
        this.ahorrado = 0;
        this.montoMeta = "Monto objetivo no asignado.";
        this.metaCompletado = false;
    }

    public Meta(String nombre, double montoMeta){
        this(nombre);
        this.montoMeta = String.valueOf(montoMeta);
    }
    
    public String obtenerNombreMeta(){
        return this.nombre;
    }

    public double obtenerAhorrado(){
        return this.ahorrado;
    }

    public void sumarAhorro(double ahorroRedondeo) {
        this.ahorrado += ahorroRedondeo;
    }

    public String obtenerMontoMeta(){
        return this.montoMeta;
    }

    public void agregarMontoMeta(double montoMeta) {
        this.montoMeta = String.valueOf(montoMeta);
    }

    public boolean obtenerMetaCompletado(){
        return this.metaCompletado;
    }
}
