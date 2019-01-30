package br.ufsc.bank.easyaccept.facade;

import java.math.BigDecimal;

import br.ufsc.model.Loan;
import easyaccept.script.test.TestFacade;

public class LoanFacade extends TestFacade {

	public BigDecimal calcularValorTotalDoFinanciamentoComJuros(Double valorDesejado, Double taxaDeJurosMensal, Long numeroDeParcelas) {
		Loan emprestimo = new Loan(valorDesejado, taxaDeJurosMensal, numeroDeParcelas);
		return emprestimo.getLoanAmountWithInterests();
	}

	public BigDecimal calcularValorDasParcelasMensais(Double valorDesejado, Double taxaDeJurosMensal, Long numeroDeParcelas) {
		Loan emprestimo = new Loan(valorDesejado, taxaDeJurosMensal, numeroDeParcelas);
		return emprestimo.getValueOfMontlhyInstalments();
	}

}
