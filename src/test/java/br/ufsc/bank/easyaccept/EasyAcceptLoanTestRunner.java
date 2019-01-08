package br.ufsc.bank.easyaccept;

import java.util.ArrayList;
import java.util.List;

import br.ufsc.bank.easyaccept.facade.ATMFacade;
import br.ufsc.bank.easyaccept.facade.LoanFacade;
import easyaccept.EasyAcceptFacade;

public class EasyAcceptLoanTestRunner {
    public static void main(String[] args) throws Exception {
    	List<String> files = new ArrayList<String>();
    	files.add("C:/Users/ernani/git/bankapp-EasyAccept/src/test/java/br/ufsc/bank/easyaccept/scripts/loan/");
        LoanFacade loanFacade = new LoanFacade();
        EasyAcceptFacade eaFacade = new EasyAcceptFacade(loanFacade, files);
        eaFacade.executeTests();
        System.out.println(eaFacade.getCompleteResults());
    }

}

