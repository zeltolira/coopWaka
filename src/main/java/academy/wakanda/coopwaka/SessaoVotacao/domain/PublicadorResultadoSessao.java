package academy.wakanda.coopwaka.SessaoVotacao.domain;

import academy.wakanda.coopwaka.SessaoVotacao.application.api.ResultadoSessaoResponse;

public interface PublicadorResultadoSessao {
    void publica(ResultadoSessaoResponse resultadoSessaoResponse);
}
