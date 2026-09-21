package br.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class AnotacoesTest {
   
    @BeforeAll
    public static void antesDeTudo(){
        System.out.println("BeforeAll");
    }

    @BeforeEach
    public void antesDeCadaMetodo() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    public void depoisDeCadaMetodo() {
        System.out.println("BeforeEach");
    }

    @AfterAll
    public static void depoisDeTudo() {
        System.out.println("BeforeAll");
    }
    

    @Test
    @DisplayName("Teste 01")
    //@Order(2)
    public void teste01() {
        System.out.println("Teste 01");
    }

    

    @Test
    @DisplayName("Teste 02")
    //@Order(1)
    public void teste02() {
        System.out.println("Teste 02");
    }



    @Test
    @DisplayName("Teste 03")
    //@Order(3)
    public void teste03() {
        System.out.println("Teste 03");
    }

}

