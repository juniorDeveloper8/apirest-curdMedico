package med.voll.api.Data;

public record DatosRepuestaMedico(
    Long id,
    String nombre,
    String email,
    String telefono,
    String documento,
    DatosDireccion direccion

) {}
