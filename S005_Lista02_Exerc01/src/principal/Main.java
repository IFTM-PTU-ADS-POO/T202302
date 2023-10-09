package principal;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Livro livros[] = new Livro[300];
		Scanner scN = new Scanner(System.in);
		Scanner scS = new Scanner(System.in);
		
		int op, posicao, resp;
		boolean achou;
		
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
					achou = false;
					int posVazia = 0;
					while((!achou) && (posVazia < livros.length)) {
						if(livros[posVazia] == null)
							achou = true;
						else
							posVazia++;
					}
					
					if(posVazia < livros.length) {
						Livro livro = new Livro();
						
						System.out.println("-=[Inlcusão]=-");
						System.out.println("-[Digite os dados do livro]-");
						System.out.println("- título: ");
						livro.setTitulo(scS.nextLine());
						System.out.println("- autor: ");
						livro.setAutor(scS.nextLine());
						System.out.println("- editora: ");
						livro.setEditora(scS.nextLine());
						System.out.println("- ano de publicação: ");
						livro.setAnoDaPublicacao(scN.nextInt());
						System.out.println("- edição: ");
						livro.setEdicao(scN.nextInt());
						System.out.println("- ISBN: ");
						livro.setIsbn(scS.nextLine());

						livros[posVazia] = livro;
						
						System.out.println("Livro cadastrado com sucesso.");
					}
					else
						System.out.println("Vetor cheio.");
					break;
				case 2:  // Exclusão
					if(existeCadastro(livros)) {
						System.out.println("-=[Exlcusão]=-");
						System.out.println("-[Digite a posição que deseja excluir]-");
						posicao = scN.nextInt();
						
						if((posicao >= 0) && (posicao < livros.length)) {
							if(livros[posicao] == null)
								System.out.println("Não existe livro cadastrado nesta posição.");
							else {
								System.out.println("-[Livro cadastrado]-");
								mostrar(livros[posicao]);
								
								System.out.println("Confirma a exclusão? (1-sim/2-não)");
								resp = scN.nextInt();
								
								if(resp == 1) {
									livros[posicao] = null;
									System.out.println("Exclusão efetuada com sucesso.");
								}
								else
									System.out.println("Exclusão não efetuada.");
							}
						}
						else
							System.out.println("Posição inválida.");
					}
					else
						System.out.println("Vetor vazio.");
					break;
				case 3:  // Alteração
					if(existeCadastro(livros)) {
						System.out.println("-=[Alteração]=-");
						System.out.println("-[Digite a posição que deseja alterar]-");
						posicao = scN.nextInt();
						
						if((posicao >= 0) && (posicao < livros.length)) {
							if(livros[posicao] == null)
								System.out.println("Não existe livro cadastrado nesta posição.");
							else {
								System.out.println("-[Livro cadastrado]-");
								mostrar(livros[posicao]);
								
								System.out.println("Confirma a alteração? (1-sim/2-não)");
								resp = scN.nextInt();
								
								if(resp == 1) {
									System.out.println("-[Digite os dados do livro]-");
									System.out.println("- título: ");
									livros[posicao].setTitulo(scS.nextLine());
									System.out.println("- autor: ");
									livros[posicao].setAutor(scS.nextLine());
									System.out.println("- editora: ");
									livros[posicao].setEditora(scS.nextLine());
									System.out.println("- ano de publicação: ");
									livros[posicao].setAnoDaPublicacao(scN.nextInt());
									System.out.println("- edição: ");
									livros[posicao].setEdicao(scN.nextInt());
									System.out.println("- ISBN: ");
									livros[posicao].setIsbn(scS.nextLine());
									
									System.out.println("Alteração efetuada com sucesso.");
								}
								else
									System.out.println("Alteração não efetuada.");
							}
						}
						else
							System.out.println("Posição inválida.");
					}
					else
						System.out.println("Vetor vazio.");
					break;
				case 4:  // Consulta
					if(existeCadastro(livros)) {
						System.out.println("-=[Consulta]=-");
						System.out.println("-[Digite a posição que deseja consultar]-");
						posicao = scN.nextInt();
						
						if((posicao >= 0) && (posicao < livros.length)) {
							if(livros[posicao] == null)
								System.out.println("Não existe livro cadastrado nesta posição.");
							else {
								System.out.println("-[Livro cadastrado]-");
								mostrar(livros[posicao]);
							}
						}
						else
							System.out.println("Posição inválida.");
					}
					else
						System.out.println("Vetor vazio.");
					break;
				case 5:  // relatório
					if(existeCadastro(livros)) {
						System.out.println("-=[Relatório]=-");
						for(int i = 0; i < livros.length; i++)
							if(livros[i] != null) {
								mostrar(livros[i]);
								System.out.println("---------------");
							}
					}
					else
						System.out.println("Vetor vazio.");
			}
		}while(op != 6);
		
		scN.close();
		scS.close();
	}
	
	public static boolean existeCadastro(Livro[] livros) {
		int posCheia = 0;
		boolean achou = false;
		while((!achou) && (posCheia < livros.length)) {
			if(livros[posCheia] != null) {
				achou = true;
			}
			posCheia++;
		}
		
		return achou;
	}

	public static void mostrar(Livro livro) {
		System.out.println("- título           : " + livro.getTitulo());
		System.out.println("- autor            : " + livro.getAutor());
		System.out.println("- editora          : " + livro.getEditora());
		System.out.println("- ano de publicação: " + livro.getAnoDaPublicacao());
		System.out.println("- edição           : " + livro.getEdicao());
		System.out.println("- ISBN             : " + livro.getIsbn());
	}
}
