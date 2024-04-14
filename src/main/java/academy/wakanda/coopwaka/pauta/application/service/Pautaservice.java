package academy.wakanda.coopwaka.pauta.application.service;

import academy.wakanda.coopwaka.pauta.application.api.NovaPautaRequest;
import academy.wakanda.coopwaka.pauta.application.api.PautaCadastradaResponse;

public interface Pautaservice {
    PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta);
}
