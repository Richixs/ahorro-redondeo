import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppAhorroTest{       
    
    private AppAhorro cuenta;
    
    @BeforeEach
    public void setUp()
    {
        this.cuenta = new AppAhorro(); 
    }
    
    @Test
    public void redondearCompra(){      
        double res = cuenta.obtenerAhorro(1.8);
        assertEquals(0.2, res);        
    }
    
    @Test 
    public void totalAhorrado(){        
        cuenta.transaccion(1.8);
        double total = cuenta.obtenerTotalAhorrado();
        assertEquals(0.2, total);
    }    

    @Test
    public void definirMeta(){
        cuenta.crearMeta("vacacion");
        assertTrue(cuenta.obtenerMeta("vacacion").obtenerNombreMeta().equals("vacacion")); 
    }

    @Test 
    public void definirMetasConMontosEspecificos(){
        cuenta.crearMeta("vacacion");
        cuenta.definirMontoMeta("vacacion", 200.0);
        assertTrue(cuenta.obtenerMeta("vacacion").obtenerMontoMeta().equals("200.0"));
    }

    @Test
    public void depositarMetaEspecifica() {
        cuenta.crearMeta("vacacion");
        cuenta.crearMeta("regalo-cumpleanios");
        assertEquals(0, cuenta.obtenerMeta("vacacion").obtenerAhorrado());
        assertEquals(0, cuenta.obtenerMeta("regalo-cumpleanios").obtenerAhorrado());
        cuenta.transaccion(6.5, "regalo-cumpleanios");
        assertEquals(0, cuenta.obtenerMeta("vacacion").obtenerAhorrado());
        assertEquals(0.5, cuenta.obtenerMeta("regalo-cumpleanios").obtenerAhorrado());
    }

    @Test
    public void depositarMetaPorcentaje() {
        cuenta.crearMeta("vacacion");
        cuenta.crearMeta("regalo-cumpleanios");
        cuenta.crearMeta("chaifon");
        assertEquals(0, cuenta.obtenerMeta("vacacion").obtenerAhorrado());
        assertEquals(0, cuenta.obtenerMeta("regalo-cumpleanios").obtenerAhorrado());
        assertEquals(0, cuenta.obtenerMeta("chaifon").obtenerAhorrado());
        cuenta.transaccion(6.5, "chaifon", 50);
        assertEquals(0.125, cuenta.obtenerMeta("vacacion").obtenerAhorrado());
        assertEquals(0.125, cuenta.obtenerMeta("regalo-cumpleanios").obtenerAhorrado());
        assertEquals(0.25, cuenta.obtenerMeta("chaifon").obtenerAhorrado());
    }

    @Test
    public void depositarMetas() {
        cuenta.crearMeta("vacacion");
        cuenta.crearMeta("cumpleanios");
        cuenta.crearMeta("chaifon");
        assertEquals(0, cuenta.obtenerMeta("vacacion").obtenerAhorrado());
        assertEquals(0, cuenta.obtenerMeta("cumpleanios").obtenerAhorrado());
        assertEquals(0, cuenta.obtenerMeta("chaifon").obtenerAhorrado());
        cuenta.transaccion(12.1);
        assertEquals(0.3, cuenta.obtenerMeta("vacacion").obtenerAhorrado());
        assertEquals(0.3, cuenta.obtenerMeta("cumpleanios").obtenerAhorrado());
        assertEquals(0.3, cuenta.obtenerMeta("chaifon").obtenerAhorrado());
    }
}