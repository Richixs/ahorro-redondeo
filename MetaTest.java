import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MetaTest {    
    
    @Test
    public void test1() {
        Meta meta = new Meta("Vacacion");
        assertEquals("Vacacion", meta.obtenerNombreMeta());
    }

    @Test
    public void test2() {
        Meta meta = new Meta("Vacacion");
        assertEquals("Monto objetivo no asignado.", meta.obtenerMontoMeta());
    }

    @Test
    public void test3() {
        Meta meta = new Meta("Vacacion", 200.0);
        assertEquals("200.0", meta.obtenerMontoMeta());
    }

    @Test
    public void test4() {
        Meta meta = new Meta("Vacacion");
        meta.sumarAhorro(0.8);
        assertEquals(0.8, meta.obtenerAhorrado());
    }

    @Test
    public void Test5() {
        Meta meta = new Meta("Vacacion", 200.0);
        assertFalse(meta.obtenerMetaCompletado());
    }
}
