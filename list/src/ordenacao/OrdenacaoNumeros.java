package ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
	private List<Integer> numeroList;

	public OrdenacaoNumeros() {
		this.numeroList = new ArrayList<>();
	}
	
	public void adicionarNumero(int numero) {
		numeroList.add(numero);
	}
	
	public List<Integer> ordenarAscendente(){
		List<Integer> ordemAscendente = new ArrayList<>(numeroList);
		Collections.sort(ordemAscendente);		
		return ordemAscendente;
	}
	
	public List<Integer> ordenarDescendente(){
		List<Integer> ordemDescendente = new ArrayList<>(numeroList);
		Collections.sort(ordemDescendente, Collections.reverseOrder());
		return ordemDescendente;
	}
	
	public static void main (String[] args) {
		OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();
		ordenacaoNumeros.adicionarNumero(0);
		ordenacaoNumeros.adicionarNumero(2);
		ordenacaoNumeros.adicionarNumero(1);
		ordenacaoNumeros.adicionarNumero(3);
		ordenacaoNumeros.adicionarNumero(6);
		ordenacaoNumeros.adicionarNumero(5);
		ordenacaoNumeros.adicionarNumero(4);
		
		System.out.println("Lista em ordem crescente: " + ordenacaoNumeros.ordenarAscendente());
		System.out.println("Lista em ordem decrescente: " + ordenacaoNumeros.ordenarDescendente());
	}
}
