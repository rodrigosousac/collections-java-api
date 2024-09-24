package operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
	private Map<String, String> dicionarioMap;

	public Dicionario() {
		this.dicionarioMap = new HashMap<>();
	}
	
	public void adicionarPalavra(String palavra, String definicao) {
		dicionarioMap.put(palavra, definicao);
	}
	
	public void removerPalavra(String palavra) {
		if(!dicionarioMap.isEmpty()) {
			dicionarioMap.remove(palavra);
		}
	}
	
	public void exibirPalavras() {
		System.out.println(dicionarioMap);
	}
	
	public String pesquisarPorPalavra(String palavra) {
		String definicaoPorPalavra = null;
		
		if(!dicionarioMap.isEmpty()) {
			definicaoPorPalavra = dicionarioMap.get(palavra);
		}
		return definicaoPorPalavra;
	}
	
	public static void main(String[] args) {
		Dicionario dicionario = new Dicionario();
		
		dicionario.exibirPalavras();
		
		dicionario.adicionarPalavra("Bregueço", "algo velho ou ultrapassado");
		dicionario.adicionarPalavra("Ceroto", "sujeira");
		dicionario.adicionarPalavra("Gastura", "azia ou mal estar, tanto físico quanto psicológico");
		dicionario.adicionarPalavra("Mangar", "rir de alguém");
		dicionario.adicionarPalavra("Miolo de pote", "coisa sem importância");
		
		dicionario.exibirPalavras();
		
		dicionario.removerPalavra("Gastura");
		
		dicionario.exibirPalavras();
		
		System.out.println("A definição de Ceroto é: " + dicionario.pesquisarPorPalavra("Ceroto"));
	}
}
