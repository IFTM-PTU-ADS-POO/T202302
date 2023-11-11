package principal;

public class Funcionario extends Pessoa {
	
	private float salario;

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, int idade, float sal) {
		super(nome, idade);
		salario = sal;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
}
