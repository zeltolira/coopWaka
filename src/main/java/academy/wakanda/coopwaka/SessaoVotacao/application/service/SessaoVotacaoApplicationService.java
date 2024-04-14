package academy.wakanda.coopwaka.SessaoVotacao.application.service;

import academy.wakanda.coopwaka.SessaoVotacao.application.api.SessaoAberturaRequest;
import academy.wakanda.coopwaka.SessaoVotacao.application.api.SessaoAberturaResponse;
import academy.wakanda.coopwaka.SessaoVotacao.domain.SessaoVotacao;
import academy.wakanda.coopwaka.pauta.application.service.PautaService;
import academy.wakanda.coopwaka.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoApplicationService implements SessaoVotacaoService {
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaService pautaService;
    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[start] SessaoVotacaoApplicationService - abreSessao");
        Pauta pauta = pautaService.getPautaPorId(sessaoAberturaRequest.getIdPauta());
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.salva(new SessaoVotacao(sessaoAberturaRequest, pauta));
        log.info("[finish] SessaoVotacaoApplicationService - abreSessao");
        return new SessaoAberturaResponse(sessaoVotacao);
    }
}
