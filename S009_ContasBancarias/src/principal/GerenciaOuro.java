package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaOuro {
	private Scanner scN;
	private ArrayList<Ouro> contas;
	
	public GerenciaOuro(ArrayList<Ouro> cts) {
		contas = cts;
		scN = new Scanner(System.in);
	}
	
	public void incluir() {
		
		System.out.println("--==[Criação conta ouro]==--");
		System.out.println("- Digite o CPF: ");
		long cpf = scN.nextLong();
		
		Ouro ouro = new Ouro(cpf);
		
		contas.add(ouro);
		
		System.out.println("Conta ativada com sucesso.");
	}
	
	public void excluir() {
		System.out.println("--==[Exclusão de conta ouro]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos, resp;
			
			System.out.println("Qual posição deseja excluir?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < contas.size())){
				System.out.println("-[Dados da conta ouro]-");
				
				Ouro con = contas.get(pos); 
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
		System.out.println("--==[Alteração de conta ouro]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos, resp;
			
			System.out.println("Qual posição deseja alterar?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < contas.size())){
				System.out.println("-[Dados da conta ouro]-");
				mostrar(contas.get(pos));

				System.out.println("Confirma a alteração? (1-sim/2-não)");
				resp = scN.nextInt();
				
				if(resp == 1) {
					System.out.println("- Digite os novos dados:");
					System.out.println("- CPF: ");
					contas.get(pos).setCpf(scN.nextLong());
					
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
		System.out.println("--==[Consulta de conta ouro]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos;
			
			System.out.println("Qual posição deseja consultar?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < contas.size())){
				System.out.println("-[Dados da conta ouro]-");
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
			for(Ouro o: contas) {
				mostrar(o);
				System.out.println("------------");
			}
		}
	}
	
	public void depositar() {
		System.out.println("--==[Depósito em conta ouro]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos;
			
			System.out.println("Qual a posição da conta para depósito?");
			pos = scN.nextInt();

			if((pos >= 0) && (pos < contas.size())) {
				Ouro conta = contas.get(pos);
				mostrar(conta);
				
				System.out.println("Quantos gramas você deseja depositar?");
				if(!conta.depositar(scN.nextFloat()))
					System.out.println("Valor inválido!");
				
				System.out.println("Novo saldo: " + conta.saldo());
			}
			else
				System.out.println("Posição inválida!");
		}
	}
	
	public void sacar() {
		System.out.println("--==[Saque em conta ouro]==--");
		if(contas.size() == 0)
			System.out.println("Não existem contas cadastradas.");
		else {
			int pos;
			
			System.out.println("Qual a posição da conta para saque?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < contas.size())) {
				Ouro conta = contas.get(pos);
				mostrar(conta);
				
				System.out.println("Quantos gramas você deseja sacar?");
				if(!conta.sacar(scN.nextFloat()))
					System.out.println("Saldo insuficiente!");
				
				System.out.println("Novo saldo: " + conta.saldo());
			}
			else
				System.out.println("Posição inválida!");
		}
	}
	
	public void mostrar(Ouro o) {
		System.out.println("CPF            : " + o.getCpf());
		System.out.println("Saldo em gramas: " + o.saldo());
	}
}
