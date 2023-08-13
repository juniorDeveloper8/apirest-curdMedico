package med.voll.api.Interface;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

  Page<Medico> findByActivoTrue(Pageable paginacion);
  
}
