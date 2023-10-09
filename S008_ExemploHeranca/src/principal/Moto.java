package principal;

public class Moto extends Veiculo{
	private int cilindradas;

	public Moto() {
		super();
	}

	public Moto(int cilindradas, String marca, String modelo, int anoFabricacao, 
			int anoModelo, float preco) {
		super(marca, modelo, anoFabricacao, anoModelo, preco);
		this.cilindradas = cilindradas;
	}

	public int getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}
}
