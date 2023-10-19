package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scN = new Scanner(System.in);
		
		ArrayList<ContaCorrente> ccorrentes = new ArrayList<>();
		ArrayList<Poupanca> poupancas = new ArrayList<>();
		ArrayList<Ouro> ouros = new ArrayList<>();
		
		GerenciaPoupancas gp = new GerenciaPoupancas(poupancas);
		GerenciaContasCorrentes gc = new GerenciaContasCorrentes(ccorrentes);
		GerenciaOuro go = new GerenciaOuro(ouros);
		
		int opGeral, opOuro, opCC, opPoup;
        
        do {
        	System.out.println("---==[Cadastro de Contas Bancárias]==---");
        	System.out.println("1 - Poupança");
        	System.out.println("2 - Conta Corrente");
        	System.out.println("3 - Ouro");
        	System.out.println("4 - Sair");
        	System.out.println("Opção: ");
        	opGeral = scN.nextInt();
        	
        	switch(opGeral) {
	        	case 1:  // Poupança
	                do {
	                	System.out.println("--=[Cadastro de Poupança]=--");
	                	System.out.println("1 - Inclusão");
	                	System.out.println("2 - Exclusão");
	                	System.out.println("3 - Alteração");
	                	System.out.println("4 - Consulta");
	                	System.out.println("5 - Relatório");
	                	System.out.println("6 - Depósito");
	                	System.out.println("7 - Saque");
	                	System.out.println("8 - Voltar");
	                	System.out.println("Opção: ");
	                	opPoup = scN.nextInt();
	                	
	                	switch(opPoup) {
        	        	case 1:  
        	        		gp.incluir();
        	        		break;
        	        	case 2:  
        	        		gp.excluir();
        	        		break;
        	        	case 3:  
        	        		gp.alterar();
        	        		break;
        	        	case 4:  
        	        		gp.consultar();
        	        		break;
        	        	case 5:  
        	        		gp.relatorio();
        	        		break;
        	        	case 6:  
        	        		gp.depositar();
        	        		break;
        	        	case 7:  
        	        		gp.sacar();
        	        		break;
        	        	default:
        	        		if(opPoup != 8)
        	        			System.out.println("Opção inválida!");
	                	}
	                }while(opPoup != 8);
	        		break;
	        	case 2:  // Conta Corrente
	                do {
	                	System.out.println("--=[Cadastro de Conta Corrente]=--");
	                	System.out.println("1 - Inclusão");
	                	System.out.println("2 - Exclusão");
	                	System.out.println("3 - Alteração");
	                	System.out.println("4 - Consulta");
	                	System.out.println("5 - Relatório");
	                	System.out.println("6 - Depósito");
	                	System.out.println("7 - Saque");
	                	System.out.println("8 - Alteração valor cheque especial");
	                	System.out.println("9 - Voltar");
	                	System.out.println("Opção: ");
	                	opCC = scN.nextInt();
	                	
	                	switch(opCC) {
        	        	case 1:  
        	        		gc.incluir();
        	        		break;
        	        	case 2:  
        	        		gc.excluir();
        	        		break;
        	        	case 3:  
        	        		gc.alterar();
        	        		break;
        	        	case 4:  
        	        		gc.consultar();
        	        		break;
        	        	case 5:  
        	        		gc.relatorio();
        	        		break;
        	        	case 6:  
        	        		gc.depositar();
        	        		break;
        	        	case 7:  
        	        		gc.sacar();
        	        		break;
        	        	case 8:  
        	        		gc.alterarChequeEspecial();
        	        		break;
        	        	default:
        	        		if(opCC != 9)
        	        			System.out.println("Opção inválida!");
	                	}
	                }while(opCC!= 9);
	        		break;
	        	case 3:  // Ouro
	                do {
	                	System.out.println("--=[Cadastro de Conta Ouro]=--");
	                	System.out.println("1 - Inclusão");
	                	System.out.println("2 - Exclusão");
	                	System.out.println("3 - Alteração");
	                	System.out.println("4 - Consulta");
	                	System.out.println("5 - Relatório");
	                	System.out.println("6 - Depósito");
	                	System.out.println("7 - Saque");
	                	System.out.println("8 - Voltar");
	                	System.out.println("Opção: ");
	                	opOuro = scN.nextInt();
	                	
	                	switch(opOuro) {
        	        	case 1:  
        	        		go.incluir();
        	        		break;
        	        	case 2:  
        	        		go.excluir();
        	        		break;
        	        	case 3:  
        	        		go.alterar();
        	        		break;
        	        	case 4:  
        	        		go.consultar();
        	        		break;
        	        	case 5:  
        	        		go.relatorio();
        	        		break;
        	        	case 6:  
        	        		go.depositar();
        	        		break;
        	        	case 7:  
        	        		go.sacar();
        	        		break;
        	        	default:
        	        		if(opOuro != 8)
        	        			System.out.println("Opção inválida!");
	                	}
	                }while(opOuro != 8);
	        		break;
	        	default:
	        		if(opGeral != 4)
	        			System.out.println("Opção inválida!");
        	}
        }while(opGeral != 4);
		
		scN.close();
	}
}
