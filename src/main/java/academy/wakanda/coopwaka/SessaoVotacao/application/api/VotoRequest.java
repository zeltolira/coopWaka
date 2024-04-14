package academy.wakanda.coopwaka.SessaoVotacao.application.api;

import academy.wakanda.coopwaka.SessaoVotacao.domain.OpcaoVoto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VotoRequest {
    private String cpfAssociado;
    private OpcaoVoto opcao;
}
