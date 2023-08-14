package med.voll.api.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.model.Pacientes.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
