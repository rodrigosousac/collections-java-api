package operacoes.basicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
	private Set<String> palavrasSet;

	public ConjuntoPalavrasUnicas() {
		this.palavrasSet = new HashSet<>();
	}
	
	public void adicionarPalavra(String palavra) {
		palavrasSet.add(palavra);
	}
	
	public void removerPalavra(String palavra) {
		palavrasSet.remove(palavra);
	}
	
	public boolean verificarPalavra(String palavra) {
		return palavrasSet.contains(palavra);
	}
	
	public void exibirPalavrasUnicas() {
		System.out.println(palavrasSet);
	}
	
	public static void main(String[] args) {
		ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();
		
		conjuntoPalavrasUnicas.exibirPalavrasUnicas();
		
		conjuntoPalavrasUnicas.adicionarPalavra("primeiro");
		conjuntoPalavrasUnicas.adicionarPalavra("primeiro");
		conjuntoPalavrasUnicas.adicionarPalavra("segundo");
		conjuntoPalavrasUnicas.adicionarPalavra("terceiro");
		
		conjuntoPalavrasUnicas.exibirPalavrasUnicas();
		
		conjuntoPalavrasUnicas.removerPalavra("segundo");
		
		conjuntoPalavrasUnicas.exibirPalavrasUnicas();
		
		System.out.println(conjuntoPalavrasUnicas.verificarPalavra("primeiro")); 
	}
}
