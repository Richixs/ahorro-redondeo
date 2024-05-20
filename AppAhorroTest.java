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
        cuenta.obtenerAhorro(1.8);
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
}
