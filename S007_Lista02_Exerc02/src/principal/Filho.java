package principal;

public class Filho {
	private String cpf;
	private String nome;
	private String numCertNasc;
	private String dataNascimento;
	
	public Filho() {}

	public Filho(String cpf, String nome, String numCertNasc, 
			String dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.numCertNasc = numCertNasc;
		this.dataNascimento = dataNascimento;
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

	public String getNumCertNasc() {
		return numCertNasc;
	}

	public void setNumCertNasc(String numCertNasc) {
		this.numCertNasc = numCertNasc;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
