package med.voll.api.domain.consulta.repository;

import med.voll.api.domain.consulta.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
