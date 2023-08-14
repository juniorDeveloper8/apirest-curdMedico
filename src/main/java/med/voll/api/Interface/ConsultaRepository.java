package med.voll.api.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import med.voll.api.model.Pacientes.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
