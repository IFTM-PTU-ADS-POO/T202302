package principal;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final int TAM = 100;
		
		int[] vet1, vet2, vet3;
		vet1 = new int[TAM];
		vet2 = new int[TAM];
		vet3 = new int[TAM];
		
		for(int i = 0; i < vet1.length; i++) {
			System.out.println("Digite um valor inteiro: ");
			vet1[i] = sc.nextInt();
		}
		
		for(int i = 0; i < vet2.length; i++) {
			System.out.println("Digite um valor inteiro: ");
			vet2[i] = sc.nextInt();
		}
		
		for(int i = 0; i < vet3.length; i++) {
			vet3[i] = vet1[i] * vet2[TAM-1-i];
		}
		
		System.out.println("--[Resultados]--");
		for(int i = (TAM-1); i >= 0; i--) {
			System.out.println(i + " - " + vet3[i]);
		}
		
		sc.close();
	}

}
