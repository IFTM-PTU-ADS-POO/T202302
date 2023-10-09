package principal;

import java.util.Scanner;

public class GerenciaLivros {
	private Scanner scN;
	private Scanner scS;
	private Livro[] livros;
	
	public GerenciaLivros(Livro[] liv) {
		scN = new Scanner(System.in);
		scS = new Scanner(System.in);
		livros = liv;
	}
	
	public void incluir() {
		boolean achou = false;
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
	}
	
	public void excluir() {
		if(existeCadastro(livros)) {
			System.out.println("-=[Exlcusão]=-");
			System.out.println("-[Digite a posição que deseja excluir]-");
			int posicao = scN.nextInt();
			
			if((posicao >= 0) && (posicao < livros.length)) {
				if(livros[posicao] == null)
					System.out.println("Não existe livro cadastrado nesta posição.");
				else {
					System.out.println("-[Livro cadastrado]-");
					mostrar(livros[posicao]);
					
					System.out.println("Confirma a exclusão? (1-sim/2-não)");
					int resp = scN.nextInt();
					
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

	}
	
	public void alterar() {
		if(existeCadastro(livros)) {
			System.out.println("-=[Alteração]=-");
			System.out.println("-[Digite a posição que deseja alterar]-");
			int posicao = scN.nextInt();
			
			if((posicao >= 0) && (posicao < livros.length)) {
				if(livros[posicao] == null)
					System.out.println("Não existe livro cadastrado nesta posição.");
				else {
					System.out.println("-[Livro cadastrado]-");
					mostrar(livros[posicao]);
					
					System.out.println("Confirma a alteração? (1-sim/2-não)");
					int resp = scN.nextInt();
					
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
	}
	
	public void consultar() {
		if(existeCadastro(livros)) {
			System.out.println("-=[Consulta]=-");
			System.out.println("-[Digite a posição que deseja consultar]-");
			int posicao = scN.nextInt();
			
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
	}
	
	public void relatorio() {
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
	
	private boolean existeCadastro(Livro[] livros) {
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

	private void mostrar(Livro livro) {
		System.out.println("- título           : " + livro.getTitulo());
		System.out.println("- autor            : " + livro.getAutor());
		System.out.println("- editora          : " + livro.getEditora());
		System.out.println("- ano de publicação: " + livro.getAnoDaPublicacao());
		System.out.println("- edição           : " + livro.getEdicao());
		System.out.println("- ISBN             : " + livro.getIsbn());
	}
}
