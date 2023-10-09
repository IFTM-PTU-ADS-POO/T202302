package principal;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner scS = new Scanner(System.in);
		
		// constante
		final int TAM = 2; 
		
		Veiculo veiculos[][] = new Veiculo[TAM][TAM];
		
		for(int i = 0; i < TAM; i++)
			for(int j = 0; j < TAM; j++) {
				Veiculo veiculo = new Veiculo();
				
				System.out.println("Digite a marca: ");
				veiculo.setMarca(scS.nextLine());
				System.out.println("Digite o modelo: ");
				veiculo.setModelo(scS.nextLine());
				System.out.println("Digite o ano de fabricação: ");
				veiculo.setAnoFabricacao(sc.nextInt());
				
				veiculos[i][j] = veiculo;		
			}
		
		
		System.out.println("---==[Veículos digitados]==---");
		for(int i = (TAM-1); i >= 0; i--)
			for(int j = (TAM-1); j >= 0; j--) {
				System.out.println("Marca         : " + veiculos[i][j].getMarca());
				System.out.println("Modelo        : " + veiculos[i][j].getModelo());
				System.out.println("Ano fabricação: " + veiculos[i][j].getAnoFabricacao());
				System.out.println("----------------------");
			}
		
		sc.close();
		scS.close();
	}

}
