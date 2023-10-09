package principal;

public class Caminhao extends Veiculo{
	private float capacidadeDeCarga;

	public Caminhao() {
		super();
	}

	public Caminhao(String marca, String modelo, int anoFabricacao, 
			int anoModelo, float preco, float capCarga) {
		super(marca, modelo, anoFabricacao, anoModelo, preco);
		capacidadeDeCarga = capCarga;
	}

	public float getCapacidadeDeCarga() {
		return capacidadeDeCarga;
	}

	public void setCapacidadeDeCarga(float capacidadeDeCarga) {
		this.capacidadeDeCarga = capacidadeDeCarga;
	}
}
