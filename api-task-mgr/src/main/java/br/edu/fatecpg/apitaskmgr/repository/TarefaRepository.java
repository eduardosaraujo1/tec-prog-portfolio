package br.edu.fatecpg.apitaskmgr.repository;

import br.edu.fatecpg.apitaskmgr.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
