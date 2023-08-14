package med.voll.api.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ValidationException;
import med.voll.api.Data.DTOConsultas.DatosAgendarConsulta;
import med.voll.api.Interface.ConsultaRepository;

@Component
public class MedicoConConsulta implements ValidadorDeConsultas {
  @Autowired
  private ConsultaRepository repository;

  public void validar(DatosAgendarConsulta datos) {
    if (datos.idMedico() == null)
      return;

    var medicoConConsulta = repository.existsByMedicoIdAndFecha(datos.idMedico(), datos.fecha());
    if (medicoConConsulta) {
      throw new ValidationException("este medico ya tiene una consulta en ese horario");
    }
  }
}