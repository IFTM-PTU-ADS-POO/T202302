package principal;

public class Funcionario {
	private String cpf;
	private String nome;
	private float salario;
	private Filho filhos[];
	
	public Funcionario() {
		filhos = new Filho[10];
	}

	public Funcionario(String cpf, String nome, float salario) {
		this.cpf = cpf;
		this.nome = nome;
		this.salario = salario;
		filhos = new Filho[10];
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Filho[] getFilhos() {
		return filhos;
	}

	public void setFilhos(Filho[] filhos) {
		this.filhos = filhos;
	}
	
	public Filho getFilho(int posNoVetorDeFilhos) {
		if(filhos[posNoVetorDeFilhos] != null)
			return filhos[posNoVetorDeFilhos];
		else
			return null;
	}
	
	/**
	 * Esta função retorna: -1 se não houver posições vazias no vetor ou
	 * o número da posição que estiver vazia.
	 * 
	 * @return -1 ou número da posição vazia
	 */
	public int getPosicaoVaziaNoVetorFilhos() {
		int pos = -1, i = 0;
		
		while((i < filhos.length) && (pos == -1)) {
			if(filhos[i] == null)
				pos = i;
			else
				i++;
		}
		
		return pos;
	}
	
	public boolean setFilho(Filho filho) {
		int pos = getPosicaoVaziaNoVetorFilhos();
		
		if(pos != -1) {
			filhos[pos] = filho;
			return true;
		}
		else
			return false;
	}
}
