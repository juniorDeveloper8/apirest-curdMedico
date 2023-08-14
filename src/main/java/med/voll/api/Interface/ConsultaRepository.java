package med.voll.api.Interface;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.model.Pacientes.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

  Boolean existsByPacienteIdAndFechaBetween(Long idPaciente, LocalDateTime primerHorario, LocalDateTime ultimoHorario);

  Boolean existsByMedicoIdAndFecha(Long idMedico, LocalDateTime fecha);
}
