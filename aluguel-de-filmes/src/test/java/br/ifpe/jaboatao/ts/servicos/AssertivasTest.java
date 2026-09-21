package br.ifpe.jaboatao.ts.servicos;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Usuario;

public class AssertivasTest {
    
    @Test
    public void teste01() {

        assertTrue(3 == 3);

        assertFalse(2 > 3);

        assertEquals(0.52, 0.521, 0.01);
        assertEquals(Math.PI, 3.14, 0.01);
        assertEquals("casa", "casa");

        Usuario usu01 = new Usuario("Usuario 01");
        Usuario usu02 = new Usuario("Usuario 02");

        Usuario usu03 = usu02;








    }

}
