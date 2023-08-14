package med.voll.api.Data.DTOConsultas;

import med.voll.api.model.Direccion;
import med.voll.api.model.Pacientes.Paciente;

public record DatosDetallesPaciente(Long id, String nombre, String email, String documento, String telefono,
    Direccion direccion) {

  public DatosDetallesPaciente(Paciente paciente) {
    this(paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getDocumento(), paciente.getTelefono(),
        paciente.getDireccion());
  }
}
