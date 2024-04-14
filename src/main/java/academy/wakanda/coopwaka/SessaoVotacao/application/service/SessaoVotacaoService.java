package academy.wakanda.coopwaka.SessaoVotacao.application.service;

import academy.wakanda.coopwaka.SessaoVotacao.application.api.SessaoAberturaRequest;
import academy.wakanda.coopwaka.SessaoVotacao.application.api.SessaoAberturaResponse;

public interface SessaoVotacaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);
}
