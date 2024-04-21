package academy.wakanda.coopwaka.SessaoVotacao.application.service;

import academy.wakanda.coopwaka.SessaoVotacao.domain.SessaoVotacao;

import java.util.List;
import java.util.UUID;

public interface SessaoVotacaoRepository {
    SessaoVotacao salva(SessaoVotacao sessaoVotacao);
    SessaoVotacao buscaPorId(UUID idSessao);
    List<SessaoVotacao> buscaAbertas();
}
