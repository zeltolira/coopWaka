package academy.wakanda.coopwaka.SessaoVotacao.application.api;

import academy.wakanda.coopwaka.SessaoVotacao.domain.SessaoVotacao;
import academy.wakanda.coopwaka.SessaoVotacao.domain.StatusSessaoVotacao;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
public class ResultadoSessaoResponse {
    private UUID idSessao;
    private UUID idPauta;
    private StatusSessaoVotacao status;
    private LocalDateTime momentoAbertura;
    private LocalDateTime momentoEncerramento;
    private Long totalVotos;
    private Long totalSim;
    private Long totalNao;

    public ResultadoSessaoResponse(SessaoVotacao sessao) {
        this.idSessao = sessao.getId();
        this.idPauta = sessao.getIdPauta();
        this.status = sessao.getStatus();
        this.momentoAbertura = sessao.getMomentoAbertura();
        this.momentoEncerramento = sessao.getMomentoEncerramento();
        this.totalVotos = sessao.getTotalVotos();
        this.totalSim = sessao.getTotalSim();
        this.totalNao = sessao.getTotalNao();
    }
}
