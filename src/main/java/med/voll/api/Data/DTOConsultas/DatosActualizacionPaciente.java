package med.voll.api.Data.DTOConsultas;

import jakarta.validation.constraints.NotNull;
import med.voll.api.Data.DatosDireccion;

public record DatosActualizacionPaciente(
        @NotNull Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion) {
}