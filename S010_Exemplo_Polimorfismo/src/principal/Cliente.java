package principal;

public class Cliente extends Pessoa {
	private int tipoCliente;

	public Cliente() {
		super();
	}

	public Cliente(String nome, int idade, int tc) {
		super(nome, idade);
		tipoCliente = tc;
	}

	public int getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(int tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
}
