package academy.wakanda.coopwaka.SessaoVotacao.application.api;

import academy.wakanda.coopwaka.SessaoVotacao.domain.OpcaoVoto;
import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class VotoRequest {
    private String cpfAssociado;
    private OpcaoVoto opcao;
}
