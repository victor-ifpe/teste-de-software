package br.edu.ifpe.jaboatao.ts.servicos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Bicicleta;
import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;

public class LocacaoServiceTest {
    private LocacaoService locacaoService;

    @BeforeEach
    public void setUp() {
        locacaoService = new LocacaoService();
    }

    // Teste 4.a
    @Test
    @DisplayName("Questao 4.a - Testar se valor da locacao está sendo calculado corretamente com duas bicicletas")
    public void verificarCalculoValorLocacaoComDuasBicicletas() {
        // Cenario
        Cliente cliente = new Cliente("Victor");
        List<Bicicleta> bicicletas = Arrays.asList(
                new Bicicleta("BMX", 2, 500.0),
                new Bicicleta("BMX2", 2, 500.0));

        // Acao
        Locacao locacao = locacaoService.alugarBicicleta(cliente, bicicletas);

        // Verificao
        assertEquals(1000.0, locacao.getValorLocacao());
    }

    // Teste 4.b
    @Test
    @DisplayName("Questao 4.b - Testando se a exceção bicicleta nula está sendo acionada usando assertThrows")
    public void verificarValorNullAssertThrows() {
        // Cenario
        Cliente cliente = new Cliente("Victor");
        List<Bicicleta> bicicletas = Arrays.asList(
                new Bicicleta("BMX", 2, 500.0),
                new Bicicleta("BMX2", 2, 500.0),
                new Bicicleta());

        // Acao
        LocacaoService locacaoService = new LocacaoService();
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> locacaoService.alugarBicicleta(cliente, bicicletas));

        // Verificao
        assertEquals("Execeção: Bicicleta nula.", exception.getMessage());
    }

    // Teste 4.c
    @Test
    @DisplayName("Questao 4.c - Testando se a exceção verificar valor bicicleta está sendo acionada usando try/catch")
    public void verificarValorBicicletaTryCatch() {
        // Cenario
        Cliente cliente = new Cliente("Victor");
        List<Bicicleta> bicicletas = Arrays.asList(
                new Bicicleta("BMX", 2, 499.0));

        try {
            // Acao
            Locacao locacao = locacaoService.alugarBicicleta(cliente, bicicletas);

        } catch (IllegalArgumentException e) {

            // Verificao
            assertEquals("Execeção: Verificar valor da bicicleta.", e.getMessage());
        }
    }

    // Teste 5.a
    @Test
    @DisplayName("Questao 5.a - Testar se o desconto está sendo aplicado corretamente para quem comprou quatro bicicletas")
    public void verificarCalculoValorLocacaoComQuatroBicicletas() {
        // Cenario
        Cliente cliente = new Cliente("Victor");
        List<Bicicleta> bicicletas = Arrays.asList(
                new Bicicleta("BM1", 2, 500.0),
                new Bicicleta("BMX2", 2, 500.0),
                new Bicicleta("BMX3", 2, 500.0),
                new Bicicleta("BMX4", 2, 500.0));

        // Acao
        Locacao locacao = locacaoService.alugarBicicleta(cliente, bicicletas);

        // Verificao
        assertEquals(1440.0, locacao.getValorLocacao());
    }

    // Teste 5.b
    @Test
    @DisplayName("Questao 5.b - Testar se o desconto está sendo aplicado corretamente para quem comprou cinco ou mais bicicletas")
    public void verificarCalculoValorLocacaoComCincoBicicletas() {
        // Cenario
        Cliente cliente = new Cliente("Victor");
        List<Bicicleta> bicicletas = Arrays.asList(
                new Bicicleta("BMX1", 2, 500.0),
                new Bicicleta("BMX2", 2, 500.0),
                new Bicicleta("BMX3", 2, 500.0),
                new Bicicleta("BMX4", 2, 500.0),
                new Bicicleta("BMX4", 2, 500.0));

        // Acao
        Locacao locacao = locacaoService.alugarBicicleta(cliente, bicicletas);

        // Verificao
        assertEquals(1700.0, locacao.getValorLocacao());
    }

    // Teste 5.c
    @Test
    @DisplayName("Questao 5.c - Testar se o desconto está sendo aplicado corretamente para valores iguais ou superiores a R$1999.0")
    public void verificarCalculoValorLocacaoIgualMaior1999() {
        // Cenario
        Cliente cliente = new Cliente("Victor");
        List<Bicicleta> bicicletas = Arrays.asList(
                new Bicicleta("BMX1", 2, 1500.0),
                new Bicicleta("BMX2", 2, 5500.0));

        // Acao
        Locacao locacao = locacaoService.alugarBicicleta(cliente, bicicletas);

        // Verificao
        assertEquals(5600.0, locacao.getValorLocacao());
    }
}