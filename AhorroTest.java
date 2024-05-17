

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class AhorroTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AhorroTest
{
    /**
     * Default constructor for test class AhorroTest
     */
    public AhorroTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void redondear(){
        AppAhorro cuenta = new AppAhorro(1.8, 2.0);
        double res = cuenta.obteneRedondeo();
        assertEquals(0.2, res, 0.0001); // es un delta de comparacion de doubles        
    }
    
    @Test 
    public void test2(){
        AppAhorro cuenta = new AppAhorro(1.8);
        double res = cuenta.obteneRedondeo();
        assertEquals(0.2, res, 0.0001);
    }

    @Test
    public void ahorraRedondeo(){
        AppAhorro cuenta = new AppAhorro(1.8);
        cuenta.obteneRedondeo();
        double ahorro = cuenta.getAhorro();        
        assertEquals(0.2, ahorro, 0.0001); 
    }
}
