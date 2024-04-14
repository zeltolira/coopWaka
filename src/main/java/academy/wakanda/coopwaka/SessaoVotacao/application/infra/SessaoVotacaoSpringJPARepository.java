package academy.wakanda.coopwaka.SessaoVotacao.application.infra;

import academy.wakanda.coopwaka.SessaoVotacao.domain.SessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessaoVotacaoSpringJPARepository extends JpaRepository<SessaoVotacao, UUID> {
}
