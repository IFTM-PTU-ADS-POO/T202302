package principal;

import java.util.Scanner;

public class GerenciaFilhos {
	private Funcionario funcs[];
	private Scanner scN;
	private Scanner scS;
	
	public GerenciaFilhos(Funcionario[] funcios) {
		funcs = funcios;
		scN = new Scanner(System.in);
		scS = new Scanner(System.in);
	}
	
	public void incluir() {
		if(existeAlgumCadastro()) {
			int pos;
			
			System.out.println("Qual a posição do funcionário que você deseja "
					+ "cadastrar filho(s)?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < funcs.length) && (funcs[pos] != null)) {
				System.out.println("-[Dados do funcionário]-");
				imprimeFuncionario(funcs[pos]);

				int posVaziaNoVetorDeFilhos = funcs[pos].getPosicaoVaziaNoVetorFilhos();
				if(posVaziaNoVetorDeFilhos != -1) {
					Filho filho = new Filho();
					System.out.println("Digite os dados do novo filho: ");
					System.out.println(" - Nome                  : ");
					filho.setNome(scS.nextLine());
					System.out.println(" - CPF                   : ");
					filho.setCpf(scS.nextLine());
					System.out.println(" - Certidão de Nascimento: ");
					filho.setNumCertNasc(scS.nextLine());
					System.out.println(" - Data de Nascimento    : ");
					filho.setDataNascimento(scS.nextLine());
					
					funcs[pos].getFilhos()[posVaziaNoVetorDeFilhos] = filho;					
					
					System.out.println("Filho cadastrado com sucesso.");
				}
				else
					System.out.println("Vetor de filhos já está cheio.");
			}
			else
				System.out.println("Posição inválida!");
		}
		else
			System.out.println("Não existem funcionários cadastrados.");
	}
	
	public void excluir() {
		if(existeAlgumCadastro()) {
			int pos, posFilho;
			
			System.out.println("Qual a posição do funcionário que você deseja "
					+ "excluir filho(s)?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < funcs.length) && (funcs[pos] != null)) {
				System.out.println("-[Dados do funcionário]-");
				imprimeFuncionario(funcs[pos]);
				System.out.println("Filhos----------------");
				for(int i = 0; i < funcs[pos].getFilhos().length; i++) {
					Filho f = funcs[pos].getFilho(i);
					if(f != null) {
						System.out.println("Código: " + (i + 1));
						imprimeFilho(f);
						System.out.println("---------");
					}
				}
				
				System.out.println("Qual o código do filho que você deseja excluir?");
				posFilho = scN.nextInt();
				posFilho--;
				
				if((posFilho >= 0) && (posFilho < funcs[pos].getFilhos().length)
						&& (funcs[pos].getFilho(posFilho) != null)) {
					funcs[pos].getFilhos()[posFilho] = null;
					System.out.println("Filho excluído com sucesso.");
				}
				else
					System.out.println("Filho não excluído.");
			}
			else
				System.out.println("Posição inválida!");
		}
		else
			System.out.println("Não existem funcionários cadastrados.");
	}
	
	public void alterar() {
		if(existeAlgumCadastro()) {
			int pos, posFilho;
			
			System.out.println("Qual a posição do funcionário que você deseja "
					+ "alterar filho?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < funcs.length) && (funcs[pos] != null)) {
				System.out.println("-[Dados do funcionário]-");
				imprimeFuncionario(funcs[pos]);
				System.out.println("Filhos----------------");
				for(int i = 0; i < funcs[pos].getFilhos().length; i++) {
					Filho f = funcs[pos].getFilho(i);
					if(f != null) {
						System.out.println("Código: " + (i + 1));
						imprimeFilho(f);
						System.out.println("---------");
					}
				}
				
				System.out.println("Qual o código do filho que você deseja alterar?");
				posFilho = scN.nextInt();
				posFilho--;
				
				if((posFilho >= 0) && (posFilho < funcs[pos].getFilhos().length)
						&& (funcs[pos].getFilho(posFilho) != null)) {
					Filho filho = funcs[pos].getFilhos()[posFilho];
					
					System.out.println("Digite os novos dados do filho: ");
					System.out.println(" - Nome                  : ");
					filho.setNome(scS.nextLine());
					System.out.println(" - CPF                   : ");
					filho.setCpf(scS.nextLine());
					System.out.println(" - Certidão de Nascimento: ");
					filho.setNumCertNasc(scS.nextLine());
					System.out.println(" - Data de Nascimento    : ");
					filho.setDataNascimento(scS.nextLine());
					
					System.out.println("Filho alterado com sucesso.");
				}
				else
					System.out.println("Filho não alterado.");
			}
			else
				System.out.println("Posição inválida!");
		}
		else
			System.out.println("Não existem funcionários cadastrados.");
	}
	
	public void consultar() {
		if(existeAlgumCadastro()) {
			int pos;
			
			System.out.println("Qual a posição do funcionário que você deseja "
					+ "consultar o(s) filho(s)?");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < funcs.length) && (funcs[pos] != null)) {
				System.out.println("-[Dados do funcionário]-");
				imprimeFuncionario(funcs[pos]);
				System.out.println("Filhos----------------");
				for(int i = 0; i < funcs[pos].getFilhos().length; i++) {
					Filho f = funcs[pos].getFilho(i);
					if(f != null) {
						System.out.println("Código: " + (i + 1));
						imprimeFilho(f);
						System.out.println("---------");
					}
				}
			}
			else
				System.out.println("Posição inválida!");
		}
		else
			System.out.println("Não existem funcionários cadastrados.");
	}
	
	private void imprimeFilho(Filho f) {
		System.out.println("Nome               : " + f.getNome());
		System.out.println("CPF                : " + f.getCpf());
		System.out.println("Certidão Nascimento: " + f.getNumCertNasc());
		System.out.println("Data nascimento    : " + f.getDataNascimento());
	}
	
	private boolean existeAlgumCadastro() {
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i < funcs.length)) {
			if(funcs[i] != null)
				achou = true;
			else
				i++;
		}
		
		return achou;
	}
	
	private void imprimeFuncionario(Funcionario f) {
		System.out.println("Nome   : " + f.getNome());
		System.out.println("CPF    : " + f.getCpf());
		System.out.println("Salário: " + f.getSalario());
	}
}
