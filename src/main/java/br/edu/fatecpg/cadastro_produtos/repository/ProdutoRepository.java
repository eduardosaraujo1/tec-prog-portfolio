package br.edu.fatecpg.cadastro_produtos.repository;

import java.util.List;

import br.edu.fatecpg.cadastro_produtos.model.Produto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByNomeContainingIgnoreCaseOrCategoriaContainingIgnoreCase(
            String nome, String categoria, Sort sort);
}
