package principal;

public class Main {

	public static void main(String[] args) {
		Cliente cliA, cliB;
		
		cliA = new Cliente(1, "Luiza");
		cliA.atualizaSistuacao(true);
		cliB = new Cliente(2, "Wesley");
		
		if(!cliA.atualizaLimite(500))
			System.out.println("Este não é um cliente especial.");
		
		cliB = cliA;
		cliB.atualizaSistuacao(false);
		
		if(!cliA.atualizaLimite(700))
			System.out.println("Este não é um cliente especial.");
	}
}
