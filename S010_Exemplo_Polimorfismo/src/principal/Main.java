package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scN = new Scanner(System.in);
		Scanner scS = new Scanner(System.in);
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		
		int op, opCad, pos, resp;
		
		do {
			System.out.println("--==[Cadastro de Cliente ou Funcionário]==--");
			System.out.println("1 - incluir");
			System.out.println("2 - excluir");
			System.out.println("3 - alterar");
			System.out.println("4 - constultar");
			System.out.println("5 - relatório");
			System.out.println("6 - sair");
			System.out.println("Opção: ");
			op = scN.nextInt();
			
			switch(op) {
				case 1:
					System.out.println("-=[Inclusão]=-");
					System.out.println("Escolha uma opção: 1 - Cliente / 2 - Funcionário");
					opCad = scN.nextInt();
					
					System.out.println("Digite os seguinte dados:");
					switch(opCad){
						case 1:
							Cliente c = new Cliente();
							System.out.println("Nome: ");
							c.setNome(scS.nextLine());
							System.out.println("Idade: ");
							c.setIdade(scN.nextInt());
							System.out.println("Tipo cliente (1-comum/2-especial): ");
							c.setTipoCliente(scN.nextInt());
							
							pessoas.add(c);
							break;
						case 2:
							Funcionario f = new Funcionario();
							System.out.println("Nome: ");
							f.setNome(scS.nextLine());
							System.out.println("Idade: ");
							f.setIdade(scN.nextInt());
							System.out.println("Salário: ");
							f.setSalario(scN.nextFloat());
							
							pessoas.add(f);
							break;
					}
					System.out.println("Cadastro ocorrido com sucesso.");
					break;
				case 2:
					System.out.println("-=[Exclusão]=-");
					System.out.println("Qual posição deseja excluir?");
					pos = scN.nextInt();
					
					mostrar(pessoas.get(pos));
					System.out.println("Confirma exclusão? (1-sim/2-não)");
					resp = scN.nextInt();
					
					if(resp == 1) {
						pessoas.remove(pos);
						System.out.println("Exlcusão efetuada com sucesso.");
					}
					else {
						System.out.println("Exlcusão não efetuada.");
					}
					break;
				case 3:
					System.out.println("-=[Alteração]=-");
					System.out.println("Qual posição deseja alterar?");
					pos = scN.nextInt();
					
					mostrar(pessoas.get(pos));
					System.out.println("Confirma alteração? (1-sim/2-não)");
					resp = scN.nextInt();
					
					if(resp == 1) {
						
						System.out.println("Digite os seguinte dados:");
						
						if(pessoas.get(pos) instanceof Cliente) {
							Cliente c = (Cliente) pessoas.get(pos);
							
							System.out.println("Nome: ");
							c.setNome(scS.nextLine());
							System.out.println("Idade: ");
							c.setIdade(scN.nextInt());
							System.out.println("Tipo cliente (1-comum/2-especial): ");
							c.setTipoCliente(scN.nextInt());
						}		
						else {
							Funcionario f = (Funcionario) pessoas.get(pos);
							
							System.out.println("Nome: ");
							f.setNome(scS.nextLine());
							System.out.println("Idade: ");
							f.setIdade(scN.nextInt());
							System.out.println("Salário: ");
							f.setSalario(scN.nextFloat());
						}
						
						System.out.println("Alteração efetuada com sucesso.");
					}
					else {
						System.out.println("Alteração não efetuada.");
					}
					break;
				case 4:
					System.out.println("-=[Consulta]=-");
					System.out.println("Qual posição deseja consultar?");
					pos = scN.nextInt();
					
					mostrar(pessoas.get(pos));
					break;
				case 5:
					System.out.println("-=[Relatório]=-");
					
					for(Pessoa p: pessoas) {
						mostrar(p);
						System.out.println("--------------");
					}
			}
		}while(op != 6);
		
		scN.close();
		scS.close();
	}
	
	private static void mostrar(Pessoa p) {
		System.out.println("Nome        : " + p.getNome());
		System.out.println("Idade       : " + p.getIdade());
		
		if(p instanceof Cliente) {
			Cliente c = (Cliente) p;
			System.out.println("Tipo cliente: " + 
					(c.getTipoCliente() == 1 ? "1 - comum" : "2 - especial"));
		}
		else {
			Funcionario f = (Funcionario)p;
			System.out.println("Salário     : " + f.getSalario());
		}
	}
}
