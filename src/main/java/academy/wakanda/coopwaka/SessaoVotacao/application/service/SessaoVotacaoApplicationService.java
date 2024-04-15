package academy.wakanda.coopwaka.SessaoVotacao.application.service;

import academy.wakanda.coopwaka.SessaoVotacao.application.api.*;
import academy.wakanda.coopwaka.SessaoVotacao.domain.SessaoVotacao;
import academy.wakanda.coopwaka.SessaoVotacao.domain.VotoPauta;
import academy.wakanda.coopwaka.associado.application.service.AssociadoService;
import academy.wakanda.coopwaka.pauta.application.service.PautaService;
import academy.wakanda.coopwaka.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoApplicationService implements SessaoVotacaoService {
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaService pautaService;
    private final AssociadoService associadoService;
    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.debug("[start] SessaoVotacaoApplicationService - abreSessao");
        Pauta pauta = pautaService.getPautaPorId(sessaoAberturaRequest.getIdPauta());
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.salva(new SessaoVotacao(sessaoAberturaRequest, pauta));
        log.debug("[finish] SessaoVotacaoApplicationService - abreSessao");
        return new SessaoAberturaResponse(sessaoVotacao);
    }

    @Override
    public VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto) {
        log.debug("[start] SessaoVotacaoApplicationService - recebeVoto");
        SessaoVotacao sessao = sessaoVotacaoRepository.buscaPorId(idSessao);
        VotoPauta voto = sessao.recebeVoto(novoVoto, associadoService);
        sessaoVotacaoRepository.salva(sessao);
        log.debug("[finish] SessaoVotacaoApplicationService - recebeVoto");
        return new VotoResponse(voto);
    }

    @Override
    public ResultadoSessaoResponse obtemResultado(UUID idSessao) {
        log.debug("[start] SessaoVotacaoApplicationService - obtemResultado");
        SessaoVotacao sessao = sessaoVotacaoRepository.buscaPorId(idSessao);
        ResultadoSessaoResponse resultado = sessao.obtemResultado();
        sessaoVotacaoRepository.salva(sessao);
        log.debug("[finish] SessaoVotacaoApplicationService - obtemResultado");
        return resultado;
    }
}
