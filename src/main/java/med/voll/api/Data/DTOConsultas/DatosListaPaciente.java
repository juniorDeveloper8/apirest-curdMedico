package med.voll.api.Data.DTOConsultas;

import med.voll.api.model.Pacientes.Paciente;

public record DatosListaPaciente(Long id, String nombre, String email, String documento) {

  public DatosListaPaciente(Paciente paciente) {
    this(paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getDocumento());
  }

}