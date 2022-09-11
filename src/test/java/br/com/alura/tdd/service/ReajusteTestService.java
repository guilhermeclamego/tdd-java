package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteTestService {
    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void init() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    public void reajusteDeTresPorcendoQuandoDesempenhoForADesejar() {;
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1322.50"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1440.00"), funcionario.getSalario());
    }
}
