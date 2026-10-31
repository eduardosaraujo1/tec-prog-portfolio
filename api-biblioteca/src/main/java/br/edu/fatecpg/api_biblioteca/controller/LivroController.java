package br.edu.fatecpg.api_biblioteca.controller;

import java.util.List;

import br.edu.fatecpg.api_biblioteca.model.Livro;
import br.edu.fatecpg.api_biblioteca.repository.LivroRepository;
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
@RequestMapping("/livros")
public class LivroController {

	private final LivroRepository repository;

	public LivroController(LivroRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	public ResponseEntity<Livro> criarLivro(@RequestBody Livro novoLivro) {
		novoLivro.setId(null);
		Livro livroSalvo = repository.save(novoLivro);
		return new ResponseEntity<>(livroSalvo, HttpStatus.CREATED);
	}

	@GetMapping
	public List<Livro> listarTodosLivros() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
		return repository.findById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
		return repository.findById(id)
				.map(livroExistente -> {
					livroExistente.setTitulo(livroAtualizado.getTitulo());
					livroExistente.setAutor(livroAtualizado.getAutor());
					livroExistente.setIsbn(livroAtualizado.getIsbn());
					livroExistente.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
					Livro livroSalvo = repository.save(livroExistente);
					return ResponseEntity.ok(livroSalvo);
				})
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
