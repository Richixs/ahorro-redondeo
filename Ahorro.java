public class Ahorro {
    
    private Double montoAhorrado;

    public Ahorro() {
        this.montoAhorrado = 0.0;
    }

    public void agregarAhorro(double monto) {
        this.montoAhorrado += monto;
    }

    public double obtenerAhorrado() {
        return this.montoAhorrado;
    }
}
