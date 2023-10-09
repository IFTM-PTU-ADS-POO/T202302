package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaMotos {
	private Scanner scS, scN;
	private ArrayList<Moto> motos;
	
	public GerenciaMotos(ArrayList<Moto> motos) {
		this.scS = new Scanner(System.in);
		this.scN = new Scanner(System.in);
		this.motos = motos;
	}
	
	public void incluir() {
		System.out.println("--=[Incluir Moto]=--");
		Moto moto = new Moto();
		
		System.out.println("Digite os dados a seguir: ");
		System.out.println("- Marca: ");
		moto.setMarca(scS.nextLine());
		System.out.println("- Modelo: ");
		moto.setModelo(scS.nextLine());
		System.out.println("- Ano fabricação: ");
		moto.setAnoFabricacao(scN.nextInt());
		System.out.println("- Ano modelo: ");
		moto.setAnoModelo(scN.nextInt());
		System.out.println("- Cilindradas: ");
		moto.setCilindradas(scN.nextInt());
		System.out.println("- Preço R$");
		moto.setPreco(scN.nextFloat());
		
		motos.add(moto);
		
		System.out.println("Moto inserida com sucesso.");
	}
	
	public void excluir() {
		System.out.println("--=[Excluir Moto]=--");
		
		if(motos.isEmpty())
			System.out.println("Não existem motos cadastradas.");
		else {
			int pos, resp;
			
			System.out.println("Digite a posição que deseja excluir: ");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < motos.size())) {
				System.out.println("-[Dados da Moto]-");
				imprime(motos.get(pos));
				System.out.println("Confirma a exclusão? (1-sim/2-não)");
				resp = scN.nextInt();
				
				if(resp == 1) {
					motos.remove(pos);
					
					System.out.println("Moto excluída com sucesso.");
				}
				else
					System.out.println("Moto não excluída.");
			}
			else
				System.out.println("Posição inválida!");
		}
	}
	
	public void alterar() {
		System.out.println("--=[Alterar Moto]=--");
		
		if(motos.isEmpty())
			System.out.println("Não existem motos cadastradas.");
		else {
			int pos, resp;
			
			System.out.println("Digite a posição que deseja alterar: ");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < motos.size())) {
				System.out.println("-[Dados da Moto]-");
				imprime(motos.get(pos));
				System.out.println("Confirma a alteração? (1-sim/2-não)");
				resp = scN.nextInt();
				
				if(resp == 1) {
					System.out.println("Digite os novos dados para: ");
					Moto moto = motos.get(pos);
					
					System.out.println("- Marca: ");
					moto.setMarca(scS.nextLine());
					System.out.println("- Modelo: ");
					moto.setModelo(scS.nextLine());
					System.out.println("- Ano fabricação: ");
					moto.setAnoFabricacao(scN.nextInt());
					System.out.println("- Ano modelo: ");
					moto.setAnoModelo(scN.nextInt());
					System.out.println("- Cilindradas: ");
					moto.setCilindradas(scN.nextInt());
					System.out.println("- Preço R$");
					moto.setPreco(scN.nextFloat());
					
					System.out.println("Moto alterada com sucesso.");
				}
				else
					System.out.println("Moto não alterada.");
			}
			else
				System.out.println("Posição inválida!");
		}
		
	}
	
	public void consultar() {
		System.out.println("--=[Consultar Moto]=--");
		
		if(motos.isEmpty())
			System.out.println("Não existem motos cadastradas.");
		else {
			int pos, resp;
			
			System.out.println("Digite a posição que deseja consultar: ");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < motos.size())) {
				System.out.println("-[Dados da Moto]-");
				imprime(motos.get(pos));
			}
			else
				System.out.println("Posição inválida!");
		}
	}
	
	public void relatorio(){
		System.out.println("--=[Relatório de Motos]=--");
		
		if(motos.isEmpty())
			System.out.println("Não existem motos cadastradas.");
		else {
			for(Moto m : motos) {
				imprime(m);
				System.out.println("----------");
			}
		}
		
	}
	
	private void imprime(Moto m) {
		System.out.println("- Marca         : " + m.getMarca());
		System.out.println("- Modelo        : " + m.getModelo());
		System.out.println("- Ano fabricação: " + m.getAnoFabricacao());
		System.out.println("- Ano modelo    : " + m.getAnoModelo());
		System.out.println("- Cilindradas   : " + m.getCilindradas());
		System.out.println("- Preço         : " + m.getPreco());
	}
}
