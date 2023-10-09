package principal;

import java.util.Scanner;

public class GerenciaFuncionario {
	private Funcionario funcionarios[];
	private Scanner scS;
	private Scanner scN;
	
	public GerenciaFuncionario(Funcionario[] funcs) {
		funcionarios = funcs;
		scS = new Scanner(System.in);
		scN = new Scanner(System.in);
	}
	
	public void incluir() {
		// Procura pela primeira posição vazia do vetor.
		boolean existePosicaoVazia = false;
		int pos = 0;
		while((!existePosicaoVazia) && (pos < funcionarios.length)) {
			if(funcionarios[pos] == null)
				existePosicaoVazia = true;
			else
				pos++;
		}
		
		if(existePosicaoVazia) {
			Funcionario func = new Funcionario();
			
			System.out.println("--=[Inclusão de Funcionário]==--");
			System.out.println("-[Digite os dados a seguir]-");
			System.out.println("- Nome : ");
			func.setNome(scS.nextLine());
			System.out.println("- CPF    : ");
			func.setCpf(scS.nextLine());
			System.out.println("- salário: ");
			func.setSalario(scN.nextFloat());
			
			funcionarios[pos] = func;
			
			System.out.println("Funcionário cadastrado com sucesso.");
		}
		else
			System.out.println("Vetor cheio.");
	}
	
	public void excluir() {
		// Verificar se existem objetos no vetor.
		if(existeAlgumCadastro()) {
			int pos, resp;
			
			System.out.println("Qual posição deseja excluir?");
			pos = scN.nextInt();
			
			/* Testa se a posição existe e se existe um
			 * objeto cadastrado na posição. 
			 */
			if((pos >= 0) && (pos < funcionarios.length) &&
					(funcionarios[pos] != null)) {
				System.out.println("~[Dados do Funcionário]~");
				imprimeFuncionario(funcionarios[pos]);
				System.out.println("Confirma exclusão?(1-sim/2-não)");
				resp = scN.nextInt();
				
				if(resp == 1) {
					funcionarios[pos] = null;
					System.out.println("Exclusão efetivada.");
				}
				else
					System.out.println("Exclusão não efetuada.");
			}
			else
				System.out.println("Posição inválida!");
		}
		else
			System.out.println("Vetor vazio.");
	}
	
	public void alterar() {
		// Verificar se existem objetos no vetor.
		if(existeAlgumCadastro()) {
			int pos, resp;
			
			System.out.println("Qual posição deseja alterar?");
			pos = scN.nextInt();
			
			/* Testa se a posição existe e se existe um
			 * objeto cadastrado na posição. 
			 */
			if((pos >= 0) && (pos < funcionarios.length) &&
					(funcionarios[pos] != null)) {
				System.out.println("~[Dados do Funcionário]~");
				imprimeFuncionario(funcionarios[pos]);
				System.out.println("Confirma alteração?(1-sim/2-não)");
				resp = scN.nextInt();
				
				if(resp == 1) {
					Funcionario func = funcionarios[pos];
					
					System.out.println("-[Digite os novos dados]-");
					System.out.println("- Nome   : ");
					func.setNome(scS.nextLine());
					System.out.println("- CPF    : ");
					func.setCpf(scS.nextLine());
					System.out.println("- salário: ");
					func.setSalario(scN.nextFloat());
					
					System.out.println("Alteração efetivada.");
				}
				else
					System.out.println("Alteração não efetuada.");
			}
			else
				System.out.println("Posição inválida!");
		}
		else
			System.out.println("Vetor vazio.");
		
	}
	
	public void consultar() {
		// Verificar se existem objetos no vetor.
		if(existeAlgumCadastro()) {
			int pos;
			
			System.out.println("Qual posição deseja consultar?");
			pos = scN.nextInt();
			
			/* Testa se a posição existe e se existe um
			 * objeto cadastrado na posição. 
			 */
			if((pos >= 0) && (pos < funcionarios.length) &&
					(funcionarios[pos] != null)) {
				System.out.println("~[Dados do Funcionário]~");
				imprimeFuncionario(funcionarios[pos]);
			}
			else
				System.out.println("Posição inválida!");
		}
		else
			System.out.println("Vetor vazio.");
	}
	
	public void relatorioDeFuncionarios() {
		// Verificar se existem objetos no vetor.
		if(existeAlgumCadastro()) {
			System.out.println("-=[Relatório de Funcionários]=-");
			for(int i = 0; i < funcionarios.length; i++) {
				if(funcionarios[i] != null) {
					imprimeFuncionario(funcionarios[i]);
					System.out.println("------------------");
				}
			}
		}
		else
			System.out.println("Vetor vazio.");
	}
	
	public void relatorioDeFuncionariosFilhos() {
		// Verificar se existem objetos no vetor.
		if(existeAlgumCadastro()) {
			System.out.println("-=[Relatório de Funcionários e Filhos]=-");
			// Percorre o vetor de funcionários
			for(int i = 0; i < funcionarios.length; i++) {
				if(funcionarios[i] != null) {
					imprimeFuncionario(funcionarios[i]);
					
					// testa se existe algum filho no vetor de filhos do funcionário
					if(existeAlgumFilho(funcionarios[i])) {
						System.out.println("Filho(s):--------------------");
						// percorre o vetor de filhos do funcionário.
						for(int j = 0; j < funcionarios[i].getFilhos().length; j++) {
							// testa se existe um filho em posição específica do vetor de filhos
							if(funcionarios[i].getFilho(j) != null) {
								imprimeFilho(funcionarios[i].getFilho(j));
								System.out.println("--------");
							}
						}
					}
					System.out.println("-----------------------------");
				}
			}
		}
		else
			System.out.println("Vetor vazio.");
		
	}
	
	private boolean existeAlgumFilho(Funcionario fun) {
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i < fun.getFilhos().length)) {
			if(fun.getFilho(i) != null)
				achou = true;
			else
				i++;
		}
		
		return achou;
	}
	
	private boolean existeAlgumCadastro() {
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i < funcionarios.length)) {
			if(funcionarios[i] != null)
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
	
	private void imprimeFilho(Filho f) {
		System.out.println("Nome               : " + f.getNome());
		System.out.println("CPF                : " + f.getCpf());
		System.out.println("Certidão Nascimento: " + f.getNumCertNasc());
		System.out.println("Data nascimento    : " + f.getDataNascimento());
	}
}
