package principal;

public class Ouro implements IConta {
	private long cpf;
	private float gramasDeOuro;
	
	public Ouro(long cpf) {
		this.cpf = cpf;
		gramasDeOuro = 0;
	}

	@Override
	public boolean depositar(float valor) {
		if(valor > 0) {
			gramasDeOuro += valor;
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean sacar(float valor) {
		if((gramasDeOuro - valor) > 0) {
			gramasDeOuro -= valor;
			return true;
		}
		else
			return false;
	}

	@Override
	public float saldo() {
		return gramasDeOuro;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
}
