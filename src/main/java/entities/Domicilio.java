package entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;
import org.hibernate.envers.Audited;

import java.io.Serializable;
@Entity
@Table(name="domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Audited
public class Domicilio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column
    private String calle;

    @Column
    private int num;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_persona")
    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Domicilio(long id, String calle, int num, Persona persona) {
        this.id = id;
        this.calle = calle;
        this.num = num;
        this.persona = persona;
    }
}

