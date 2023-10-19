package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaContasCorrentes {
	private Scanner scN;
	private ArrayList<ContaCorrente> contas;
	
	public GerenciaContasCorrentes(ArrayList<ContaCorrente> cts) {
		contas = cts;
		scN = new Scanner(System.in);
	}
	
	public void incluir() {
		
		System.out.println("--==[Criação de conta corrente]==--");
		System.out.println("- Digite o número da agência: ");
		int ag = scN.nextInt();
		System.out.println("- Digite o número da conta: ");
		int con = scN.nextInt();
		
		ContaCorrente cc = new ContaCorrente(ag,con);
		
		contas.add(cc);
		
		System.out.println("Conta ativada com sucesso.");
	}
	
	public void excluir() {
		System.out.println("--==[Exclusão de conta corrente]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos, resp;
			
			System.out.println("Qual posição deseja excluir?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < contas.size())){
				System.out.println("-[Dados da conta corrente]-");
				
				ContaCorrente con = contas.get(pos); 
				mostrar(con);
				
				if(con.saldo() > 0)
					System.out.println("A conta precisa estar "
							+ "zerada para poder ser excluída.");
				else {
					System.out.println("Confirma a exclusão? (1-sim/2-não)");
					resp = scN.nextInt();
					
					if(resp == 1) {
						contas.remove(pos);
						System.out.println("Exclusão efetivada.");
					}
					else
						System.out.println("Exclusão não efetuada.");
				}
			}
			else
				System.out.println("Posição inválida.");
		}
	}
	
	public void alterar() {
		System.out.println("--==[Alteração de conta corrente]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos, resp;
			
			System.out.println("Qual posição deseja alterar?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < contas.size())){
				System.out.println("-[Dados da conta corrente]-");
				mostrar(contas.get(pos));

				System.out.println("Confirma a alteração? (1-sim/2-não)");
				resp = scN.nextInt();
				
				if(resp == 1) {
					System.out.println("- Digite os novos dados:");
					System.out.println("- agência: ");
					contas.get(pos).setAgencia(scN.nextInt());
					System.out.println("- conta: ");
					contas.get(pos).setNumero(scN.nextInt());
					
					System.out.println("Alteração efetuada com sucesso.");
				}
				else
					System.out.println("Alteração não efetuada.");
			}
			else
				System.out.println("Poisção inválida.");
		}
	}
	
	public void consultar() {
		System.out.println("--==[Consulta de conta corrente]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos;
			
			System.out.println("Qual posição deseja consultar?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < contas.size())){
				System.out.println("-[Dados da conta corrente]-");
				mostrar(contas.get(pos));
			}
			else
				System.out.println("Posição inválida.");
		}
	}
	
	public void relatorio() {
		System.out.println("--==[Relatório de contas ouro]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			for(ContaCorrente o: contas) {
				mostrar(o);
				System.out.println("------------");
			}
		}
	}
	
	public void depositar() {
		System.out.println("--==[Depósito em conta corrente]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos;
			
			System.out.println("Qual a posição da conta para depósito?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < contas.size())) {
				ContaCorrente conta = contas.get(pos);
				mostrar(conta);
				
				System.out.println("Quanto você deseja depositar?");
				if(!conta.depositar(scN.nextFloat()))
					System.out.println("Valor inválido!");
				
				System.out.println("Novo saldo: " + conta.saldo());
			}
			else
				System.out.println("Posição inválida!");
		}
	}
	
	public void sacar() {
		System.out.println("--==[Saque em conta corrente]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos;
			
			System.out.println("Qual a posição da conta para saque?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < contas.size())) {
				ContaCorrente conta = contas.get(pos);
				mostrar(conta);
				
				System.out.println("Quanto você deseja sacar?");
				if(!conta.sacar(scN.nextFloat()))
					System.out.println("Saldo insuficiente!");
				
				System.out.println("Novo saldo: " + conta.saldo());
			}
			else
				System.out.println("Posição inválida!");
		}
	}
	
	public void alterarChequeEspecial() {
		System.out.println("--==[Alterar valor cheque especial]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos;
			
			System.out.println("Qual a posição da conta para alteração?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < contas.size())) {
				ContaCorrente conta = contas.get(pos);
				mostrar(conta);
				
				System.out.println("Valor cheque especial: " + conta.getChequeEspecial());
				System.out.println("Digite o novo valor: ");
				conta.setChequeEspecial(scN.nextFloat());
				
				mostrar(conta);
			}
			System.out.println("Posição inválida!");
		}
	}
	
	public void mostrar(ContaCorrente o) {
		System.out.println("Agência        : " + o.getAgencia());
		System.out.println("Número         : " + o.getNumero());
		System.out.println("Saldo sem c.e. : " + o.saldoSemChequeEspecial());
		if(o.getChequeEspecial() > 0) {
			System.out.println("Cheque especial: " + o.getChequeEspecial());
			System.out.println("Saldo com c.e. : " + o.saldo());
		}
		else {
			System.out.println("Cheque especial: 0.00");
			System.out.println("Saldo com c.e. : " + o.saldoSemChequeEspecial());
		}
	}
}
