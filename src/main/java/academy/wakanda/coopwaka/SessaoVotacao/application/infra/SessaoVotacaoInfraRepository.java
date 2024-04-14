package academy.wakanda.coopwaka.SessaoVotacao.application.infra;

import academy.wakanda.coopwaka.SessaoVotacao.application.service.SessaoVotacaoRepository;
import academy.wakanda.coopwaka.SessaoVotacao.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoInfraRepository implements SessaoVotacaoRepository {
    private final SessaoVotacaoSpringJPARepository sessaoVotacaoSpringJPARepository;

    @Override
    public SessaoVotacao salva(SessaoVotacao sessaoVotacao) {
        log.info("[start] SessaoVotacaoInfraRepository - salva");
        sessaoVotacaoSpringJPARepository.save(sessaoVotacao);
        log.info("[finish] SessaoVotacaoInfraRepository - salva");
        return sessaoVotacao;
    }
}
