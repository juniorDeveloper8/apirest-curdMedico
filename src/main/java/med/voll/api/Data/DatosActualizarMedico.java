package med.voll.api.Data;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(
  @NotNull
  Long id,
  String nombre,
  String documento,
  DatosDireccion direccion
) {
  
}
