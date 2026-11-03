package br.edu.fatecpg.cadastro_produtos.service;

import java.util.List;
import java.util.Optional;

import br.edu.fatecpg.cadastro_produtos.model.Produto;
import br.edu.fatecpg.cadastro_produtos.repository.ProdutoRepository;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@Transactional(readOnly = true)
public class ProdutoH2StorageService implements ProdutoStorageService {

    private final ProdutoRepository repository;
    private final EntityManager entityManager;

    public ProdutoH2StorageService(ProdutoRepository repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Produto> search(String termo) {
        String busca = termo.strip();
        if (busca.isEmpty()) {
            return list();
        }
        return List.copyOf(repository.findByNomeContainingIgnoreCaseOrCategoriaContainingIgnoreCase(
                busca, busca, Sort.by("criadoEm", "id")));
    }

    @Override
    @Transactional
    public Produto insert(Produto produto) {
        if (repository.existsById(produto.getId())) {
            throw new IllegalStateException("Não é possível inserir um produto com ID duplicado");
        }
        return repository.save(produto);
    }

    @Override
    @Transactional
    public Produto update(Produto produto) {
        if (!repository.existsById(produto.getId())) {
            throw new IllegalStateException("Não é possível atualizar um produto que não existe");
        }
        return repository.save(produto);
    }

    @Override
    @Transactional
    public Produto upsert(Produto produto) {
        return repository.save(produto);
    }

    @Override
    @Transactional
    public void removeByUuid(String uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public Optional<Produto> getByUuid(String uuid) {
        return repository.findById(uuid);
    }

    @Override
    public List<Produto> list(int limit, int offset) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Não é possível ter um limite menor ou igual a 0");
        }
        if (offset < 0) {
            throw new IllegalArgumentException("Não é possível ter um offset menor que 0");
        }
        return List.copyOf(entityManager.createQuery(
                        "select produto from Produto produto order by produto.criadoEm, produto.id", Produto.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList());
    }
}
