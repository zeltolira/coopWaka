package academy.wakanda.coopwaka.SessaoVotacao.domain;

import academy.wakanda.coopwaka.SessaoVotacao.application.api.ResultadoSessaoResponse;
import academy.wakanda.coopwaka.SessaoVotacao.application.api.SessaoAberturaRequest;
import academy.wakanda.coopwaka.SessaoVotacao.application.api.VotoRequest;
import academy.wakanda.coopwaka.associado.application.service.AssociadoService;
import academy.wakanda.coopwaka.pauta.domain.Pauta;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class SessaoVotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private UUID idPauta;
    private Integer tempoDuracao;
    @Enumerated(EnumType.STRING)
    private StatusSessaoVotacao status;
    private LocalDateTime momentoAbertura;
    private LocalDateTime momentoEncerramento;

    @OneToMany(
            mappedBy = "sessaoVotacao",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @MapKey(name = "cpfAssociado")
    private Map<String, VotoPauta> votos;

    public SessaoVotacao(SessaoAberturaRequest sessaoAberturaRequest, Pauta pauta) {
        this.idPauta = pauta.getId();
        this.tempoDuracao = sessaoAberturaRequest.getTempoDuracao().orElse(1);
        this.momentoAbertura = LocalDateTime.now();
        this.momentoEncerramento = momentoAbertura.plusMinutes(this.tempoDuracao);
        this.status = StatusSessaoVotacao.ABERTA;
        votos = new HashMap<>();
    }

    public VotoPauta recebeVoto(VotoRequest votoRequest, AssociadoService associadoService, PublicadorResultadoSessao publicadorResultadoSessao){
        validaSessaoAberta(publicadorResultadoSessao);
        validaAssociado(votoRequest.getCpfAssociado(), associadoService);
        VotoPauta voto = new VotoPauta(this, votoRequest);
        votos.put(votoRequest.getCpfAssociado(), voto);
        return voto;
    }

    private void validaSessaoAberta(PublicadorResultadoSessao publicadorResultadoSessao) {
        atualizaStatus(publicadorResultadoSessao);
        if (this.status.equals(StatusSessaoVotacao.FECHADA)){
            throw new RuntimeException("Sessão está fechada!");
        }
    }

    void atualizaStatus(PublicadorResultadoSessao publicadorResultadoSessao) {
        if (this.status.equals(StatusSessaoVotacao.ABERTA)){
            if(LocalDateTime.now().isAfter(this.momentoEncerramento)){
                fechaSessao(publicadorResultadoSessao);
            }
        }
    }

    void fechaSessao(PublicadorResultadoSessao publicadorResultadoSessao) {
        this.status = StatusSessaoVotacao.FECHADA;
        publicadorResultadoSessao.publica(new ResultadoSessaoResponse(this));
    }

    void validaAssociado(String cpfAssociado, AssociadoService associadoService) {
        associadoService.validaAssociadoAptoVoto(cpfAssociado);
        validaVotoDuplicado(cpfAssociado);
    }
    void validaVotoDuplicado(String cpfAssosciado) {
        if (this.votos.containsKey(cpfAssosciado)) {
            throw new RuntimeException("Associado Já votou nessa Sessão!");
        }
    }

    public ResultadoSessaoResponse obtemResultado(PublicadorResultadoSessao publicadorResultadoSessao) {
        atualizaStatus(publicadorResultadoSessao);
        return new ResultadoSessaoResponse(this);
    }

    public Long getTotalVotos() {
        return Long.valueOf(this.votos.size());
    }

    public Long getTotalSim() {

        return calculaVotosPorOpcao(OpcaoVoto.SIM);
    }

    public Long getTotalNao() {

        return calculaVotosPorOpcao(OpcaoVoto.NAO);
    }

    private Long calculaVotosPorOpcao(OpcaoVoto opcao) {
        return votos.values().stream()
                .filter(voto -> voto.opcaoIgual(opcao))
                .count();
    }
}
