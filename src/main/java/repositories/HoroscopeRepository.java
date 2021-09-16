package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pojo.Horoscope;

public interface HoroscopeRepository extends JpaRepository<Horoscope, Long> {


}
