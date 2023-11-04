import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DecoyDuckTest {
    private Duck d;
    private ByteArrayOutputStream out;

    public DecoyDuckTest(){}

    @Before
    public void Before(){
        d = new DecoyDuck();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream( out ));
    }

    @Test
    public void testToString(){
        String esperado = "decoyduck{}";
        String obtenido = d.toString().toLowerCase();

        assertEquals(esperado, obtenido);

    }


    @Test
    public void testSwim(){
        d.swim();
        assertTrue(out.toString().toLowerCase().contains("estoy nadando"));
    }

    @Test
    public void testPerformFly(){
        d.performFly();
        // assertTrue(out.toString().toLowerCase().contains("estoy volando"));

        String obtenido = out.toString().toLowerCase();
        String esperado = "no puedo volar";
        assertEquals(obtenido, esperado);
    }

    @Test
    public void testDisplay(){
        d.Display();
        String obtenido = out.toString().toLowerCase();
        String esperado = "hola, soy un pato señuelo";
        assertEquals(obtenido, esperado);
    }

    @Test
    public void testPerformSound(){
        d.performSound();
        assertTrue(out.toString().toLowerCase().contains("no hago ningun sonido"));
    }
}
