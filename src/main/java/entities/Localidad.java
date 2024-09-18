package entities;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
@Entity
@Table(name="localidad")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Audited

public class Localidad implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String denominacion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_Domicilio")
    private Domicilio domicilio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Localidad(long id, String denominacion, Domicilio domicilio) {
        this.id = id;
        this.denominacion = denominacion;
        this.domicilio = domicilio;
    }
}
