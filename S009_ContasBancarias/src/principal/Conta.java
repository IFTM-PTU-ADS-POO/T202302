package principal;

public abstract class Conta implements IConta {
	private int agencia;
	private int numero;
	protected float saldo;
	
	public Conta(int agencia, int numero) {
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = 0;
	}
	
	@Override
	public boolean depositar(float valor) {
		if(valor > 0) {
			saldo += valor;
			return true;
		}
		else
			return false;
	}
	
	@Override
	public boolean sacar(float valor) {
		if((saldo - valor) >= 0) {
			saldo -= valor;
			return true;
		}
		else
			return false;
	}
	
	@Override
	public float saldo() {
		return saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
