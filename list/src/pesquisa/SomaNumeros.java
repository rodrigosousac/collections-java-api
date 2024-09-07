package pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
	private List<Integer> numeroList;

	public SomaNumeros() {
		this.numeroList = new ArrayList<>();
	}
	
	public void adicionarNumero(int numero) {
		numeroList.add(numero);
	}
	
	public int calcularSoma() {
		int soma = 0;
		
		if(!numeroList.isEmpty()) {
			for (int n : numeroList) {
				soma += n;
			}
		}
		return soma;
	}
	
	public int encontrarMaiorNumero() {
		int maiorNumero = numeroList.get(0);
		
		if(!numeroList.isEmpty()) {
			for(int n : numeroList) {
				if(maiorNumero < n) {
					maiorNumero = n;
				}
			}
		}
		return maiorNumero;
	}
	
	public int encontrarMenorNumero() {
		int menorNumero = numeroList.get(0);
		
		if(!numeroList.isEmpty()) {
			for(int n : numeroList) {
				if(menorNumero > n) {
					menorNumero = n;
				}
			}
		}
		return menorNumero;
	}
	
	public void exibirNumeros() {
		System.out.println(numeroList);
	}
	
	public static void main (String[] args) {
		SomaNumeros somaNumeros = new SomaNumeros();
		somaNumeros.adicionarNumero(1);
		somaNumeros.adicionarNumero(2);
		somaNumeros.adicionarNumero(3);
		somaNumeros.adicionarNumero(4);
		somaNumeros.adicionarNumero(5);
		somaNumeros.adicionarNumero(6);
		somaNumeros.adicionarNumero(7);
		somaNumeros.adicionarNumero(8);
		somaNumeros.adicionarNumero(9);
		somaNumeros.adicionarNumero(10);
		somaNumeros.adicionarNumero(11);
		somaNumeros.adicionarNumero(12);
		
		somaNumeros.exibirNumeros();
		
		System.out.println("O maior número da lista é " + somaNumeros.encontrarMaiorNumero());
		System.out.println("O menor número da lista é " + somaNumeros.encontrarMenorNumero());
		System.out.println("A soma de todos os valores da lista é " + somaNumeros.calcularSoma());
	}
}
