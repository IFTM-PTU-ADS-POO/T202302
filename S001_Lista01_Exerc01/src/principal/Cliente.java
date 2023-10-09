package principal;

public class Cliente {
	private int codigo;
	private String nome;
	private boolean eClienteEspecial;
	private double limiteCredito;
	
	public Cliente(int c, String n) {
		codigo = c;
		nome = n;
		limiteCredito = 0;
		eClienteEspecial = false;
	}
	
	public String obterNome() {
		return nome;
	}
	
	public boolean atualizaLimite(double valor) {
		if(eClienteEspecial) {
			limiteCredito = valor;
			return true;
		}
		else
			return false;
	}
	
	public void atualizaSistuacao(boolean sit) {
		eClienteEspecial = sit;
		
		if(!sit)
			limiteCredito = 0;
	}
}
