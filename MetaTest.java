
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MetaTest{
    @Test
    public void agregarMeta(){
        Meta meta = new Meta("vacacion");
        assertEquals("vacacion",meta.obtenerNombreMeta());
    }
    
    @Test 
    public void obtenerMontObjetivo(){
        Meta meta = new Meta("vacacion");
        assertEquals("Monto objetivo no asignado.",meta.obtenerMontoMeta());
    }  
    
    @Test
    public void AsignarMontoMeta(){
        Meta meta = new Meta("Vacacion", 200.0);
        assertEquals("200.0", meta.obtenerMontoMeta());
    }
    
    @Test
    public void sumarElAhorro() {
        Meta meta = new Meta("Vacacion");
        meta.sumarAhorro(0.8);
        assertEquals(0.8, meta.obtenerAhorrado());
    }
    
    @Test 
    public void SaberSiLaMetaSeComleto(){
        Meta meta = new Meta("Vacacion", 200.0);
        assertFalse(meta.obtenerMetaCompletado());
    }
}
