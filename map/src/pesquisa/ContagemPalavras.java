package pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
	private Map<String, Integer> contagemPalavrasMap;

	public ContagemPalavras() {
		this.contagemPalavrasMap = new HashMap<>();
	}
	
	public void adicionarPalavra(String palavra, Integer contagem) {
		contagemPalavrasMap.put(palavra, contagem);
	}
	
	public void removerPalavra(String palavra) {
		contagemPalavrasMap.remove(palavra);
	}
	
	public void exibirContagemPalavrar() {
		System.out.println(contagemPalavrasMap);
	}
	
	public String encontrarPalavraMaisFrequente() {
		String palavraMaisFrequente = null;
		int frequencia = Integer.MIN_VALUE;
		
		if(!contagemPalavrasMap.isEmpty()) {
			for(Map.Entry<String,Integer> e : contagemPalavrasMap.entrySet()) {
				if(e.getValue() > frequencia) {
					palavraMaisFrequente = e.getKey();
					frequencia = e.getValue();
				}
			}
		}
		return palavraMaisFrequente;
	}
	
	public static void main(String[] args) {
		ContagemPalavras contagemPalavras = new ContagemPalavras();
		
		contagemPalavras.exibirContagemPalavrar();
		
		contagemPalavras.adicionarPalavra("Caju", 3);
		contagemPalavras.adicionarPalavra("Suco", 1);
		contagemPalavras.adicionarPalavra("Castanha", 2);
		contagemPalavras.adicionarPalavra("Fruta", 1);
		
		contagemPalavras.exibirContagemPalavrar();
		
		contagemPalavras.removerPalavra("Suco");
		
		contagemPalavras.exibirContagemPalavrar();
		
		System.out.println("A palavra mais frequente é: " + contagemPalavras.encontrarPalavraMaisFrequente());
	}
}
