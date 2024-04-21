package academy.wakanda.coopwaka.pauta.application.infra;

import academy.wakanda.coopwaka.pauta.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PautaSpringDataJPARepository extends JpaRepository <Pauta, UUID> {
}
