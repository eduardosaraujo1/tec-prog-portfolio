package br.edu.fatecpg.cadastro_produtos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fatecpg.cadastro_produtos.model.Produto;

@Service
public class ProdutoArrayStorageService implements ProdutoStorageService {
    private final List<Produto> produtos = new ArrayList<>();

    @Override
    public synchronized void removeByUuid(String uuid) {
        produtos.removeIf(produto -> produto.getId().equals(uuid));
    }

    @Override
    public synchronized Optional<Produto> getByUuid(String uuid) {
        return produtos.stream().filter(produto -> produto.getId().equals(uuid)).findFirst();
    }

    @Override
    public synchronized List<Produto> search(String termo) {
        String busca = termo.strip().toLowerCase(Locale.ROOT);
        if (busca.isEmpty()) {
            return list();
        }
        return produtos.stream()
                .filter(produto -> (produto.getNome() != null
                        && produto.getNome().toLowerCase(Locale.ROOT).contains(busca))
                        || (produto.getCategoria() != null
                        && produto.getCategoria().toLowerCase(Locale.ROOT).contains(busca)))
                .toList();
    }

    @Override
    public synchronized List<Produto> list(int limit, int offset) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Não é possível ter um limite menor ou igual a 0");
        }
        if (offset < 0) {
            throw new IllegalArgumentException("Não é possível ter um offset menor que 0");
        }

        if (offset >= produtos.size()) {
            return List.of();
        }

        int quantidade = Math.min(limit, produtos.size() - offset);
        return List.copyOf(produtos.subList(offset, offset + quantidade));
    }

    @Override
    public synchronized Produto insert(Produto produto) {
        if (getByUuid(produto.getId()).isPresent()) {
            throw new IllegalStateException("Não é possível inserir um produto com ID duplicado");
        }
        return upsert(produto);
    }

    @Override
    public synchronized Produto update(Produto produto) {
        if (getByUuid(produto.getId()).isEmpty()) {
            throw new IllegalStateException("Não é possível atualizar um produto que não existe");
        }
        return upsert(produto);
    }

    @Override
    public synchronized Produto upsert(Produto produto) {
        for (int indice = 0; indice < produtos.size(); indice++) {
            if (produtos.get(indice).getId().equals(produto.getId())) {
                produtos.set(indice, produto);
                return produto;
            }
        }
        produtos.add(produto);
        return produto;
    }
}
