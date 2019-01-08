package br.ufsc.bank.easyaccept.facade;

import java.util.Date;

import br.ufsc.model.ATM;
import easyaccept.script.test.TestFacade;

public class ATMFacade extends TestFacade{
	
	private ATM atm;
			
	public void setUp(String nome, String numeroDoCartao, String numeroDoContaCorrente, Double saldo, int senha, String notasATM_5_10_20_50_100) throws Exception {
		this.atm = new ATM();
		atm.getBank().createBankCustomer(1, nome, numeroDoCartao, senha, numeroDoContaCorrente, saldo);
		String[] notas = notasATM_5_10_20_50_100.split(",");
		atm.chargeBills(Integer.parseInt(notas[0]), Integer.parseInt(notas[1]), Integer.parseInt(notas[2]), Integer.parseInt(notas[3]), Integer.parseInt(notas[4]));
		
		
		
	}
	
	public void setErroDeSenhaNasUltimas72horas(String numeroDoCartao, int numeroDeErros, int numeroDeHorasDoprimeiroErro) throws Exception {
		for (int i=1; i<=numeroDeErros; i++) {
			atm.getBank().getCardByNumber(numeroDoCartao).insertPinHistory(false, new Date(new Date().getTime()-(numeroDeHorasDoprimeiroErro*3600000)));
		}
	}
	
	public String sacar(String numeroDoCartao, Integer valor, int senha) throws Exception{
			atm.withDraw(numeroDoCartao, senha, valor);
			return "Sucesso!";
	}
	
	public Double verSaldo(String numeroDoCartao) throws Exception {
		return atm.getBank().getAccountByCardNumber(numeroDoCartao).getBalance();
	}
	
}
