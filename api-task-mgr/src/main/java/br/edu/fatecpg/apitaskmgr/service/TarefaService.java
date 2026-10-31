package br.edu.fatecpg.apitaskmgr.service;

import java.util.List;
import java.util.Optional;

import br.edu.fatecpg.apitaskmgr.model.Tarefa;
import br.edu.fatecpg.apitaskmgr.repository.TarefaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TarefaService {

	private final TarefaRepository repository;

	public TarefaService(TarefaRepository repository) {
		this.repository = repository;
	}

	public Tarefa criarTarefa(Tarefa novaTarefa) {
		// O ID de uma nova tarefa sempre deve ser gerado pelo banco.
		novaTarefa.setId(null);
		return repository.save(novaTarefa);
	}

	public List<Tarefa> listarTodasTarefas() {
		return repository.findAll();
	}

	public Optional<Tarefa> buscarTarefaPorId(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public Optional<Tarefa> atualizarTarefa(Long id, Tarefa tarefaAtualizada) {
		return repository.findById(id).map(tarefaExistente -> {
			tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
			tarefaExistente.setConcluida(tarefaAtualizada.getConcluida());
			tarefaExistente.setPrioridade(tarefaAtualizada.getPrioridade());
			return repository.save(tarefaExistente);
		});
	}

	@Transactional
	public boolean deletarTarefa(Long id) {
		if (!repository.existsById(id)) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
}
