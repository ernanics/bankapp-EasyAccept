package br.ufsc.bank.easyaccept.facade;

import br.ufsc.model.ATM;
import br.ufsc.model.Bank;
import br.ufsc.model.Customer;
import easyaccept.script.test.TestFacade;

public class ATMFacade extends TestFacade {

	private Bank banco;
	private Customer cliente;
	private ATM atm;

	public void setUp(String nome, String numeroDoCartao, String numeroDoContaCorrente, Double saldo, Integer senha, String notasATM_5_10_20_50_100) {
		atm = new ATM();
		banco = new Bank();
		atm.setBank(banco);
		cliente = banco.createBankCustomer(0, nome, numeroDoCartao, senha, numeroDoContaCorrente, saldo);
		carregarNotas(notasATM_5_10_20_50_100);
	}

	private void carregarNotas(String notasATM_5_10_20_50_100) {
		String[] notas = notasATM_5_10_20_50_100.split(",");
		Integer notasDe5 = Integer.parseInt(notas[0]);
		Integer notasDe10 = Integer.parseInt(notas[1]);
		Integer notasDe20 = Integer.parseInt(notas[2]);
		Integer notasDe50 = Integer.parseInt(notas[3]);
		Integer notasDe100 = Integer.parseInt(notas[4]);
		atm.chargeBills(notasDe5, notasDe10, notasDe20, notasDe50, notasDe100);
	}

	public void setErroDeSenhaNasUltimas72horas(String numeroDoCartao, Integer numeroDeErros, Integer numeroDeHorasDoprimeiroErro) {}

	public String sacar(String numeroDoCartao, Integer valor, Integer senha) throws Exception {
		atm.withDraw(numeroDoCartao, senha, valor);
		return "Sucesso!";
	}

	public Double verSaldo(String numeroDoCartao) throws Exception {
		return cliente.getCardByCardNumber(numeroDoCartao).getAccount().getBalance();
	}

}
