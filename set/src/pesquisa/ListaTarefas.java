package pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
	private Set<Tarefa> tarefaSet;

	public ListaTarefas() {
		this.tarefaSet = new HashSet<>();
	}
	
	public void adicionarTarefa(String descricao) {
		tarefaSet.add(new Tarefa(descricao));
	}
	
	public void removerTarefa(String descricao) {
		Tarefa tarefaParaRemover = null;
		
		for(Tarefa t : tarefaSet) {
			if(t.getDescricao() == descricao) {
				tarefaParaRemover = t;
				break;
			}
		}
		tarefaSet.remove(tarefaParaRemover);
	}
	
	public void exibirTarefas() {
		System.out.println(tarefaSet);
	}
	
	public int contarTarefas() {
		return tarefaSet.size();
	}
	
	public Set<Tarefa> obterTarefasConcluidas(){
		Set<Tarefa> tarefasConcluidas = new HashSet<>();
		
		for(Tarefa t : tarefaSet) {
			if(t.isSituacao()) {
				tarefasConcluidas.add(t);
			}
		}
		return tarefasConcluidas;
	}
	
	public Set<Tarefa> obterTarefasPendentes(){
		Set<Tarefa> tarefasPendentes = new HashSet<>();
		
		for(Tarefa t : tarefaSet) {
			if(!(t.isSituacao())) {
				tarefasPendentes.add(t);
			}
		}
		return tarefasPendentes;
	}
	
	public Tarefa marcarTarefaConcluida(String descricao) {
		Tarefa tarefaConcluida = null;
		
		for(Tarefa t : tarefaSet) {
			if(t.getDescricao().equalsIgnoreCase(descricao)) {
				t.setSituacao(true);
				tarefaConcluida = t;
				break;
			}
		}
		return tarefaConcluida;
	}
	
	public Tarefa marcarTarefaPendente(String descricao) {
		Tarefa tarefaPendente = null;
		
		for(Tarefa t: tarefaSet) {
			if(t.getDescricao().equalsIgnoreCase(descricao)) {
				t.setSituacao(false);
				tarefaPendente = t;
				break;
			}
		}
		return tarefaPendente;
	}
	
	public void limparListaTarefas() {
		tarefaSet.clear();
	}
	
	public static void main(String[] args) {
		ListaTarefas listaTarefas = new ListaTarefas();
		
		listaTarefas.exibirTarefas();
		
		listaTarefas.adicionarTarefa("Comprar");
		listaTarefas.adicionarTarefa("Beber");
		listaTarefas.adicionarTarefa("Comer");
		listaTarefas.adicionarTarefa("Comprar");
		
		listaTarefas.exibirTarefas();
		
		listaTarefas.removerTarefa("Beber");
		
		listaTarefas.exibirTarefas();
		
		System.out.println("Quantidade de tarefas: " + listaTarefas.contarTarefas()); 
		System.out.println("Tarefas concluídas: " + listaTarefas.obterTarefasConcluidas());
		System.out.println("Tarefas pendentes: " + listaTarefas.obterTarefasPendentes());
		
		System.out.println("Tarefa marcada como concluida: " + listaTarefas.marcarTarefaConcluida("Comprar"));
		System.out.println("Tarefa marcada como concluida: " + listaTarefas.marcarTarefaConcluida("Comer"));
		
		System.out.println("Quantidade de tarefas: " + listaTarefas.contarTarefas()); 
		System.out.println("Tarefas concluídas: " + listaTarefas.obterTarefasConcluidas());
		System.out.println("Tarefas pendentes: " + listaTarefas.obterTarefasPendentes());
	
		System.out.println("Tarefa marcada como pendente: " + listaTarefas.marcarTarefaPendente("Comer"));
		
		System.out.println("Quantidade de tarefas: " + listaTarefas.contarTarefas()); 
		System.out.println("Tarefas concluídas: " + listaTarefas.obterTarefasConcluidas());
		System.out.println("Tarefas pendentes: " + listaTarefas.obterTarefasPendentes());
		
		listaTarefas.limparListaTarefas();
		listaTarefas.exibirTarefas();
		
		System.out.println("Quantidade de tarefas: " + listaTarefas.contarTarefas()); 
	}
}
