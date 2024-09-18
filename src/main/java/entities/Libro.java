package entities;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="libro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Audited
public class Libro extends Persona implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String titulo;
    private Date fecha;

    @Column
    private String genero;

    @Column
    private int paginas;

    @Column
    private String autor;

    public Libro(long id, String nombre, String apellido, int dni, Libro libro) {
        super(id, nombre, apellido, dni, libro);
    }
}
