public class Meta{
    
    private String nombre;
    private Ahorro ahorrado;
    private String montoMeta;
    private boolean metaCompletado;

    public Meta(String nombre){
        this.nombre = nombre;
        this.ahorrado = new Ahorro();
        this.montoMeta = "Monto objetivo no asignado";
        this.metaCompletado = false;
    }

    public Meta(String nombre, double montoMeta){
        this(nombre);
        this.montoMeta = String.valueOf(montoMeta);
    }

    public Meta(String nombre, String montoMeta, Ahorro ahorrado) {
        this(nombre);
        this.montoMeta = montoMeta;
        this.ahorrado = ahorrado;
        boolean tieneMontoMeta = !montoMeta.equals("Monto objetivo no asignado");
        if (tieneMontoMeta) {
            this.metaCompletado = this.ahorrado.obtenerAhorrado() >= Double.valueOf(this.montoMeta);
        }
    }
    
    public String obtenerNombreMeta(){
        return this.nombre;
    }

    public double obtenerAhorrado(){
        return this.ahorrado.obtenerAhorrado();
    }

    public void sumarAhorro(double monto) {
        ahorrado.agregarAhorro(monto);
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