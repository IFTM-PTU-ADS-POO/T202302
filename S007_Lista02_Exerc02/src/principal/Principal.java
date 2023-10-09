package principal;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Funcionario funcs[] = new Funcionario[50];
		GerenciaFuncionario genFuncs = new GerenciaFuncionario(funcs);
		GerenciaFilhos genFilhos = new GerenciaFilhos(funcs);
		
		int op, opFi, opFu;
		
		do {
			System.out.println("---==[Cadastro Funcionário x Filhos]==---");
			System.out.println("1 - Funcionário");
			System.out.println("2 - Filho");
			System.out.println("3 - Sair");
			System.out.println("Opção: ");
			op = sc.nextInt();
			
			switch(op) {
				case 1:  // Funcionário
					do {
						System.out.println("-=[Cadastro de Funcionário]=-");
						System.out.println("1 - Inclusão");
						System.out.println("2 - Exclusão");
						System.out.println("3 - Alteração");
						System.out.println("4 - Consulta");
						System.out.println("5 - Relatório de Funcionários");
						System.out.println("6 - Relatório de Funcionários e Filhos");
						System.out.println("7 - Voltar ao menu principal");
						System.out.println("Opção: ");
						opFu = sc.nextInt();
						
						switch(opFu) {
							case 1: // Inclusão
								genFuncs.incluir();
								break;
							case 2: // Exclusão
								genFuncs.excluir();
								break;
							case 3: // Alteração
								genFuncs.alterar();
								break;
							case 4: // Consulta
								genFuncs.consultar();
								break;
							case 5: // Relatório de Funcionários
								genFuncs.relatorioDeFuncionarios();
								break;
							case 6: // Relatório de Funcioários e Filhos
								genFuncs.relatorioDeFuncionariosFilhos();
								break;
							default:
								if(opFu != 7)
									System.out.println("Opção inálida!");
						}
					}while(opFu != 7);
					break;
				case 2:  // Filho
					do {
						System.out.println("-=[Cadastro de Filho]=-");
						System.out.println("1 - Inclusão");
						System.out.println("2 - Exclusão");
						System.out.println("3 - Alteração");
						System.out.println("4 - Consulta");
						System.out.println("5 - Voltar ao menu principal");
						System.out.println("Opção: ");
						opFi = sc.nextInt();
						
						switch(opFi) {
							case 1: // Inclusão
								genFilhos.incluir();
								break;
							case 2: // Exclusão
								genFilhos.excluir();
								break;
							case 3: // Alteração
								genFilhos.alterar();
								break;
							case 4: // Consulta
								genFilhos.consultar();
								break;
							default:
								if(opFi != 5)
									System.out.println("Opção inálida!");
						}
					}while(opFi != 5);
					break;
			}
		}while(op != 3);
		
		sc.close();
	}

}
