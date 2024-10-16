package med.voll.api.medico.repository;

import med.voll.api.medico.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {


  List<Medico>findMedicoByIsActiveTrue();
  List<Medico> findMedicoByIsActiveFalse();
}
