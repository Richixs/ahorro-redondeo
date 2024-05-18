import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

public class AhorroTest{       
    
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
        assertTrue(cuenta.obtenerMetas().contains("vacacion")); 
    }
    
    @Test 
    public void definirMetasConMontosEspecificos(){
        cuenta.definirMontoMeta("vacacion", 200);
        assertTrue(cuenta.obtenerMontoMeta().contains("vacacion, 200.0"));
    }
}
