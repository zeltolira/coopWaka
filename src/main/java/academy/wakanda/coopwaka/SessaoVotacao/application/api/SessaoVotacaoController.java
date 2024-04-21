package academy.wakanda.coopwaka.SessaoVotacao.application.api;

import academy.wakanda.coopwaka.SessaoVotacao.application.service.SessaoVotacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoController implements SessaoVotacaoAPI {
    private final SessaoVotacaoService sessaoVotacaoService;

    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.debug("[start] SessaoVotacaoController - abreSessao");
        SessaoAberturaResponse sessaoAberturaResponse = sessaoVotacaoService.abreSessao(sessaoAberturaRequest);
        log.debug("[finish] SessaoVotacaoController - abreSessao");
        return sessaoAberturaResponse;
    }
    @Override
    public VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto) {
        log.debug("[start] SessaoVotacaoController - recebeVoto");
        log.debug("[idSessao]{}", idSessao);
        VotoResponse votoResponse = sessaoVotacaoService.recebeVoto(idSessao, novoVoto);
        log.debug("[finish] SessaoVotacaoController - recebeVoto");
        return votoResponse;
    }
    @Override
    public ResultadoSessaoResponse obtemResultado(UUID idSessao) {
        log.debug("[start] SessaoVotacaoController - obtemResultado");
        ResultadoSessaoResponse resultado = sessaoVotacaoService.obtemResultado(idSessao);
        log.debug("[finish] SessaoVotacaoController - obtemResultado");
        return resultado;
    }
}
