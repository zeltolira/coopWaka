package academy.wakanda.coopwaka.pauta.application.service;

import academy.wakanda.coopwaka.pauta.application.api.NovaPautaRequest;
import academy.wakanda.coopwaka.pauta.application.api.PautaCadastradaResponse;
import academy.wakanda.coopwaka.pauta.domain.Pauta;

import java.util.UUID;

public interface PautaService {
    PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta);

    Pauta getPautaPorId(UUID idPauta);
}
