package principal;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Livro livros[] = new Livro[300];
		Scanner scN = new Scanner(System.in);
		Scanner scS = new Scanner(System.in);
		GerenciaLivros gerLivros = new GerenciaLivros(livros);
		
		int op;
		
		do {
			System.out.println("--==[Cadastro de Livros]==--");
			System.out.println("1 - Inclusão");
			System.out.println("2 - Exclusão");
			System.out.println("3 - Alteração");
			System.out.println("4 - Consulta");
			System.out.println("5 - Relatório");
			System.out.println("6 - Sair");
			System.out.println("Opção: ");
			op = scN.nextInt();
			
			switch(op) {
				case 1:  // Inclusão
					gerLivros.incluir();
					break;
				case 2:  // Exclusão
					gerLivros.excluir();
					break;
				case 3:  // Alteração
					gerLivros.alterar();
					break;
				case 4:  // Consulta
					gerLivros.consultar();
					break;
				case 5:  // relatório
					gerLivros.relatorio();
			}
		}while(op != 6);
		
		scN.close();
		scS.close();
	}
}
