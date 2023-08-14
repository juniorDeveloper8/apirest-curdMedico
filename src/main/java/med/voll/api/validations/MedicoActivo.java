package med.voll.api.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.ValidationException;
import med.voll.api.Data.DTOConsultas.DatosAgendarConsulta;
import med.voll.api.Interface.MedicoRepository;

@Service
public class MedicoActivo implements ValidadorDeConsultas {
  @Autowired
  private MedicoRepository repository;

  public void validar(DatosAgendarConsulta datos) {
    if (datos.idMedico() == null) {
      return;
    }
    var medicoActivo = repository.findActivoById(datos.idMedico());
    if (!medicoActivo) {
      throw new ValidationException("No se puede permitir agendar citas con medicos inactivos en el sistema");
    }
  }
}