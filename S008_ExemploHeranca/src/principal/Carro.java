package principal;

public class Carro extends Veiculo{
	private int capPortaMalas;
	private int qtdPortas;
	private int qtdBancos;
	
	public Carro() {
		super();
	}

	public Carro(String marca, String modelo, int anoFabricacao, int anoModelo, 
			float preco, int capPortaMalas, int qtdPortas, int qtdBancos) {
		super(marca, modelo, anoFabricacao, anoModelo, preco);
		
		this.qtdBancos = qtdBancos;
		this.capPortaMalas = capPortaMalas;
		this.qtdPortas = qtdPortas;
	}

	public int getCapPortaMalas() {
		return capPortaMalas;
	}

	public void setCapPortaMalas(int capPortaMalas) {
		this.capPortaMalas = capPortaMalas;
	}

	public int getQtdPortas() {
		return qtdPortas;
	}

	public void setQtdPortas(int qtdPortas) {
		this.qtdPortas = qtdPortas;
	}

	public int getQtdBancos() {
		return qtdBancos;
	}

	public void setQtdBancos(int qtdBancos) {
		this.qtdBancos = qtdBancos;
	}
}
