package med.voll.api.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ValidationException;
import med.voll.api.Data.DTOConsultas.DatosAgendarConsulta;
import med.voll.api.Interface.ConsultaRepository;

@Component
public class PacienteSinConsulta implements ValidadorDeConsultas {

  @Autowired
  private ConsultaRepository repository;

  public void validar(DatosAgendarConsulta datos) {
    var primerHorario = datos.fecha().withHour(7);
    var ultimoHorario = datos.fecha().withHour(18);

    var pacienteConConsulta = repository.existsByPacienteIdAndFechaBetween(datos.idPaciente(), primerHorario,
        ultimoHorario);

    if (pacienteConConsulta) {
      throw new ValidationException("el paciente ya tiene una consulta para ese dia");
    }

  }
}