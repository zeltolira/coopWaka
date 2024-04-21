package academy.wakanda.coopwaka.SessaoVotacao.application.service;

import academy.wakanda.coopwaka.SessaoVotacao.application.api.*;

import java.util.UUID;

public interface SessaoVotacaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);
    VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto);

    ResultadoSessaoResponse obtemResultado(UUID idSessao);
}
