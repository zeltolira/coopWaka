package academy.wakanda.coopwaka.pauta.application.api;

import academy.wakanda.coopwaka.pauta.application.service.Pautaservice;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PautaController implements PautaAPI {
    private final Pautaservice pautaService;

    @Override
    public PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta) {
        log.info("[start] PautaController - cadastrarPauta");
        PautaCadastradaResponse pautaCadastrada = pautaService.cadastraPauta(novaPauta);
        log.info("[finish] PautaController - cadastrarPauta");
        return pautaCadastrada;
    }
}
