package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 * Pojo Entity representing the day horoscope
 */
@Entity
@Getter
@Setter
public class Horoscope {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    Sign sign;
    Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horoscope horoscope = (Horoscope) o;
        return id.equals(horoscope.id) && sign == horoscope.sign && date.equals(horoscope.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sign, date);
    }
}
