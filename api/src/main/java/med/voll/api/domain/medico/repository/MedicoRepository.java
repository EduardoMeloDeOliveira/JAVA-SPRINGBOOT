package med.voll.api.domain.medico.repository;

import med.voll.api.domain.medico.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {


  List<Medico>findMedicoByIsActiveTrue();
  List<Medico> findMedicoByIsActiveFalse();
  Boolean existsMedicoByCrm(String crm);
  Boolean existsMedicoByEmail(String email);
}
