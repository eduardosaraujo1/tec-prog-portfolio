package br.edu.fatecpg.cadastro_produtos.service;

import java.util.List;
import java.util.Optional;

import br.edu.fatecpg.cadastro_produtos.model.Produto;

public interface ProdutoStorageService {
    Produto insert(Produto produto);

    Produto update(Produto produto);

    Produto upsert(Produto produto);

    void removeByUuid(String uuid);

    Optional<Produto> getByUuid(String uuid);

    List<Produto> search(String termo);

    default List<Produto> list() {
        return list(Integer.MAX_VALUE);
    }

    default List<Produto> list(int limit) {
        return list(limit, 0);
    }

    List<Produto> list(int limit, int offset);
}
