package med.voll.api.paciente.repository;

import med.voll.api.paciente.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    List<Paciente> findPacienteByIsActivePacienteTrue();
    List<Paciente> findPacienteByIsActivePacienteFalse();
}
