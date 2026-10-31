package br.edu.fatecpg.apitaskmgr.controller;

import java.util.List;

import br.edu.fatecpg.apitaskmgr.model.Tarefa;
import br.edu.fatecpg.apitaskmgr.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	private final TarefaService service;

	public TarefaController(TarefaService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Tarefa> criarTarefa(@Valid @RequestBody Tarefa novaTarefa) {
		Tarefa tarefaSalva = service.criarTarefa(novaTarefa);
		return new ResponseEntity<>(tarefaSalva, HttpStatus.CREATED);
	}

	@GetMapping
	public List<Tarefa> listarTodasTarefas() {
		return service.listarTodasTarefas();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Long id) {
		return service.buscarTarefaPorId(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id,
			@Valid @RequestBody Tarefa tarefaAtualizada) {
		return service.atualizarTarefa(id, tarefaAtualizada)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
		if (service.deletarTarefa(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
