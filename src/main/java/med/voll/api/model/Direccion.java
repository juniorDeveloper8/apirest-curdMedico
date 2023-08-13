package med.voll.api.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.Data.DatosDireccion;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {

  private String calle;
  private String distrito;
  private String ciudad;
  private String numero;
  private String complemento;

  public Direccion(DatosDireccion direccion){
    this.calle = direccion.calle();
    this.ciudad = direccion.ciudad();
    this.distrito = direccion.distrito();
    this.numero = direccion.numero();
    this.complemento = direccion.complemento();
  }

  public Direccion actualizarDatos(DatosDireccion direccion) {
    this.calle = direccion.calle();
    this.ciudad = direccion.ciudad();
    this.distrito = direccion.distrito();
    this.numero = direccion.numero();
    this.complemento = direccion.complemento();

    return this;
  }
}
