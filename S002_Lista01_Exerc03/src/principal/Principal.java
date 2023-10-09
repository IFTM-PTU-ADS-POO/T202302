package principal;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// Objeto para ler valores do teclado.
		Scanner sc = new Scanner(System.in);
		
		// Vetor de objetos Pessoa
		Pessoa pessoas[] = new Pessoa[10];
		
		for(int i = 0; i < pessoas.length; i++) {
			// Instanciando um objeto do tipo Pessoa
			Pessoa pessoa = new Pessoa();
			
			// Ler os dados do teclado.
			System.out.println("Digite o nome da pessoa: ");
			String nome = sc.nextLine();
			pessoa.setNome(nome);
			
			System.out.println("Digite a idade da pessoa: ");
			pessoa.setIdade(sc.nextInt());
			sc.skip("\n");
			
			// Colocar o objeto denro do vetor.
			pessoas[i] = pessoa;	
		}
		
		System.out.println("--==[Pessoas cadastradas]==--");
		for(int i = pessoas.length - 1; i >= 0; i--) {
			System.out.println((i + 1) + " - nome: " + pessoas[i].getNome());
			System.out.println((i + 1) + " - idade: " + pessoas[i].getIdade());
		}
		
		sc.close();
	}

}
