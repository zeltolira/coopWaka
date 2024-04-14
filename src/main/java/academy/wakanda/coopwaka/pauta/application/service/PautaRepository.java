package academy.wakanda.coopwaka.pauta.application.service;

import academy.wakanda.coopwaka.pauta.domain.Pauta;

import java.util.UUID;

public interface PautaRepository {
    Pauta salva(Pauta pauta);
    Pauta buscaPautaPorId(UUID idPauta);
}
