package principal;

public class ContaCorrente extends Conta {
	
	private float chequeEspecial;

	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);
		chequeEspecial = 0;
	}

	public ContaCorrente(int agencia, int numero, float ce) {
		super(agencia, numero);
		chequeEspecial = ce;
	}
	
	public boolean sacar(float valor) {
		if(((saldo + chequeEspecial) - valor) >= 0) {
			saldo -= valor;
			return true;
		}
		else
			return false;
	}

	public float saldo() {
		return saldo + chequeEspecial;
	}
	
	public float saldoSemChequeEspecial() {
		return saldo;
		// Poderia ser assim também.
		// return super.saldo();
	}

	public float getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(float chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}
}
