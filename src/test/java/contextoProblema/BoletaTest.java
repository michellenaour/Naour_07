package contextoProblema;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoletaTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testToString() {
        Plato plato1=new Plato(TipoPlato.PIZZA,2000);
        Plato plato2=new Plato(TipoPlato.EMPANADA,1000);
        Boleta boleta=new Boleta();
        boleta.setTotal(3000);
        System.out.println(boleta.toString());
    }
}