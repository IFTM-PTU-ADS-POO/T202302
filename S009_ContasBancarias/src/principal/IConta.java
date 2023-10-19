package principal;

public interface IConta {
	boolean depositar(float valor);
	boolean sacar(float valor);
	float saldo();
}
