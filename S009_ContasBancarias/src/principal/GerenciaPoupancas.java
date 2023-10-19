package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaPoupancas {
	private Scanner scN;
	private ArrayList<Poupanca> contas;
	
	public GerenciaPoupancas(ArrayList<Poupanca> cts) {
		contas = cts;
		scN = new Scanner(System.in);
	}
	
	public void incluir() {
		
		System.out.println("--==[Criação conta poupança]==--");
		System.out.println("- Digite o número da agência: ");
		int ag = scN.nextInt();
		System.out.println("- Digite o número da conta: ");
		int con = scN.nextInt();
		System.out.println("- Digite a dia de aniversário: ");
		int aniv = scN.nextInt();
		
		Poupanca pp = new Poupanca(ag,con, aniv);
		
		contas.add(pp);
		
		System.out.println("Conta ativada com sucesso.");
	}
	
	public void excluir() {
		System.out.println("--==[Exclusão de conta poupança]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos, resp;
			
			System.out.println("Qual posição deseja excluir?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < contas.size())){
				System.out.println("-[Dados da conta poupança]-");
				Poupanca con = contas.get(pos); 
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
		System.out.println("--==[Alteração de conta poupança]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos, resp;
			
			System.out.println("Qual posição deseja alterar?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < contas.size())){
				System.out.println("-[Dados da conta poupança]-");
				mostrar(contas.get(pos));

				System.out.println("Confirma a alteração? (1-sim/2-não)");
				resp = scN.nextInt();
				
				if(resp == 1) {
					System.out.println("- Digite os novos dados:");
					System.out.println("- número da agência: ");
					contas.get(pos).setAgencia(scN.nextInt());
					System.out.println("- número da conta: ");
					contas.get(pos).setNumero(scN.nextInt());
					System.out.println("- aniversário: ");
					contas.get(pos).setDiaAniversario(scN.nextInt());
					
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
		System.out.println("--==[Consulta de conta poupança]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos;
			
			System.out.println("Qual posição deseja consultar?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < contas.size())){
				System.out.println("-[Dados da conta poupança]-");
				mostrar(contas.get(pos));
			}
			else
				System.out.println("Posição inválida.");
		}
	}
	
	public void relatorio() {
		System.out.println("--==[Relatório de contas poupança]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			for(Poupanca o: contas) {
				mostrar(o);
				System.out.println("------------");
			}
		}
	}
	
	public void depositar() {
		System.out.println("--==[Depósito em conta poupança]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos;
			
			System.out.println("Qual a posição da conta para depósito?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < contas.size())) {
				Poupanca conta = contas.get(pos);
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
		System.out.println("--==[Saque em conta poupança]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos;
			
			System.out.println("Qual a posição da conta para saque?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < contas.size())) {
				Poupanca conta = contas.get(pos);
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
	
	public void mostrar(Poupanca o) {
		System.out.println("Agência    : " + o.getAgencia());
		System.out.println("Número     : " + o.getNumero());
    	System.out.println("Aniversário: " + o.getDiaAniversario());
		System.out.println("Saldo      : " + o.saldo());
	}
}
