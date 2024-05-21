import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.bytebuddy.asm.Advice.AssignReturned.ToArguments;

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
        cuenta.asignarPorcentajeEquitativo(1.8);
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
    public void asignarAhorroDirecto() {
        cuenta.crearMeta("vacacion");
        cuenta.crearMeta("regalo-cumpleanios");
        assertEquals(0, cuenta.obtenerMeta("vacacion").obtenerAhorrado());
        assertEquals(0, cuenta.obtenerMeta("regalo-cumpleanios").obtenerAhorrado());
        cuenta.asignarAhorroDirecto(6.5, "regalo-cumpleanios");
        assertEquals(0, cuenta.obtenerMeta("vacacion").obtenerAhorrado());
        assertEquals(0.5, cuenta.obtenerMeta("regalo-cumpleanios").obtenerAhorrado());
    }

    @Test
    public void asignarPorcentajeAhorro() {
        cuenta.crearMeta("vacacion");
        cuenta.crearMeta("regalo-cumpleanios");
        cuenta.crearMeta("chaifon");
        assertEquals(0, cuenta.obtenerMeta("vacacion").obtenerAhorrado());
        assertEquals(0, cuenta.obtenerMeta("regalo-cumpleanios").obtenerAhorrado());
        assertEquals(0, cuenta.obtenerMeta("chaifon").obtenerAhorrado());
        cuenta.asignarPorcentajeAhorro(6.5, "chaifon", 50);
        assertEquals(0.125, cuenta.obtenerMeta("vacacion").obtenerAhorrado());
        assertEquals(0.125, cuenta.obtenerMeta("regalo-cumpleanios").obtenerAhorrado());
        assertEquals(0.25, cuenta.obtenerMeta("chaifon").obtenerAhorrado());
    }

    @Test
    public void asignarPorcentajeEquitativoMetas() {
        cuenta.crearMeta("vacacion");
        cuenta.crearMeta("cumpleanios");
        cuenta.crearMeta("chaifon");
        assertEquals(0, cuenta.obtenerMeta("vacacion").obtenerAhorrado());
        assertEquals(0, cuenta.obtenerMeta("cumpleanios").obtenerAhorrado());
        assertEquals(0, cuenta.obtenerMeta("chaifon").obtenerAhorrado());
        cuenta.asignarPorcentajeEquitativo(12.1);
        assertEquals(0.3, cuenta.obtenerMeta("vacacion").obtenerAhorrado());
        assertEquals(0.3, cuenta.obtenerMeta("cumpleanios").obtenerAhorrado());
        assertEquals(0.3, cuenta.obtenerMeta("chaifon").obtenerAhorrado());
    }
    
    @Test
    public void depositoDirectoMeta() {
        cuenta.crearMeta("vacacion");
        cuenta.depositoDirecto("vacacion", 50.0);
        assertEquals(50.0, cuenta.obtenerMeta("vacacion").obtenerAhorrado());
    }

    @Test
    public void depositoDirectoPorPorcentaje() {
        cuenta.crearMeta("vacacion", 1000);
        cuenta.depositoDirectoPorPorcentaje("vacacion", 50);
        assertEquals(500, cuenta.obtenerMeta("vacacion").obtenerAhorrado());
    }

    @Test
    public void cargarMeta() {
        AdministradorDeArchivos admArchivos = mock(AdministradorDeArchivos.class);
        when(admArchivos.leerMeta()).thenReturn("_pilfrut_Monto objetivo no asignado_50_false");
        cuenta.cargarMeta(admArchivos.leerMeta());
        assertEquals(1, cuenta.obtenerMetas().size());
    }

    @Test
    public void cargarMetas() {
        AdministradorDeArchivos admArchivos = mock(AdministradorDeArchivos.class);
        ArrayList<String> metas = new ArrayList<>(Arrays.asList(
            "_pilfrut_Monto objetivo no asignado_50_false",
            "_vacacion_1000_500_false",
            "_carro_50000_50000_true"
        ));
        when(admArchivos.leerMetas()).thenReturn(metas);
        cuenta.cargarMetas(admArchivos.leerMetas());
        assertEquals(3, cuenta.obtenerMetas().size());
    }
}