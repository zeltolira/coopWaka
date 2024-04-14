package academy.wakanda.coopwaka.pauta.application.service;

import academy.wakanda.coopwaka.pauta.application.api.NovaPautaRequest;
import academy.wakanda.coopwaka.pauta.application.api.PautaCadastradaResponse;

public interface PautaService {
    PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta);
}
