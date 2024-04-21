package academy.wakanda.coopwaka.SessaoVotacao.application.infra;

import academy.wakanda.coopwaka.SessaoVotacao.domain.SessaoVotacao;
import academy.wakanda.coopwaka.SessaoVotacao.domain.StatusSessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SessaoVotacaoSpringDataJPARepository extends JpaRepository<SessaoVotacao, UUID> {
    List<SessaoVotacao> findByStatus(StatusSessaoVotacao aberta);
}
