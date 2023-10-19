package principal;

public class Poupanca extends Conta {
	private int diaAniversario;

	public Poupanca(int agencia, int numero, int diaAniversario) {
		super(agencia, numero);
		this.diaAniversario = diaAniversario;
	}
	
	public boolean sacar(float valor) {
		if((saldo - valor) >= 0) {
			saldo -= valor;
			return true;
		}
		else
			return false;
	}

	public float saldo() {
		return saldo;
	}

	public int getDiaAniversario() {
		return diaAniversario;
	}

	public void setDiaAniversario(int diaAniversario) {
		this.diaAniversario = diaAniversario;
	}
}
